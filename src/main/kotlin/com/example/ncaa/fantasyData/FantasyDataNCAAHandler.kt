package com.example.ncaa.fantasyData

import com.example.ncaa.FileReader
import com.example.ncaa.fantasyData.models.PlayerGameDataDTO
import com.example.ncaa.fantasyData.positionParsers.QuarterbackParser
import com.example.ncaa.fantasyData.positionParsers.ReceiverParser
import com.example.ncaa.fantasyData.positionParsers.RunningbackParser
import com.example.ncaa.mappingsService.teamToConference.model.TeamConferenceDTO
import mu.KLogging
import org.intellij.lang.annotations.Language
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Paths
import kotlin.reflect.full.memberProperties

@RestController
class FantasyDataNCAAHandler(
    private val reader: FileReader,
    private val qbParser: QuarterbackParser,
    private val rbParser: RunningbackParser,
    private val receiverParser: ReceiverParser,
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate

) {

    @GetMapping("/processPlayers")
    fun processRecords() {
        val playerFiles = listOf(
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/QB/001_FD_QB_2021_Wk01.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/QB/002_FD_QB_2021_Wk02.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/QB/003_FD_QB_2021_Wk03.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/RB/001_FD_RB_2021_Wk01.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/WR/001_FD_WR_2021_Wk01.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/TE/001_FD_TE_2021_Wk01.csv",
        )

        val players = parsePlayersToPositionDTO(playerFiles)

        val teamConferenceMappings = getTeamConferenceMappings()

        println(teamConferenceMappings)

        for (player in players) {
            println(player)
            val mapping = teamConferenceMappings.firstOrNull { it ->
                it.fantasyDataTeamName == player.getField("team")
            }?.conference2021

            println(mapping)
        }

        println(players.size)
    }

    fun parsePlayersToPositionDTO(filepaths: List<String>): List<Any> {
        val parsers = listOf(qbParser, rbParser, receiverParser)
        val players = mutableListOf<Any>()

        for (filepath in filepaths) {
            for (positionParser in parsers) {
                if (positionParser.canParse(filepath)) {
                    val parser = reader.parseCsv(Paths.get(filepath))

                    parser.map { csvRecord ->
                        val parsedPlayer = positionParser.parse(csvRecord)
//                        println(parsedPlayer)
                        players.add(parsedPlayer)
                    }
                    break
                }
            }
        }
        return players
    }

    fun getTeamConferenceMappings(): List<TeamConferenceDTO> =
        namedParameterJdbcTemplate.query(GET_MAPPINGS) { rs, _ ->
            TeamConferenceDTO(
                fantasyDataTeamName = rs.getString("fantasyDataTeamName"),
                sportsReferenceTeamNameLong = rs.getString("sportsReferenceTeamNameLong"),
                sportsReferenceTeamNameShort = rs.getString("sportsReferenceTeamNameShort"),
                conference2021 = rs.getString("conference2021"),
                conference2020 = rs.getString("conference2020"),
                conference2019 = rs.getString("conference2019"),
                conference2018 = rs.getString("conference2018"),
                conference2017 = rs.getString("conference2017"),
                conference2016 = rs.getString("conference2016"),
                conference2015 = rs.getString("conference2015")
            )
        }

    @Throws(IllegalAccessException::class, ClassCastException::class)
    private inline fun <reified T> Any.getField(fieldName: String): T? {
        this::class.memberProperties.forEach { kCallable ->
            if (fieldName == kCallable.name) {
                return kCallable.getter.call(this) as T?
            }
        }
        return null
    }

    private companion object : KLogging() {
        @Language("MySQL")
        const val GET_MAPPINGS =
            """
                SELECT * FROM teamConferences;
            """
    }
}