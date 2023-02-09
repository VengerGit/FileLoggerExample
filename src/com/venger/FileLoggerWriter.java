package com.venger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

public class FileLoggerWriter {
    private final LoggerFormatter formatter;
    private final FileLoggerConfiguration configuration;

    public FileLoggerWriter(FileLoggerConfiguration configuration) {
        this.configuration = new FileLoggerConfiguration(configuration.getWriteToFile(),
                configuration.getLevel(),
                configuration.getMaxSize(),
                configuration.getFormat());
        formatter = new LoggerFormatter(configuration.getFormat());
    }

    public void write(Path path, String message) {
        write(path.toFile(), message);
    }

    public void write(File file, String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(formatter.format(new Date(), configuration.getLevel(), message));
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            throw new RuntimeException("SWW", ex);
        }
    }
}
