package dev.lamm.pennydrop.viewmodels

import androidx.lifecycle.ViewModel
import dev.lamm.pennydrop.types.Player

class GameViewModel: ViewModel() {
    private var players: List<Player> = emptyList()

    fun startGame(playersForNewGame: List<Player>) {
        this.players = playersForNewGame
    }
}