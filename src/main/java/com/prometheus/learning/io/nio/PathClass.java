package com.prometheus.learning.io.nio;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

public class PathClass {

    public void path() {

        String workingDir = System.getProperty("user.dir") + "/io/testfolder";
        Path path = Paths.get(workingDir);

        /** int	compareTo(Path other) */
        // Compares two abstract paths lexicographically.
        int lexCompare = path.compareTo(Paths.get(path.toString(), "textfile.txt"));

        /** boolean	endsWith(Path other) */
        // Tests if this path ends with the given path.
        boolean endsWith1 = path.endsWith(Paths.get("testfolder"));

        /** boolean	endsWith(String other) */
        /* Tests if this path ends with a Path, constructed by converting the given path string, in exactly the manner
           specified by the endsWith(Path) method. */
        boolean endsWith2 = path.endsWith("testfolder");

        /** boolean	equals(Object other) */
        // Tests this path for equality with the given object.
        boolean equalPaths = path.equals(Paths.get(workingDir));

        /** Path	getFileName() */
        // Returns the name of the file or directory denoted by this path as a Path object.
        Path file = Paths.get(workingDir+"/testfile.txt").getFileName();

        /** FileSystem	getFileSystem() */
        // Returns the file system that created this object.
        FileSystem fileSystem = path.getFileSystem();

        /** Path	getName(int index) */
        // Returns a name element of this path as a Path object.
        Path indexPath = path.getName(1);

        /** int	getNameCount() */
        // Returns the number of name elements in the path.
        int nameCount = path.getNameCount();

        /** Path	getParent() */
        // Returns the parent path, or null if this path does not have a parent.
        Path parent = path.getParent();

        /** Path	getRoot() */
        // Returns the root component of this path as a Path object, or null if this path does not have a root component.
        Path root = path.getRoot();

        /** int	hashCode() */
        // Computes a hash code for this path.
        int hashCode = path.hashCode();

        /** boolean	isAbsolute() */
        // Tells whether or not this path is absolute.
        boolean isAbsolute = path.isAbsolute();

        /** Iterator<Path>	iterator() */
        // Returns an iterator over the name elements of this path.
        Iterator<Path> pathIterator = path.iterator();


        /** Path	normalize() */
        // Returns a path that is this path with redundant name elements eliminated.
        Path normalized = path.normalize();

        /** WatchKey	register(WatchService watcher, WatchEvent.Kind<?>... events) */
        // Registers the file located by this path with a watch service.

        /** WatchKey	register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) */
        // Registers the file located by this path with a watch service.

        /** Path	relativize(Path other) */
        // Constructs a relative path between this path and a given path.
        Path relativized = parent.relativize(Paths.get(workingDir));

        /** Path	resolve(Path other) */
        // Resolve the given path against this path.
        Path resolvedPath1 = path.resolve(Paths.get(workingDir,"testfile.txt"));

        /** Path	resolve(String other) */
        // Converts a given path string to a Path and resolves it against this Path in exactly the manner specified by the resolve method.
        Path resolvedPath2 = path.resolve(workingDir+"/testfile.txt");

        /** Path	resolveSibling(Path other) */
        // Resolves the given path against this path's parent path.

        /** Path	resolveSibling(String other) */
        /* Converts a given path string to a Path and resolves it against this path's parent path in exactly
           the manner specified by the resolveSibling method. */

        /** boolean	startsWith(Path other) */
        // Tests if this path starts with the given path.
        boolean startsWith1 = path.startsWith(Paths.get("C:/Users/"));

        /** boolean	startsWith(String other) */
        /* Tests if this path starts with a Path, constructed by converting the given path string, in exactly the
           manner specified by the startsWith(Path) method. */
        boolean startsWith2 = path.startsWith("C:/Users/");

        /** Path	subpath(int beginIndex, int endIndex) */
        // Returns a relative Path that is a subsequence of the name elements of this path.
        Path subPath = path.subpath(0, 3);

        /** Path	toAbsolutePath() */
        // Returns a Path object representing the absolute path of this path.
        Path absolutePath = path.toAbsolutePath();

        /** File	toFile() */
        // Returns a File object representing this path.
        File pathToFile = path.toFile();

        /** Path	toRealPath(LinkOption... options) */
        // Returns the real path of an existing file.

        /** String	toString() */
        // Returns the string representation of this path.
        String pathStr = path.toString();

        /** URI	toUri() */
        // Returns a URI to represent this path.
        URI uri = path.toUri();

    }

    public void pathsClass() {

        /** static Path	get(String first, String... more) */
        // Converts a path string, or a sequence of strings that when joined form a path string, to a Path.

        /** static Path	get(URI uri) */
        // Converts the given URI to a Path object.
    }

    public void fileSystemsClass() {

        /** static FileSystem	getDefault() */
        // Returns the default FileSystem.

        /** static FileSystem	getFileSystem(URI uri) */
        // Returns a reference to an existing FileSystem.

        /** static FileSystem	newFileSystem(Path path, ClassLoader loader) */
        // Constructs a new FileSystem to access the contents of a file as a file system.

        /** static FileSystem	newFileSystem(URI uri, Map<String,?> env) */
        // Constructs a new file system that is identified by a URI

        /** static FileSystem	newFileSystem(URI uri, Map<String,?> env, ClassLoader loader) */
        // Constructs a new file system that is identified by a URI

    }

    public void fileSystemClass() {

        FileSystem fileSystem = FileSystems.getDefault();

        /** abstract void	close() */
        // Closes this file system.

        /** abstract Iterable<FileStore>	getFileStores() */
        // Returns an object to iterate over the underlying file stores.

        /** abstract Path	getPath(String first, String... more) */
        // Converts a path string, or a sequence of strings that when joined form a path string, to a Path.

        /** abstract PathMatcher	getPathMatcher(String syntaxAndPattern) */
        /* Returns a PathMatcher that performs match operations on the String representation of Path objects
           by interpreting a given pattern. */

        /** abstract Iterable<Path>	getRootDirectories() */
        // Returns an object to iterate over the paths of the root directories.

        /** abstract String	getSeparator() */
        // Returns the name separator, represented as a string.
        String separator = fileSystem.getSeparator();

        /** abstract UserPrincipalLookupService	getUserPrincipalLookupService() */
        // Returns the UserPrincipalLookupService for this file system (optional operation).

        /** abstract boolean	isOpen() */
        // Tells whether or not this file system is open.
        boolean isOpen = fileSystem.isOpen();

        /** abstract boolean	isReadOnly() */
        // Tells whether or not this file system allows only read-only access to its file stores.
        boolean isReadOnly = fileSystem.isReadOnly();

        /** abstract WatchService	newWatchService() */
        // Constructs a new WatchService (optional operation).

        /** abstract FileSystemProvider	provider() */
        // Returns the provider that created this file system.

        /** abstract Set<String>	supportedFileAttributeViews() */
        // Returns the set of the names of the file attribute views supported by this FileSystem.
        Set<String> supportedFileArrtibuteView = fileSystem.supportedFileAttributeViews();

    }
}
