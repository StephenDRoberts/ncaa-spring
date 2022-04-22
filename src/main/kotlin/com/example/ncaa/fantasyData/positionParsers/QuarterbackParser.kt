package com.example.ncaa.fantasyData.positionParsers

import com.example.ncaa.fantasyData.models.QuarterbackModel
import com.example.ncaa.fantasyData.positionParsers.PositionParser
import org.apache.commons.csv.CSVRecord
import org.springframework.stereotype.Component
import java.lang.Byte.parseByte
import java.lang.Float.parseFloat
import java.lang.Short.parseShort

@Component
class QuarterbackParser : PositionParser<QuarterbackModel> {
    override val positionCodes = listOf("QB")

    override fun parse(record: CSVRecord): QuarterbackModel {
        return QuarterbackModel(
            rank = parseShort(record.get(0)),
            playerId = record.get(1),
            playerName = record.get(2),
            team = record.get(3),
            position = record.get(4),
            week = parseByte(record.get(5)),
            opponent = record.get(6),
            passingCompletions = parseShort(record.get(7)),
            passingAttempts = parseShort(record.get(8)),
            passingCompletionPercentage = parseFloat(record.get(9)),
            passingYards = parseShort(record.get(10)),
            passingYardsPerAttempt = parseFloat(record.get(11)),
            passingTouchdowns = parseShort(record.get(12)),
            passingInterceptions = parseShort(record.get(13)),
            passingRating = parseFloat(record.get(14)),
            rushingAttempts = parseShort(record.get(15)),
            rushingYards = parseShort(record.get(16)),
            rushingYardsPerAttempt = parseFloat(record.get(17)),
            rushingTouchdowns = parseShort(record.get(18)),
            fantasyPoints = parseFloat(record.get(19)),
        )
    }

}
