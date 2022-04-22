package com.example.ncaa

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Component
class FileReader() {

//    fun getAllFilesInDirectory(directory: String): List<Path> {
//        return Files.walk(Paths.get(directory))
//            .filter { filepath -> Files.isRegularFile(filepath) }
//            .toList()
//    }

    fun parseCsv(path: Path): CSVParser {
        val reader = Files.newBufferedReader(path)
        val format = CSVFormat.Builder.create()
            .setHeader()
            .setSkipHeaderRecord(true).build()
        return CSVParser(reader, format)
    }

//    fun readFiles(directory: String) {
//        val files = getAllFilesInDirectory(directory)
//
//        for (file in files) {
//            parseCsv(file)
//        }
//    }

}