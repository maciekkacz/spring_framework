package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

    private String fileName = "data.csv";

    List<Entry> readAllFile() throws IOException {
        return Files.readAllLines(Paths.get(fileName))
                .stream().map(CsvEntryConventer::parse)
                .collect(Collectors.toList());
    }

    private static class CsvEntryConventer {
        static Entry parse(String text) {
            String[] split = text.split(":");
            return new Entry(split[0], split[1]);
        }
    }
}
