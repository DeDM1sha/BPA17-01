package graph;

import graph.strategies.bypass.BypassType;
import graph.strategies.search.SearchType;

public class Main {
	public static void main(String[] args) throws Exception {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("G");
		graph.addVertex("F");

		graph.addEdge("A", "C");
		graph.addEdge("A", "E");
		graph.addEdge("B", "F");
		graph.addEdge("C", "B");
		graph.addEdge("E", "B");
		graph.addEdge("E", "D");
		graph.addEdge("D", "G");

		System.out.println("Введенный граф:");
		graph.print();
		System.out.println("----------");
		System.out.println("Обход в глубину:");
		graph.bypass("A", BypassType.DEPTH_FIRST_BYPASS);
		System.out.println();
		System.out.println("----------");
		System.out.println("Обход в ширину:");
		graph.bypass("A", BypassType.BREADTH_FIRST_BYPASS);
		System.out.println();
		System.out.println();
		System.out.println("----------");
		System.out.println("Посещение вершины в ширину:");
		graph.visitVertex("A", "F", SearchType.BREADTH_FIRST_SEARCH);
		System.out.println("----------");
		System.out.println("Посещение вершины в глубину:");
		graph.visitVertex("A", "F", SearchType.DEPTH_FIRST_SEARCH);
	}
}
