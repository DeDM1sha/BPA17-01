package graph.strategies.search;


import graph.Edge;
import graph.Vertex;

import java.util.List;

public interface SearchStrategy {
	public void search(Vertex startVertex, Vertex findVertex);
}

