package study.route;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Dv {
	
	public static class Edge {
		public int start;
		public int end;
		public int cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	public int[] test(Edge[] edges, int N, int[] pre) {
		int[] costs = new int[N];
		for (int i = 1; i < costs.length; i++) {
			costs[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < N; i++) {
			for (Edge edge : edges) {
				if (costs[edge.end - 1] > costs[edge.start - 1] + edge.cost) {
					pre[edge.end - 1] = edge.start - 1;
					costs[edge.end - 1] = costs[edge.start - 1] + edge.cost;
				}
			}
		}
		return costs;
	}
	
	public void printPath(int[] pre, int last) {
		Deque<Integer> deque = new LinkedList<>();
		deque.push(last + 1);
		while (last != 0) {
			int index = pre[last];
			deque.push(index + 1);
			last = index;
		}
		System.out.println("最短路径是:" + deque);
	}
	
	public static void main(String[] args) {
		Dv dv = new Dv();
		int[] pre = new int[7];
		int[] result = dv.test(new Edge[]{
			new Edge(1, 2, 8),
			new Edge(2, 3, 8),
			new Edge(3, 7, 8),
			new Edge(1, 4, 6),
			new Edge(4, 5, 6),
			new Edge(5, 6, 6),
			new Edge(6, 7, 6),
		}, 7, pre);
		dv.printPath(pre, 6);
		System.out.println("最短路径消耗是:" + result[6]);
	}
}
