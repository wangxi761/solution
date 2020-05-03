package common;


import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class FilesTest {

	Path p1 = Paths.get("C:", "/Users/ccf/Desktop", "2", "1.txt");
	Path p2 = Paths.get("C:", "/Users/ccf/Desktop", "2", "2.txt");
	Path p3 = Paths.get("C:", "/Users/ccf/Desktop", "sssx.txt");
	
	@Test
	public void test() throws Exception {
		List<String> list = Files.readAllLines(p3);
		for (int i = 0; i < list.size(); i++) {
		
		}
	}
	
	private void old() throws IOException {
		final CountDownLatch latch = new CountDownLatch(1);
		
		CompletableFuture.runAsync(() -> {
			try {
				latch.await();
				Files.move(p1, p2, StandardCopyOption.ATOMIC_MOVE);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		});
		try (FileWriter fw = new FileWriter(p1.toFile())) {
			for (int i = 0; i < 100000; i++) {
				fw.write("test\n");
				if (i == 1)
					latch.countDown();
			}
		}
		Files.readAllLines(p1)
			.stream()
			.filter(str -> str.chars()
				.mapToObj(i -> (char) i)
				.anyMatch(i -> !Character.isWhitespace(i)))
			.forEach(System.out::println);
	}
}
