package com.example.ncaa.mappingsService.teamToConference.model

import org.springframework.stereotype.Component

@Component
class TeamConferenceDTOConverter {

    fun convert(model: TeamConferenceModel): TeamConferenceDTO {
        val (fantasyDataTeamName,
            sportsReferenceTeamNameLong,
            sportsReferenceTeamNameShort,
            conference2021,
            conference2020,
            conference2019,
            conference2018,
            conference2017,
            conference2016,
            conference2015
        ) = model

        return TeamConferenceDTO(
            fantasyDataTeamName = fantasyDataTeamName,
            sportsReferenceTeamNameLong = if (sportsReferenceTeamNameLong == "#N/A") sportsReferenceTeamNameShort else sportsReferenceTeamNameLong,
            sportsReferenceTeamNameShort = sportsReferenceTeamNameShort,
            conference2021 = if (conference2021 == "#N/A") null else conference2021,
            conference2020 = if (conference2020 == "#N/A") null else conference2020,
            conference2019 = if (conference2019 == "#N/A") null else conference2019,
            conference2018 = if (conference2018 == "#N/A") null else conference2018,
            conference2017 = if (conference2017 == "#N/A") null else conference2017,
            conference2016 = if (conference2016 == "#N/A") null else conference2016,
            conference2015 = if (conference2015 == "#N/A") null else conference2015,
        )
    }
}