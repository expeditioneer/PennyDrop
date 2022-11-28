package dev.lamm.pennydrop.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lamm.pennydrop.types.Player
import dev.lamm.pennydrop.types.Slot

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

    fun startGame(playersForNewGame: List<Player>) {
        this.players = playersForNewGame
        this.currentPlayer.value =
            this.players.firstOrNull().apply {
                this?.isRolling = true
            }
        this.canRoll.value = true
    }

    fun roll() {
        // TBD
    }

    fun pass() {
        // TBD
    }
}