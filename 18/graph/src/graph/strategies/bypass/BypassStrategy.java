package graph.strategies.bypass;


import graph.Edge;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public abstract class BypassStrategy {
	public void bypass(Vertex startVertex) {
		List<Vertex> visited = new ArrayList<>();
		bypass(visited, startVertex);
	}

	public boolean isVisited(List<Vertex> visited, Vertex vertex) {
		for (Vertex vert : visited) {
			if (vert.equals(vertex)) {
				return true;
			}
		}

		return false;
	}

	public abstract void bypass(List<Vertex> visited, Vertex vertex);
}

