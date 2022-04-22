package com.example.ncaa.fantasyData.positionParsers

import com.example.ncaa.fantasyData.models.RunningbackModel
import com.example.ncaa.fantasyData.positionParsers.PositionParser
import org.apache.commons.csv.CSVRecord
import org.springframework.stereotype.Component
import java.lang.Byte.parseByte
import java.lang.Float.parseFloat
import java.lang.Short.parseShort

@Component
class RunningbackParser : PositionParser<RunningbackModel> {
    override val positionCodes = listOf("RB")

    override fun parse(record: CSVRecord): RunningbackModel {
        return RunningbackModel(
            rank = parseShort(record.get(0)),
            playerId = record.get(1),
            playerName = record.get(2),
            team = record.get(3),
            position = record.get(4),
            week = parseByte(record.get(5)),
            opponent = record.get(6),
            rushingAttempts = parseShort(record.get(7)),
            rushingYards = parseShort(record.get(8)),
            rushingYardsPerAttempt = parseFloat(record.get(9)),
            rushingTouchdowns = parseShort(record.get(10)),
            receptions = parseShort(record.get(11)),
            receivingYards = parseShort(record.get(12)),
            receivingTouchdowns = parseShort(record.get(13)),
            fumbles = parseByte(record.get(14)),
            fumblesLost = parseByte(record.get(15)),
            fantasyPoints = parseFloat(record.get(16)),
        )
    }

}
