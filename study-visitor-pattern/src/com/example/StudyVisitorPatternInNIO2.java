package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class StudyVisitorPatternInNIO2 {

	public static void main(String[] args) throws IOException {
		// Composite Pattern: Path: Directory, Regular File/File, DirectoryStream
		// Iterator Pattern
		Path path = Paths.get("c:\\tmp");
		// Lazy Loading
		for(Path dir : Files.newDirectoryStream(path)) {
			System.err.println(dir.getFileName());
		}
		File file = new File("c:\\tmp"); // since java 1
		for (String dir : file.list()) {
			System.err.println(dir);			
		}
		if (!Files.isDirectory(path)) {
			System.err.println("This is not a directory");
			System.exit(1);
		}
		try {
			// Internal Loop <-- Iterator Pattern
			Files.walkFileTree(path, new DeleteTextFileVisitor());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}

class DeleteTextFileVisitor implements FileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.err.println("Entering the directory: "+dir.getFileName());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.err.println("Deleting the file "+file.getFileName());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
		System.err.println("Error while deleting the file "+file.getFileName()+", reason: "+e.getMessage());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.err.println("Leaving the directory: "+dir.getFileName());
		return FileVisitResult.CONTINUE;
	}}