package graph;

import java.beans.Transient;

public class MyTest {
	
	public static void main(String[] args) {
		Vertex V1 = new Vertex(Color.Rouge, "1");
		Vertex V2 = new Vertex(Color.Bleu, "2");
		Edge edge = new Edge(V1, V2, 2.3, Color.Autre);
		System.out.println(V1);
		System.out.println(V2);
		System.out.println(edge);

	}
}