package com.venger;

import java.nio.file.Path;

public final class CheckSizeFileLogger {

    private CheckSizeFileLogger() {
    }

    public static void checkFileSize(long maxSize, long lengthFile, Path path) {
        if (lengthFile > maxSize) {
            throw new FileMaxSizeReachedException(
                    String.format("File has max size [%s] Now File [%s] Path to file [%s] ",
                            maxSize,
                            lengthFile, path
                    )
            );

        }
    }

}
