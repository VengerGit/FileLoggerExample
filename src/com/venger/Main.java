package com.venger;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(
                Path.of(".","logging.out"),
                LoggingLevel.DEBUG,
                10000, "[{date}] [{level}] Massage:{msg}");

        FileLogger fileLogger = new FileLogger(fileLoggerConfiguration);
        fileLogger.debug("test");
    }
}
