package com.venger;

import java.nio.file.Path;

public final class FileLoggerConfiguration {
    private final Path writeToFile;
    private final LoggingLevel level;
    private final long maxSize;
    private final String format;

    public FileLoggerConfiguration(Path writeToFile, LoggingLevel level, long maxSize, String format) {
        this.writeToFile = writeToFile;
        this.level = level;
        this.maxSize = maxSize;
        this.format = format;
    }

    public Path getWriteToFile() {
        return writeToFile;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFormat() {
        return format;
    }
}
