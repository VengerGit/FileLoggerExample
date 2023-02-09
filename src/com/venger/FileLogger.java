package com.venger;

import java.io.File;

public class FileLogger {
    private final FileLoggerConfiguration configuration;
    private final FileLoggerWriter writer;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        this.writer = new FileLoggerWriter(configuration);
    }

    public void debug(String message) {
        File file = configuration.getWriteToFile().toFile();
        CheckSizeFileLogger.checkFileSize(
                configuration.getMaxSize(), file.length() + message.length(),
                configuration.getWriteToFile());
        writer.write(file.toPath(), message);
    }

    public void info(String message) {
        File file = configuration.getWriteToFile().toFile();
        CheckSizeFileLogger.checkFileSize(configuration.getMaxSize(), file.length() + message.length(),
                configuration.getWriteToFile());
        writer.write(file.toPath(), message);
    }

}