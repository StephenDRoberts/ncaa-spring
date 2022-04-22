package com.example.ncaa.fantasyData.models

data class QuarterbackModel(
    val rank: Short,
    val playerId: String,
    val playerName: String,
    val team: String,
    val position: String,
    val week: Byte,
    val opponent: String,
    val passingCompletions: Short,
    val passingAttempts: Short,
    val passingCompletionPercentage: Float,
    val passingYards: Short,
    val passingYardsPerAttempt: Float,
    val passingTouchdowns: Short,
    val passingInterceptions: Short,
    val passingRating: Float,
    val rushingAttempts: Short,
    val rushingYards: Short,
    val rushingYardsPerAttempt: Float,
    val rushingTouchdowns: Short,
    val fantasyPoints: Float
)
