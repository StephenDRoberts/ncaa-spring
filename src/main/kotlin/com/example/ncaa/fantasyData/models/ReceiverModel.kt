package com.example.ncaa.fantasyData.models

data class ReceiverModel(
    val rank: Short,
    val playerId: String,
    val playerName: String,
    val team: String,
    val position: String,
    val week: Byte,
    val opponent: String,
    val receptions: Short,
    val receivingYards: Short,
    val receivingTouchdowns: Short,
    val receivingLong: Short,
    val receivingYardsPerReception: Float,
    val rushingAttempts: Short,
    val rushingYards: Short,
    val rushingYardsPerAttempt: Float,
    val rushingTouchdowns: Short,
    val fumbles: Byte,
    val fumblesLost: Byte,
    val fantasyPoints: Float
)
