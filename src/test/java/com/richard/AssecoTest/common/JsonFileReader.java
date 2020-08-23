package com.richard.AssecoTest.common;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class JsonFileReader {

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/" + file + ".json")));
    }
}
