package com.example.ncaa.fantasyData.positionParsers

import org.apache.commons.csv.CSVRecord
import java.nio.file.Paths
import kotlin.io.path.nameWithoutExtension

interface PositionParser<T> {

    val positionCodes: List<String>

    fun canParse(filename: String): Boolean = positionCodes.contains(getPositionCode(filename))

    fun parse(record: CSVRecord): T

    fun getPositionCode(filename: String): String {
        val filelnameWithoutExtension = getFileNameWithoutExtension(filename)
        val filenameComponents = filelnameWithoutExtension.split("_")
        return filenameComponents[2]
    }

    private fun getFileNameWithoutExtension(filename: String): String = Paths.get(filename).nameWithoutExtension

}