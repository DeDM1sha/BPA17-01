package graph.strategies.bypass;

import graph.Edge;
import graph.Vertex;

import java.util.ArrayDeque;
import java.util.List;

public class BreadthFirstBypass extends BypassStrategy {
	private List<Edge> edges;

	public BreadthFirstBypass(List<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public void bypass(List<Vertex> visited, Vertex vertex) {
		ArrayDeque<Vertex> queue = new ArrayDeque<>();
		queue.add(vertex);

		while (!queue.isEmpty()) {
			vertex = queue.pollFirst();

			System.out.print(vertex.getKey() + " ");

			for (Edge edge : edges) {
				if (edge.getStartVertex().equals(vertex)) {
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
