package graph.strategies.bypass;

import graph.Edge;
import graph.Vertex;

import java.util.List;

public class DepthFirstBypass extends BypassStrategy {
	private List<Edge> edges;

	public DepthFirstBypass(List<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public void bypass(List<Vertex> visited, Vertex vertex) {
		if (!isVisited(visited, vertex)) {
			visited.add(vertex);
			System.out.print(vertex.getKey() + " ");

			for (Edge edge : edges) {
				if (edge.getStartVertex().equals(vertex)) {
					bypass(visited, edge.getEndVertex());
				}
			}
		}
	}
}
