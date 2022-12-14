package dev.lamm.pennydrop.types

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import dev.lamm.pennydrop.game.AI

@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true) var playerId: Long = 0,
    var playerName: String = "",
    var isHuman: Boolean = true,
    var selectedAI: AI? = null
) {
    @Ignore
    var pennies: Int = defaultPennyCount

    @Ignore
    var isRolling: Boolean = false

    @Ignore
    var gamePlayerNumber: Int = -1

    fun penniesLeft(subtractPenny: Boolean = false): Boolean =
        (pennies - (if(subtractPenny) 1 else 0)) > 0

    companion object {
        const val defaultPennyCount = 10
    }
}
