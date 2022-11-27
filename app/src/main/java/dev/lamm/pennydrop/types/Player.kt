package dev.lamm.pennydrop.types

import dev.lamm.pennydrop.game.AI

class Player(
    val playerName: String = "",
    val isHuman: Boolean = true,
    val selectedAI: AI? = null
) {
    var pennies: Int = defaultPennyCount

    fun addPennies(count: Int = 1){
        pennies += count
    }

    var isRolling: Boolean = false

    companion object {
        const val defaultPennyCount = 10
    }
}