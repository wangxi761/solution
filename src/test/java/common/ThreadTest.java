package common;

import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.io.*;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
	int fileCount = 20;
	int line_max = 200000000;
	@Test
	public void test() throws InterruptedException {
	
	}
	
	public void sort(File file) throws IOException {
		int singleMaxLine = line_max / fileCount;
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.<int[], Integer>comparing(i -> i[1]).reversed());
		File[] outs = new File[fileCount];
		for (int i = 0; i < outs.length; i++) {
			outs[i] = new File(i + "");
		}
		File[] files = spilt(file, outs);
		for (int i = 0; i < files.length; i++) {
			int[] hash = new int[singleMaxLine];
			List<String> lines = Files.readAllLines(files[i].toPath());
			for (String line : lines) {
				Integer value = Integer.valueOf(line);
				hash[value % singleMaxLine]++;
				if (queue.size() > 100 && queue.peek()[1] < hash[value]) {
					queue.poll();
				}
				queue.offer(new int[]{value, hash[value]});
			}
		}
	}
	
	public File[] spilt(File in, File[] outs) throws IOException {
		int singleMaxLine = line_max / fileCount;
		try (BufferedReader br = new BufferedReader(new FileReader(in))) {
			FileWriter[] fws = new FileWriter[outs.length];
			for (int i = 0; i < outs.length; i++) {
				fws[i] = new FileWriter(outs[i]);
			}
			String str;
			while ((str = br.readLine()) != null) {
				Integer value = Integer.valueOf(str);
				fws[value / singleMaxLine].write(str);
			}
			for (int i = 0; i < fws.length; i++) {
				fws[i].close();
			}
			return outs;
		}
	}
	
	
}
