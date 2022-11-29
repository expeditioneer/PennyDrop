package dev.lamm.pennydrop.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lamm.pennydrop.types.Player
import dev.lamm.pennydrop.types.Slot
import dev.lamm.pennydrop.types.clear

class GameViewModel : ViewModel() {
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
        // TBD
    }

    fun pass() {
        // TBD
    }
}

private fun <T> MutableLiveData<List<T>>.notifyChange() {
    this.value = this.value
}