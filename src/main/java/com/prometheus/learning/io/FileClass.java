package com.prometheus.learning.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

public class FileClass {

    public void file() throws IOException {

        /** File(File parent, String child) */
        // Creates a new File instance from a parent abstract pathname and a child pathname string.
        /** File(String pathname) */
        // Creates a new File instance by converting the given pathname string into an abstract pathname.
        /** File(String parent, String child) */
        // Creates a new File instance from a parent pathname string and a child pathname string.
        /** File(URI uri) */
        //Creates a new File instance by converting the given file: URI into an abstract pathname.


        String pathSeparator = File.pathSeparator; //The system-dependent path-separator character, represented as a string for convenience.
        char pathSeparatorChar = File.separatorChar; //The system-dependent path-separator character.
        String separator = File.separator; //The system-dependent default name-separator character, represented as a string for convenience.
        char separatorChar = File.separatorChar; //The system-dependent default name-separator character.


        String workingDir = System.getProperty("user.dir") + "/io/testfolder";

        File file = new File(workingDir);

        /** boolean	canExecute() */
        // Tests whether the application can execute the file denoted by this abstract pathname.
        boolean canExecute = file.canExecute();

        /** boolean	canRead() */
        // Tests whether the application can read the file denoted by this abstract pathname.
        boolean canRead = file.canRead();

        /** boolean	canWrite() */
        // Tests whether the application can modify the file denoted by this abstract pathname.
        boolean canWrite = file.canWrite();

        /** int	compareTo(File pathname) */
        // Compares two abstract pathnames lexicographically.

        /** boolean	createNewFile() */
        // Atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.

        /** static File	createTempFile(String prefix, String suffix) */
        // Creates an empty file in the default temporary-file directory, using the given prefix and suffix to generate its name.

        /** static File	createTempFile(String prefix, String suffix, File directory) */
        // Creates a new empty file in the specified directory, using the given prefix and suffix strings to generate its name.

        /** boolean	delete() */
        // Deletes the file or directory denoted by this abstract pathname.

        /** void	deleteOnExit() */
        // Requests that the file or directory denoted by this abstract pathname be deleted when the virtual machine terminates.

        /** boolean	equals(Object obj) */
        // Tests this abstract pathname for equality with the given object.

        /** boolean	exists() */
        // Tests whether the file or directory denoted by this abstract pathname exists.
        boolean fileExists = file.exists();

        /** File	getAbsoluteFile() */
        // Returns the absolute form of this abstract pathname.
        File absoluteFile = file.getAbsoluteFile();

        /** String	getAbsolutePath() */
        // Returns the absolute pathname string of this abstract pathname.
        String absolutePath = file.getAbsolutePath();

        /** File	getCanonicalFile() */
        // Returns the canonical form of this abstract pathname.
        File canonicalFile = file.getCanonicalFile();

        /** String	getCanonicalPath() */
        // Returns the canonical pathname string of this abstract pathname.
        String canonicalPath = file.getCanonicalPath();

        /** long	getFreeSpace() */
        // Returns the number of unallocated bytes in the partition named by this abstract path name.
        long freeSpace = file.getFreeSpace();

        /** String	getName() */
        // Returns the name of the file or directory denoted by this abstract pathname.
        String fileName = file.getName();

        /** String	getParent() */
        // Returns the pathname string of this abstract pathname's parent, or null if this pathname does not name a parent directory.
        String parent = file.getParent();

        /** File	getParentFile() */
        // Returns the abstract pathname of this abstract pathname's parent, or null if this pathname does not name a parent directory.
        File parentFile = file.getParentFile();

        /** String	getPath() */
        // Converts this abstract pathname into a pathname string.
        String pathName = file.getPath();

        /** long	getTotalSpace() */
        // Returns the size of the partition named by this abstract pathname.
        long totalSpace = file.getTotalSpace();

        /** long	getUsableSpace() */
        // Returns the number of bytes available to this virtual machine on the partition named by this abstract pathname.
        long usableSpace = file.getUsableSpace();

        /** int	hashCode() */
        // Computes a hash code for this abstract pathname.
        int hashCode = file.hashCode();

        /** boolean	isAbsolute() */
        // Tests whether this abstract pathname is absolute.
        boolean isAbsolute = file.isAbsolute();

        /** boolean	isDirectory() */
        // Tests whether the file denoted by this abstract pathname is a directory.
        boolean isDir = file.isDirectory();

        /** boolean	isFile() */
        // Tests whether the file denoted by this abstract pathname is a normal file.
        boolean isFile = file.isFile();

        /** boolean	isHidden() */
        // Tests whether the file named by this abstract pathname is a hidden file.
        boolean isHidden = file.isHidden();

        /** long	lastModified() */
        // Returns the time that the file denoted by this abstract pathname was last modified.
        long lastModified = file.lastModified();

        /** long	length() */
        // Returns the length of the file denoted by this abstract pathname.
        long fileLength = file.length();

        /** String[]	list() */
        // Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname.
        String[] dirs = file.list();

        /** String[]	list(FilenameFilter filter) */
        /* Returns an array of strings naming the files and directories in the directory denoted by this abstract
           pathname that satisfy the specified filter. */

        /** File[]	listFiles() */
        // Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname.
        File[] listFiles = file.listFiles();

        /** File[]	listFiles(FileFilter filter) */
        /* Returns an array of abstract pathnames denoting the files and directories in the directory denoted by
           this abstract pathname that satisfy the specified filter. */

        /** File[]	listFiles(FilenameFilter filter) */
        /* Returns an array of abstract pathnames denoting the files and directories in the directory denoted by
           this abstract pathname that satisfy the specified filter. */

        /** static File[]	listRoots() */
        // List the available filesystem roots.
        File[] roots = File.listRoots();

        /** boolean	mkdir() */
        // Creates the directory named by this abstract pathname.

        /** boolean	mkdirs() */
        // Creates the directory named by this abstract pathname, including any necessary but nonexistent parent directories.

        /** boolean	renameTo(File dest) */
        // Renames the file denoted by this abstract pathname.

        /** boolean	setExecutable(boolean executable) */
        // A convenience method to set the owner's execute permission for this abstract pathname.

        /** boolean	setExecutable(boolean executable, boolean ownerOnly) */
        // Sets the owner's or everybody's execute permission for this abstract pathname.

        /** boolean	setLastModified(long time) */
        // Sets the last-modified time of the file or directory named by this abstract pathname.

        /** boolean	setReadable(boolean readable) */
        // A convenience method to set the owner's read permission for this abstract pathname.

        /** boolean	setReadable(boolean readable, boolean ownerOnly) */
        // Sets the owner's or everybody's read permission for this abstract pathname.

        /** boolean	setReadOnly() */
        // Marks the file or directory named by this abstract pathname so that only read operations are allowed.

        /** boolean	setWritable(boolean writable) */
        // A convenience method to set the owner's write permission for this abstract pathname.

        /** boolean	setWritable(boolean writable, boolean ownerOnly) */
        // Sets the owner's or everybody's write permission for this abstract pathname.

        /** Path	toPath() */
        // Returns a java.nio.file.Path object constructed from the this abstract path.
        Path fileToPath = file.toPath();

        /** String	toString() */
        // Returns the pathname string of this abstract pathname.
        String fileStr = file.toString();

        /** URI	toURI() */
        //Constructs a file: URI that represents this abstract pathname.
        URI uri = file.toURI();

    }
}
