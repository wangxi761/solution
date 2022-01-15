package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            graph.computeIfAbsent(arr[i], it -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == arr.length - 1) {
                    return step;
                }
                List<Integer> next = graph.get(arr[num]);
                next.add(num - 1);
                next.add(num + 1);
                for (Integer it : next) {
                    if (it >= 0 && it < arr.length && !visited[it]) {
                        visited[it] = true;
                        queue.offer(it);
                    }
                }
                next.clear();
            }
            step++;
        }
        return 0;
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }
}
