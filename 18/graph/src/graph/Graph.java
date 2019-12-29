package graph;

import graph.strategies.bypass.BreadthFirstBypass;
import graph.strategies.bypass.BypassStrategy;
import graph.strategies.bypass.BypassType;
import graph.strategies.bypass.DepthFirstBypass;
import graph.strategies.search.BreadthFirstSearch;
import graph.strategies.search.DepthFirstSearch;
import graph.strategies.search.SearchStrategy;
import graph.strategies.search.SearchType;

import java.util.*;

public class Graph {
	private List<Vertex> vertexes = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();

	public Graph() {}

	public void addVertex(String key) {
		if (hasVertex(key)) {
			throw new ArrayStoreException("graph.Vertex with key " + key + " already exist");
		}

		vertexes.add(new Vertex(key));
	}

	public boolean hasVertex(String key) {
		for (Vertex vertex : vertexes) {
			if (vertex.getKey().equals(key)) {
				return true;
			}
		}

		return false;
	}

	public Vertex getVertex(String key) {
		for (Vertex vertex : vertexes) {
			if (vertex.getKey().equals(key)) {
				return vertex;
			}
		}

		throw new NullPointerException("graph.Vertex with key " + key + " not yet");
	}

	public void addEdge(String startVertexKey, String endVertexKey) {
		Vertex startVertex = getVertex(startVertexKey);
		Vertex endVertex = getVertex(endVertexKey);
		edges.add(new Edge(startVertex, endVertex));
	}


	public void bypass(String startVertexKey, BypassType strategy) throws Exception {
		BypassStrategy bypassStrategy;
		if (strategy == BypassType.DEPTH_FIRST_BYPASS) {
			bypassStrategy = new DepthFirstBypass(edges);
		} else if (strategy == BypassType.BREADTH_FIRST_BYPASS) {
			bypassStrategy = new BreadthFirstBypass(edges);
		} else {
			throw new Exception("Bypass strategy not found");
		}

		Vertex startVertex = getVertex(startVertexKey);
		bypassStrategy.bypass(startVertex);
	}

	public void visitVertex(String startKey, String findKey, SearchType strategy) throws Exception {
		SearchStrategy searchStrategy;
		if (strategy == SearchType.DEPTH_FIRST_SEARCH) {
			searchStrategy = new DepthFirstSearch(edges);
		} else if (strategy == SearchType.BREADTH_FIRST_SEARCH) {
			searchStrategy = new BreadthFirstSearch(edges);
		} else {
			throw new Exception("Search strategy not found");
		}

		Vertex startVertex = getVertex(startKey);
		Vertex findVertex = getVertex(findKey);
		searchStrategy.search(startVertex, findVertex);
	}

	public void visitVertex(String startKey, String findKey) {
		List<Vertex> visited = new ArrayList<>();
		ArrayDeque<Vertex> queue = new ArrayDeque<>();
		Vertex vertex = getVertex(startKey);
		queue.add(vertex);

		while (!queue.isEmpty()) {
			vertex = queue.pollFirst();

			visited.add(vertex);
			System.out.print(vertex.getKey() + " ");

			for (Edge edge : edges) {
				if (edge.getStartVertex().equals(vertex)) {
					if (edge.getEndVertex().getKey().equals(findKey)) {
						System.out.println(findKey);
						return;
					}
					boolean isVisited = false;
					for (Vertex vert : queue) {
						if (vert.getKey().equals(edge.getEndVertex().getKey())) {
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

	public void visitEdge(String startKey, String startEdgeKey, String endEdgeKey) {

	}

	public void print() {
		for (Vertex vertex : vertexes) {
			System.out.print(vertex.getKey() + " -> ");
			for (Edge edge : edges) {
				if (edge.getStartVertex().getKey().equals(vertex.getKey())) {
					System.out.print(edge.getEndVertex().getKey() + " ");
				}
			}
			System.out.println();
		}
	}
}
