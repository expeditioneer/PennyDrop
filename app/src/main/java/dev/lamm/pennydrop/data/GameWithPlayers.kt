package dev.lamm.pennydrop.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import dev.lamm.pennydrop.types.Player

data class GameWithPlayers(
    @Embedded val game: Game,
    @Relation(
        parentColumn = "gameId",
        entityColumn = "playerId",
        associateBy = Junction(GameStatus::class)
    )
    val players: List<Player>
)