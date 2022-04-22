package com.example.ncaa.mappingsService.teamToConference.model

data class TeamConferenceDTO(
    val fantasyDataTeamName: String,
    val sportsReferenceTeamNameLong: String,
    val sportsReferenceTeamNameShort: String,
    val conference2021: String? = null,
    val conference2020: String? = null,
    val conference2019: String? = null,
    val conference2018: String? = null,
    val conference2017: String? = null,
    val conference2016: String? = null,
    val conference2015: String? = null
)
