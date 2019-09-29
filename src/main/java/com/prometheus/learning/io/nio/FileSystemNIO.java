package com.prometheus.learning.io.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Classes to copy, delete, move files are in java.io.file package
 */

public class FileSystemNIO {

    public void paths() {

        /** Path is used to identify a file or directory (folder) on a file system. Hard drives,
         * external drives, peripheral drives, etc are called root folders (nodes). General path
         * rootNode:\folderNode1\...\folderNodeN/fileNode */

        /** Relative path (is combined with the absolute path of a working directory) */
        Path relativePath = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\niodata.txt");

        /** Absolute path */
        Path absolutePath = Paths.get("C:\\\\Users\\Reemet\\Desktop\\Learning\\src\\main\\java\\learning\\io\\nio\\niodata.txt");


        /** the '.' in absolute path resolves to current working directory */
        Path workingDir = Paths.get(".\\src\\main\\java\\learning\\io\\nio\\niodata.txt");
        System.out.println(workingDir.toAbsolutePath());
        System.out.println("Normalized: " + workingDir.toAbsolutePath().normalize());

        /** Building path by pieces */
        workingDir = Paths.get(".", "\\src\\main\\java\\learning", "\\io\\nio\\", "niodata.txt");
        System.out.println(workingDir.toAbsolutePath());
        System.out.println("Normalized: " + workingDir.toAbsolutePath().normalize());

        /** For platform independence, use separator constant instead of hardcoded / or \\ */
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        StringBuilder properPathStr = new StringBuilder();
        properPathStr.append("src").append(separator)
                     .append("main").append(separator)
                     .append("java").append(separator)
                     .append("learning").append(separator)
                     .append("io").append(separator)
                     .append("nio").append(separator)
                     .append("niodata.txt");

        Path properPath = FileSystems.getDefault().getPath(properPathStr.toString());


    }

    public void fileOperations() {

        /** Files.exists checks if a given directory exists */
        Path path = FileSystems.getDefault().getPath("nonexistentfile.txt");
        boolean fileExists = Files.exists(path);
        System.out.println(path.toAbsolutePath().normalize() + " exists: " + fileExists);

        path = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\niodata.txt");
        fileExists = Files.exists(path);
        System.out.println(path.toAbsolutePath().normalize() + " exists: " + fileExists);

        /** Checks file permission */
        boolean isReadable = Files.isReadable(path);
        boolean isWritable = Files.isWritable(path);
        boolean isExecutable = Files.isExecutable(path);
        System.out.println(path.toAbsolutePath().normalize() +
                " is readable: " + fileExists + " is writable " + isWritable + " is executable " + isExecutable);


        /** Copying files */
        try {

            Path sourceFile = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\fileoperations\\sourcefile.txt");
            if(!Files.exists(sourceFile)) Files.createFile(sourceFile);
            Path copyFile = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\fileoperations\\copyfile.txt");

            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            /** Folders can also be copied */
            Path sourceFolder = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\fileoperations\\createdfolder");
            Path copyDir = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\fileoperations\\copyfolder");
            sourceFile = FileSystems.getDefault().getPath(sourceFolder+"\\sourcefile.txt");

            if(!Files.exists(sourceFolder)) Files.createDirectory(sourceFolder);
            if(!Files.exists(copyDir)) Files.createDirectory(copyDir);
            if(!Files.exists(sourceFile)) Files.createFile(sourceFile);
            //Files.createDirectories() //used to create multiple folders
            /** Files within a folder are not copied, only folder itself is copied */
            Files.copy(sourceFolder, copyDir, StandardCopyOption.REPLACE_EXISTING);

            /** Moving file (copy + delete old) */
            Files.move(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            Files.createFile(sourceFile);
            /** Deleting file. To delete a directory, it has to be empty */
            Files.deleteIfExists(sourceFile);

            /** Renaming could be done by moving the file to the same directory but with different filename */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileAttributesNIO() {

        try {
            Path filePath = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\niodata.txt");
            long size = Files.size(filePath);
            /** Getting individual file attributes */
            System.out.println("File size: " + size);
            System.out.println("Last modified: " + Files.getLastModifiedTime(filePath));

            /** Reading all file attributes */
            BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size: " + fileAttributes.size());
            System.out.println("last modified:" + fileAttributes.lastModifiedTime());
            System.out.println("Creation time: " + fileAttributes.creationTime());
            System.out.println("Is directory: " + fileAttributes.isDirectory());
            System.out.println("Is regular file: " + fileAttributes.isRegularFile());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void tempFiles() {

        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path: " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Returns drives and external drives */
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores) {
            System.out.println(store);
        }

        System.out.println("*******************");
        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        for(Path root : roots) {
            System.out.println(root);
        }

    }

    public void readDirectory() {
        Path directory = FileSystems.getDefault().getPath("src\\main\\java\\learning");

        /** Custom filter for DirectoryStream */
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path path) throws IOException {
                return Files.isRegularFile(path);
            }
        };

        /** Filter created with lambda expression */
        //DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        /** ExampleFilter out files ending with .java */
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {

            for(Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        /** Walking a file tree */
        System.out.println("Walking file tree");
        try {
            Files.walkFileTree(directory, new PrintFiles());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Copying 'createfolder' with all its content to 'copyfolder' */
        Path sourcePath = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\fileoperations\\createdfolder");
        Path copyPath = FileSystems.getDefault().getPath("src\\main\\java\\learning\\io\\nio\\fileoperations\\copyfolder\\createdfolder");

        /*try {
            Files.walkFileTree(sourcePath, new CopyFiles(sourcePath, copyPath));
        } catch (IOException e) {
            e.printStackTrace();
        } */

    }

    public class PrintFiles extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
            System.out.println(file.toAbsolutePath());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println(dir.toAbsolutePath());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Error acessing file: " +file.toAbsolutePath() + " " + exc.getMessage());
            return FileVisitResult.CONTINUE;
        }
    }

    public class CopyFiles extends SimpleFileVisitor<Path> {

        private Path sourceRoot;
        private Path targetRoot;

        public CopyFiles(Path sourceRoot, Path targetRoot) {
            this.sourceRoot = sourceRoot;
            this.targetRoot = targetRoot;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
            Path relativizedPath = sourceRoot.relativize(file);
            System.out.println("Relativized path = " + relativizedPath);
            Path copyDir = targetRoot.resolve(relativizedPath);
            System.out.println("Resolved path to copy: " + copyDir);

            try {
                Files.copy(file, copyDir, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Path relativizedPath = sourceRoot.relativize(dir);
            System.out.println("Relativized path = " + relativizedPath);
            Path copyDir = targetRoot.resolve(relativizedPath);
            System.out.println("Resolved path to copy: " + copyDir);

            try {
                Files.copy(dir, copyDir, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
                return FileVisitResult.SKIP_SUBTREE;
            }

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Error acessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
            return FileVisitResult.CONTINUE;
        }

    }

}
