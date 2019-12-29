package graph.strategies.search;

import graph.Edge;
import graph.Vertex;

import java.util.ArrayDeque;
import java.util.List;

public class DepthFirstSearch implements SearchStrategy {
	private List<Edge> edges;

	public DepthFirstSearch(List<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public void search(Vertex startVertex, Vertex findVertex) {
		System.out.println("Prum prum! Nothing to show. Soon new year!");
	}
}
