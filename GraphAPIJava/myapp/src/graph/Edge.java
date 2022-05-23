package graph;

public class Edge {
	// Attributs
	static int counterId = 0;
	private int id;
	private Color color;
	private Vertex[] ends;
	private double value;

	public Edge(Vertex sommet1, Vertex sommet2, double value, Color color) {
		this.id = counterId++;
		this.color = color;
		this.ends = new Vertex[2];
		this.ends[0] = sommet1;
		this.ends[1] = sommet2;
		this.value = value;
	}

	public Vertex[] getEnds() {
		return this.ends;
	}

	public int id() {
		return this.id;
	}

	public String toString() {
		return this.ends[0] + "--" + this.value + "--" + this.ends[1];
	}
}