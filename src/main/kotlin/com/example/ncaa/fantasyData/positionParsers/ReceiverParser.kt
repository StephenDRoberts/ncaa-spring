package com.example.ncaa.fantasyData.positionParsers

import com.example.ncaa.fantasyData.models.ReceiverModel
import com.example.ncaa.fantasyData.positionParsers.PositionParser
import org.apache.commons.csv.CSVRecord
import org.springframework.stereotype.Component
import java.lang.Byte.parseByte
import java.lang.Float.parseFloat
import java.lang.Short.parseShort

@Component
class ReceiverParser : PositionParser<ReceiverModel> {
    override val positionCodes = listOf("WR", "TE")

    override fun parse(record: CSVRecord): ReceiverModel {
        return ReceiverModel(
            rank = parseShort(record.get(0)),
            playerId = record.get(1),
            playerName = record.get(2),
            team = record.get(3),
            position = record.get(4),
            week = parseByte(record.get(5)),
            opponent = record.get(6),
            receptions = parseShort(record.get(7)),
            receivingYards = parseShort(record.get(8)),
            receivingTouchdowns = parseShort(record.get(9)),
            receivingLong = parseShort(record.get(10)),
            receivingYardsPerReception = parseFloat(record.get(11)),
            rushingAttempts = parseShort(record.get(12)),
            rushingYards = parseShort(record.get(13)),
            rushingYardsPerAttempt = parseFloat(record.get(14)),
            rushingTouchdowns = parseShort(record.get(15)),
            fumbles = parseByte(record.get(16)),
            fumblesLost = parseByte(record.get(17)),
            fantasyPoints = parseFloat(record.get(18))
        )
    }
}
