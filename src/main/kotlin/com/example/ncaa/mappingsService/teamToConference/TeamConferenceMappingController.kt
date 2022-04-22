package com.example.ncaa.mappingsService.teamToConference

import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TeamConferenceMappingController(
    private val teamConferenceMappingService: TeamConferenceMappingService
) {

    @GetMapping("/mappings")
    fun insertMappings(){
        logger.info { "In the controller" }
        teamConferenceMappingService.processAllMappings()
    }

    private companion object: KLogging()
}