package com.example.ncaa.mappingsService.teamToConference

import com.example.ncaa.mappingsService.teamToConference.model.TeamConferenceModel
import org.apache.commons.csv.CSVRecord
import org.springframework.stereotype.Component

@Component
class TeamConferenceParser {

    fun parse(record: CSVRecord): TeamConferenceModel {
        return TeamConferenceModel(
            fantasyDataTeamName = record.get(0),
            sportsReferenceTeamNameLong = record.get(1),
            sportsReferenceTeamNameShort = record.get(2),
            conference2015 = record.get(3),
            conference2016 = record.get(4),
            conference2017 = record.get(5),
            conference2018 = record.get(6),
            conference2019 = record.get(7),
            conference2020 = record.get(8),
            conference2021 = record.get(9),
        )
    }
}