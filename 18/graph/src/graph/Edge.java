package graph;

public class Edge {
	private Vertex startVertex;
	private Vertex endVertex;

	public Edge(Vertex startVertex, Vertex endVertex) {
    this.startVertex = startVertex;
    this.endVertex = endVertex;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}
}
