package com.santander.ejercicio_excepciones.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.*;

@Slf4j
public class FileUtil {

    private static final String FILE_PATH = "SOME_PATH";

    public static void writeFile(String message) {
        Path path;

        try {
            // converts URI to a Path object
            path = Paths.get(FILE_PATH);
        } catch (IllegalArgumentException e) {
            // these exceptions shouldn't be a problem, unless FILE_PATH could change dynamically
            return;
        } catch (FileSystemNotFoundException e) {
            // same as above, also this could be thrown if there is something modifying the file system
            return;
        } catch (SecurityException e) {
            // same as above
            return;
        }

        try {
            // writes the message in the file
            Files.write(path, message.getBytes(), StandardOpenOption.APPEND);
            log.info("File written");
        } catch (IllegalArgumentException e) {
            // do something
        } catch (IOException e) {
            // do something
        } catch (UnsupportedOperationException e) {
            // do something
        } catch (SecurityException e) {
            // do something
        }
    }

}
