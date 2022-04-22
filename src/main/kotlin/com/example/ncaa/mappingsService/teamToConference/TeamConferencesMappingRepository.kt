package com.example.ncaa.mappingsService.teamToConference

import com.example.ncaa.mappingsService.teamToConference.model.TeamConferenceDTO
import mu.KLogging
import org.intellij.lang.annotations.Language
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class TeamConferencesMappingRepository(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) {

    fun strikeMappingsToDB(records: MutableList<TeamConferenceDTO>) {
        logger.info { "Striking fixtures to Database" }

        val valuesToInsert: MutableList<Map<String, String?>> = mutableListOf()

        valuesToInsert.add(
            mapOf(
                "fantasyDataTeamName" to "ALA",
                "sportsReferenceTeamNameLong" to "Alabama",
                "sportsReferenceTeamNameShort" to "Alabama",
                "conference2021" to "SEC (West)",
                "conference2020" to "SEC (West)",
                "conference2019" to "SEC (West)",
                "conference2018" to "SEC (West)",
                "conference2017" to "SEC (West)",
                "conference2016" to "SEC (West)",
                "conference2015" to "SEC (West)"
            )
        )

        for (record in records) {
            valuesToInsert.add(
                mapOf(
                    "fantasyDataTeamName" to record.fantasyDataTeamName,
                    "sportsReferenceTeamNameLong" to record.sportsReferenceTeamNameLong,
                    "sportsReferenceTeamNameShort" to record.sportsReferenceTeamNameShort,
                    "conference2021" to record.conference2021,
                    "conference2020" to record.conference2020,
                    "conference2019" to record.conference2019,
                    "conference2018" to record.conference2018,
                    "conference2017" to record.conference2017,
                    "conference2016" to record.conference2016,
                    "conference2015" to record.conference2015
                )
            )
        }
        namedParameterJdbcTemplate.batchUpdate(
            INSERT_MAPPINGS,
            valuesToInsert.toTypedArray()
        )
    }

    private companion object : KLogging() {
        @Language("MySQL")
        const val INSERT_MAPPINGS =
            """
            INSERT INTO teamConferences
            (
            fantasyDataTeamName,
            sportsReferenceTeamNameLong,
            sportsReferenceTeamNameShort,
            conference2021,
            conference2020,
            conference2019,
            conference2018,
            conference2017,
            conference2016,
            conference2015
            )
            VALUES
            (
            :fantasyDataTeamName,
            :sportsReferenceTeamNameLong,
            :sportsReferenceTeamNameShort,
            :conference2021,
            :conference2020,
            :conference2019,
            :conference2018,
            :conference2017,
            :conference2016,
            :conference2015
            )
            ON DUPLICATE KEY UPDATE fantasyDataTeamName = :fantasyDataTeamName
            """
    }
}