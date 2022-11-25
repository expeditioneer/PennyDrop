package dev.lamm.pennydrop.game

data class AI(val name: String) {
    override fun toString() = name

    companion object {
        @JvmStatic
        val basicAI = listOf(
            AI("Two Face"),
            AI("No Go Noah"),
            AI("Bail out Beulah"),
            AI("Fearful Fred"),
            AI("Even Steven"),
            AI("Riverboat Ron"),
            AI("Sammy Sixes"),
            AI("Random Rachel")
        )
    }
}