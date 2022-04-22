package com.example.ncaa.fantasyData

import com.example.ncaa.FileReader
import com.example.ncaa.fantasyData.positionParsers.QuarterbackParser
import com.example.ncaa.fantasyData.positionParsers.ReceiverParser
import com.example.ncaa.fantasyData.positionParsers.RunningbackParser
import org.junit.jupiter.api.Test

internal class FantasyDataNCAAHandlerTest(){
    private val reader = FileReader()
    private val qbParser = QuarterbackParser()
    private val rbParser = RunningbackParser()
    private val receiverParser = ReceiverParser()

    private val underTest = FantasyDataNCAAHandler(reader, qbParser, rbParser, receiverParser)

    @Test
    fun `should say hello`() {
        underTest.processRecords()
    }
}