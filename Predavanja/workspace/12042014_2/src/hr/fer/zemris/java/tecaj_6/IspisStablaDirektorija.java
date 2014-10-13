package hr.fer.zemris.java.tecaj_6;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class IspisStablaDirektorija {

	static class Ispitivac implements FileVisitor<Path> {

		private int indent = 0;

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			if (indent == 0) {
				System.out.printf("%s%n", dir);

			} else {
				System.out.printf("%" + indent + "s%s%n", "", dir.getName(dir.getNameCount() - 1));
			}
			indent += 2;
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			System.out.printf("%" + indent + "s%s%n", "", file.getName(file.getNameCount() - 1));
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			indent -= 2;
			return FileVisitResult.CONTINUE;
		}

	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Dragi korisnice...");
			System.exit(-1);
		}

		Path p = Paths.get(args[0]);

		if (!Files.isDirectory(p)) {
			System.out.println("Dragi korisnice 2,...");
			System.exit(-1);
		}

		Files.walkFileTree(p, new Ispitivac());
	}

}
