package dev.lamm.pennydrop.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lamm.pennydrop.game.GameHandler
import dev.lamm.pennydrop.game.TurnEnd
import dev.lamm.pennydrop.game.TurnResult
import dev.lamm.pennydrop.types.Player
import dev.lamm.pennydrop.types.Slot
import dev.lamm.pennydrop.types.clear

class GameViewModel : ViewModel() {
    private var clearText = false
    private var players: List<Player> = emptyList()

    val slots = MutableLiveData((1..6).map { slotNum ->
        Slot(slotNum, slotNum != 6)
    })

    val currentPlayer = MutableLiveData<Player?>()

    val canRoll = MutableLiveData(false)
    val canPass = MutableLiveData(false)

    val currentTurnText = MutableLiveData("")
    val currentStandingText = MutableLiveData("")

    private fun generateCurrentStandings(
        players: List<Player>,
        headerText: String = "Current Standings:"
    ) = players.sortedBy { it.pennies }
        .joinToString(separator = "\n", prefix = "$headerText\n") {
            "\t${it.playerName} - ${it.pennies} pennies"
        }

    private fun updateSlots(
        result: TurnResult,
        currentSlots: List<Slot>,
        lastRoll: Int
    ) {
        if (result.clearSlots) {
            currentSlots.clear()
        }

        currentSlots.firstOrNull { it.lastRolled }?.apply { lastRolled = false }

        currentSlots.getOrNull(lastRoll - 1)?.also { slot ->
            if (!result.clearSlots && slot.canBeFilled) slot.isFilled = true

            slot.lastRolled = true
        }

        slots.notifyChange()
    }

    private fun generateTurnText(result: TurnResult): String {
        if (clearText) currentTurnText.value = ""
        clearText = result.turnEnd != null

        val currenText = currentTurnText.value ?: ""
        val currentPlayerName = result.currentPlayer?.playerName ?: "???"

        return when {
            result.isGameOver ->
                """
                    |Game over
                    |$currentPlayerName is the winner!
                    |
                    |${generateCurrentStandings(this.players, "Final scores:\n")}
                    }}
                """.trimMargin()
            result.turnEnd == TurnEnd.Bust -> "$currenText\n$currentPlayerName is busted."
            result.turnEnd == TurnEnd.Pass -> "$currenText\n$currentPlayerName passes."
            result.lastRoll != null -> "$currenText\n$currentPlayerName rolled a ${result.lastRoll}."
            else -> ""
        }
    }

    private fun updateFromGameHandler(result: TurnResult) {
        if (result.currentPlayer != null) {
            currentPlayer.value?.addPennies(result.coinChangeCount ?: 0)
            currentPlayer.value = result.currentPlayer
            this.players.forEach { player ->
                player.isRolling = result.currentPlayer == player
            }
        }

        if (result.lastRoll != null) {
            slots.value?.let { currentSlots ->
                updateSlots(result, currentSlots, result.lastRoll)
            }
        }

        currentTurnText.value = generateTurnText(result)
        currentStandingText.value = generateCurrentStandings(this.players)

        canRoll.value = result.canRoll
        canPass.value = result.canPass

        if (!result.isGameOver && result.currentPlayer?.isHuman == false) {
            canRoll.value = false
            canPass.value = false
        }
    }

    fun startGame(playersForNewGame: List<Player>) {
        this.players = playersForNewGame
        this.currentPlayer.value = this.players.firstOrNull().apply {
            this?.isRolling = true
        }

        canRoll.value = true
        canPass.value = false

        slots.value?.clear()
        slots.notifyChange()

        currentTurnText.value = "The game has begun!\n"
        currentStandingText.value = generateCurrentStandings(this.players)
    }

    fun roll() {
        slots.value?.let { currentSlots ->
            val currentPlayer = players.firstOrNull { it.isRolling }
            if (currentPlayer != null && canPass.value == true) {
                updateFromGameHandler(GameHandler.roll(players, currentPlayer, currentSlots))
            }
        }
    }

    fun pass() {
        val currentPlayer = players.firstOrNull { it.isRolling }
        if (currentPlayer != null && canPass.value == true) {
            updateFromGameHandler(GameHandler.pass(players, currentPlayer))
        }
    }
}

private fun <T> MutableLiveData<List<T>>.notifyChange() {
    this.value = this.value
}
