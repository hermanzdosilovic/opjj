import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;


public class Prebroji {
	
	private static Map<String, Integer> mapa = new HashMap<>();
	
	public static FileVisitor<Path> gost = new FileVisitor<Path>() {

		@Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			String ekst = "";
			if(file.toFile().isFile()) {
				String name = file.getFileName().toString();
				if(name.contains("."))
					ekst = name.substring(name.indexOf("."));
				if(mapa.containsKey(ekst)) {
					mapa.put(ekst, mapa.get(ekst) + 1);
				}
				else {
					mapa.put(ekst, 1);
				}
			}
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc)
				throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			return FileVisitResult.CONTINUE;
		}
		
	};
	
	public static void main(String[] args) throws IOException {
		
		Path p = Paths.get("C:/Python33");
		Files.walkFileTree(p, gost);
		
		for(String s : mapa.keySet()) {
			System.out.println(s + "  \t" + mapa.get(s));
		}
	}

}
