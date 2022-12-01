package dev.lamm.pennydrop.data

import dev.lamm.pennydrop.types.Player

class PennyDropRepository(private val pennyDropDao: PennyDropDao) {
    fun getCurrentGameWithPlayers() =
        pennyDropDao.getCurrentGameWithPlayers()

    fun getCurrentGameStatuses() =
        pennyDropDao.getCurrentGameStatuses()

    suspend fun startGame(players: List<Player>) =
        pennyDropDao.startGame(players)

    suspend fun updateGameAndStatuses(
        game: Game,
        statuses: List<GameStatus>
    ) = pennyDropDao.updateGameAndStatuses(game, statuses)
}