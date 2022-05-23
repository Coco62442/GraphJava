package graphImpl;

import graph.*;

public class GraphImpl {
	public static void main(String[] args) {
		IncidenceArrayGraph graph = new IncidenceArrayGraph(3,true);
		System.out.println("Debut test");
		Vertex s1 = new Vertex("0", "Rouge");
		Vertex s2 = new Vertex("1", "Bleu");
		Vertex s3 = new Vertex("2", "Vert");
		UndirectedEdge e1 = new UndirectedEdge(s1, s2, 2, "Gris");
		UndirectedEdge e2 = new UndirectedEdge(s1, s3, 3, "Jaune");
		UndirectedEdge e3 = new UndirectedEdge(s1, s2, 4, "Orange");
		graph.addVertex(s1);
		graph.addVertex(s2);
		graph.addVertex(s3);
		
		graph.addUndirectedEdge(e1);
		graph.addUndirectedEdge(e2);
		graph.addUndirectedEdge(e3);

		System.out.println(graph.nbOfEdges());
		System.out.println(graph.nbOfVertices());
		System.out.println(graph);
	}
}
