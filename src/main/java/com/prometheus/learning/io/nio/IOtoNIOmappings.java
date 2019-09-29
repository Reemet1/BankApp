package com.prometheus.learning.io.nio;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class IOtoNIOmappings {


    public void ioToNioMappings() {

        /** java.io.File <--> java.nio.Path */
        File file = new File("");
        Path path = file.toPath();
        file = path.toFile();

        //Files.delete();
        //file.delete();

        /** Working directory */
        File workingDir = new File("").getAbsoluteFile();
        FileSystems.getDefault();

        /** File list */
        workingDir.list();
    }
}
