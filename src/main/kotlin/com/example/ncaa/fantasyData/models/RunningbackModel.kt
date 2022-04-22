package com.example.ncaa.fantasyData.models

data class RunningbackModel(
    val rank: Short,
    val playerId: String,
    val playerName: String,
    val team: String,
    val position: String,
    val week: Byte,
    val opponent: String,
    val rushingAttempts: Short,
    val rushingYards: Short,
    val rushingYardsPerAttempt: Float,
    val rushingTouchdowns: Short,
    val receptions: Short,
    val receivingYards: Short,
    val receivingTouchdowns: Short,
    val fumbles: Byte,
    val fumblesLost: Byte,
    val fantasyPoints: Float
)
