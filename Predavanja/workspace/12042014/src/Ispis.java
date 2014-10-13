import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;


public class Ispis {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get(".");
		
		Files.walkFileTree(p, new FileVisitor<Path>() {
			
			int indent = 0;
			
			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				if(indent == 0) {
					System.out.printf("%s%n", dir);
				}
				else {
					System.out.printf("%" + indent + "s%s%n", "", dir.getName(dir.getNameCount() - 1));
				}
				indent += 2;
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				System.out.printf("%" + indent + "s%s%n", "", file.getName(file.getNameCount()- 1));
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc)
					throws IOException {
				indent -= 2;
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				return FileVisitResult.CONTINUE;
			}
			
		});
	}

}
