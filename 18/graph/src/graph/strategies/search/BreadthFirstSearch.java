package graph.strategies.search;

import graph.Edge;
import graph.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch implements SearchStrategy {
	private List<Edge> edges;

	public BreadthFirstSearch(List<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public void search(Vertex startVertex, Vertex findVertex) {
		ArrayDeque<Vertex> queue = new ArrayDeque<>();
		queue.add(startVertex);

		while (!queue.isEmpty()) {
			Vertex vertex = queue.pollFirst();
			System.out.print(vertex.getKey() + " ");

			for (Edge edge : edges) {
				if (edge.getStartVertex().equals(vertex)) {
					if (edge.getEndVertex().equals(findVertex)) {
						System.out.println(findVertex.getKey());
						return;
					}
					boolean isVisited = false;
					for (Vertex vert : queue) {
						if (vert.equals(edge.getEndVertex())) {
							isVisited = true;
							break;
						}
					}

					if (!isVisited) {
						queue.add(edge.getEndVertex());
					}
				}
			}
		}
	}
}
