package com.example.ncaa.mappingsService.teamToConference

import com.example.ncaa.FileReader
import com.example.ncaa.mappingsService.teamToConference.model.TeamConferenceDTO
import com.example.ncaa.mappingsService.teamToConference.model.TeamConferenceDTOConverter
import org.springframework.stereotype.Service
import java.nio.file.Paths

private const val teamConferenceMappingFile =
    "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/mappings/TeamMappings.csv"

@Service
class TeamConferenceMappingService(
    private val reader: FileReader,
    private val teamConferenceParser: TeamConferenceParser,
    private val teamConferenceDTOConverter: TeamConferenceDTOConverter,
    private val teamConferencesMappingRepository: TeamConferencesMappingRepository
) {
    fun processAllMappings() {
        val parser = reader.parseCsv(Paths.get(teamConferenceMappingFile))
        val parsedRecords = mutableListOf<TeamConferenceDTO>()

        parser.map { csvRecord ->
            val teamDetailModel = teamConferenceParser.parse(csvRecord)
            val teamDetailDTO = teamConferenceDTOConverter.convert(teamDetailModel)
//            println(teamDetailDTO)
            parsedRecords.add(teamDetailDTO)
        }
        teamConferencesMappingRepository.strikeMappingsToDB(parsedRecords)
    }
}