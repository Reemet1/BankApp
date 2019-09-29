package com.prometheus.learning.io;

public class FilesClass {

    public void filesClass() {

        /** static long	copy(InputStream in, Path target, CopyOption... options) */
        // Copies all bytes from an input stream to a file.

        /** static long	copy(Path source, OutputStream out) */
        // Copies all bytes from a file to an output stream.

        /** static Path	copy(Path source, Path target, CopyOption... options) */
        // Copy a file to a target file.

        /** static Path	createDirectories(Path dir, FileAttribute<?>... attrs) */
        // Creates a directory by creating all nonexistent parent directories first.

        /** static Path	createDirectory(Path dir, FileAttribute<?>... attrs) */
        // Creates a new directory.

        /** static Path	createFile(Path path, FileAttribute<?>... attrs) */
        // Creates a new and empty file, failing if the file already exists.

        /** static Path	createLink(Path link, Path existing) */
        // Creates a new link (directory entry) for an existing file (optional operation).

        /** static Path	createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs) */
        // Creates a symbolic link to a target (optional operation).

        /** static Path	createTempDirectory(Path dir, String prefix, FileAttribute<?>... attrs) */
        // Creates a new directory in the specified directory, using the given prefix to generate its name.

        /** static Path	createTempDirectory(String prefix, FileAttribute<?>... attrs) */
        // Creates a new directory in the default temporary-file directory, using the given prefix to generate its name.

        /** static Path	createTempFile(Path dir, String prefix, String suffix, FileAttribute<?>... attrs) */
        // Creates a new empty file in the specified directory, using the given prefix and suffix strings to generate its name.

        /** static Path	createTempFile(String prefix, String suffix, FileAttribute<?>... attrs) */
        // Creates an empty file in the default temporary-file directory, using the given prefix and suffix to generate its name.

        /** static void	delete(Path path) */
        // Deletes a file.

        /** static boolean	deleteIfExists(Path path) */
        // Deletes a file if it exists.

        /** static boolean	exists(Path path, LinkOption... options) */
        // Tests whether a file exists.

        /** static Object	getAttribute(Path path, String attribute, LinkOption... options) */
        // Reads the value of a file attribute.

        /** static <V extends FileAttributeView> V	getFileAttributeView(Path path, Class<V> type, LinkOption... options) */
        // Returns a file attribute view of a given type.

        /** static FileStore	getFileStore(Path path) */
        // Returns the FileStore representing the file store where a file is located.

        /** static FileTime	getLastModifiedTime(Path path, LinkOption... options) */
        // Returns a file's last modified time.

        /** static UserPrincipal	getOwner(Path path, LinkOption... options) */
        // Returns the owner of a file.

        /** static Set<PosixFilePermission>	getPosixFilePermissions(Path path, LinkOption... options) */
        // Returns a file's POSIX file permissions.

        /** static boolean	isDirectory(Path path, LinkOption... options) */
        // Tests whether a file is a directory.

        /** static boolean	isExecutable(Path path) */
        // Tests whether a file is executable.

        /** static boolean	isHidden(Path path) */
        // Tells whether or not a file is considered hidden.

        /** static boolean	isReadable(Path path) */
        // Tests whether a file is readable.

        /** static boolean	isRegularFile(Path path, LinkOption... options) */
        // Tests whether a file is a regular file with opaque content.

        /** static boolean	isSameFile(Path path, Path path2) */
        // Tests if two paths locate the same file.

        /** static boolean	isSymbolicLink(Path path) */
        // Tests whether a file is a symbolic link.

        /** static boolean	isWritable(Path path) */
        // Tests whether a file is writable.

        /** static Path	move(Path source, Path target, CopyOption... options) */
        // Move or rename a file to a target file.

        /** static BufferedReader	newBufferedReader(Path path, Charset cs) */
        // Opens a file for reading, returning a BufferedReader that may be used to read text from the file in an efficient manner.

        /** static BufferedWriter	newBufferedWriter(Path path, Charset cs, OpenOption... options) */
        // Opens or creates a file for writing, returning a BufferedWriter that may be used to write text to the file in an efficient manner.

        /** static SeekableByteChannel	newByteChannel(Path path, OpenOption... options) */
        // Opens or creates a file, returning a seekable byte channel to access the file.

        /** static SeekableByteChannel	newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) */
        // Opens or creates a file, returning a seekable byte channel to access the file.

        /** static DirectoryStream<Path>	newDirectoryStream(Path dir) */
        // Opens a directory, returning a DirectoryStream to iterate over all entries in the directory.

        /** static DirectoryStream<Path>	newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter) */
        // Opens a directory, returning a DirectoryStream to iterate over the entries in the directory.

        /** static DirectoryStream<Path>	newDirectoryStream(Path dir, String glob) */
        // Opens a directory, returning a DirectoryStream to iterate over the entries in the directory.

        /** static InputStream	newInputStream(Path path, OpenOption... options) */
        // Opens a file, returning an input stream to read from the file.

        /** static OutputStream	newOutputStream(Path path, OpenOption... options) */
        // Opens or creates a file, returning an output stream that may be used to write bytes to the file.

        /** static boolean	notExists(Path path, LinkOption... options) */
        // Tests whether the file located by this path does not exist.

        /** static String	probeContentType(Path path) */
        // Probes the content type of a file.

        /** static byte[]	readAllBytes(Path path) */
        // Reads all the bytes from a file.

        /** static List<String>	readAllLines(Path path, Charset cs) */
        // Read all lines from a file.

        /** static <A extends BasicFileAttributes> A	readAttributes(Path path, Class<A> type, LinkOption... options) */
        // Reads a file's attributes as a bulk operation.

        /** static Map<String,Object>	readAttributes(Path path, String attributes, LinkOption... options) */
        // Reads a set of file attributes as a bulk operation.

        /** static Path	readSymbolicLink(Path link) */
        // Reads the target of a symbolic link (optional operation).

        /** static Path	setAttribute(Path path, String attribute, Object value, LinkOption... options) */
        // Sets the value of a file attribute.

        /** static Path	setLastModifiedTime(Path path, FileTime time) */
        // Updates a file's last modified time attribute.

        /** static Path	setOwner(Path path, UserPrincipal owner) */
        // Updates the file owner.

        /** static Path	setPosixFilePermissions(Path path, Set<PosixFilePermission> perms) */
        // Sets a file's POSIX permissions.

        /** static long	size(Path path) */
        // Returns the size of a file (in bytes).

        /** static Path	walkFileTree(Path start, FileVisitor<? super Path> visitor) */
        // Walks a file tree.

        /** static Path	walkFileTree(Path start, Set<FileVisitOption> options, int maxDepth, FileVisitor<? super Path> visitor) */
        // Walks a file tree.

        /** static Path	write(Path path, byte[] bytes, OpenOption... options) */
        // Writes bytes to a file.

        /** static Path	write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options) */
        // Write lines of text to a file.

    }
}
