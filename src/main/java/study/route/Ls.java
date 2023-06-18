package study.route;

import java.util.ArrayList;
import java.util.List;

public class Ls {
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
	
	public int[][] test(int[][] adjacencyMatrix, int startVertex) {
		int nVertices = adjacencyMatrix[0].length;
		int[] shortestDistances = new int[nVertices];
		boolean[] added = new boolean[nVertices];
		
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			shortestDistances[vertexIndex] = Integer.MAX_VALUE;
			added[vertexIndex] = false;
		}
		
		shortestDistances[startVertex] = 0;
		int[] parents = new int[nVertices];
		parents[startVertex] = -1;
		for (int i = 1; i < nVertices; i++) {
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}
			added[nearestVertex] = true;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
				
				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
				}
			}
		}
		return new int[][]{shortestDistances, parents};
	}
	
	public int[][] convertToAdjacencyMatrix(Edge[] edges, int count) {
		int[][] res = new int[count][count];
		for (Edge edge : edges) {
			res[edge.start - 1][edge.end - 1] = edge.cost;
		}
		return res;
	}
	
	public void printPath(int currentVertex, int[] parents, List<Integer> list) {
		if (currentVertex == -1) {
			return;
		}
		printPath(parents[currentVertex], parents, list);
		list.add(currentVertex + 1);
	}
	
	
	public static void main(String[] args) {
		Ls ls = new Ls();
		Edge[] edges = new Edge[]{
			new Edge(1, 2, 8),
			new Edge(2, 3, 8),
			new Edge(3, 7, 8),
			new Edge(1, 4, 6),
			new Edge(4, 5, 6),
			new Edge(5, 6, 6),
			new Edge(6, 7, 6),
		};
		int[][] adjacencyMatrix = ls.convertToAdjacencyMatrix(edges, 7);
		int[][] result = ls.test(adjacencyMatrix, 0);
		System.out.println("最小开销: " + result[0][6]);
		
		List<Integer> paths = new ArrayList<>();
		ls.printPath(6, result[1], paths);
		System.out.println("最小路径: " + paths);
		
		
		edges = new Edge[]{
			new Edge(1, 2, 8),
			new Edge(2, 3, 8),
			new Edge(3, 7, 8),
			new Edge(1, 4, 6),
			new Edge(4, 5, 6),
			new Edge(5, 6, 6),
			new Edge(6, 7, 6),
			new Edge(5, 3, 2),
		};
		adjacencyMatrix = ls.convertToAdjacencyMatrix(edges, 7);
		result = ls.test(adjacencyMatrix, 0);
		System.out.println("最小开销: " + result[0][6]);
		
		paths = new ArrayList<>();
		ls.printPath(6, result[1], paths);
		System.out.println("最小路径: " + paths);
		
	}
}
