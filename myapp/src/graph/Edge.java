package graph;

public class Edge {
	// Attributs
	static int counterId = 0;
	public int id;
	private Color color;
	private Vertex[] ends;
	private double value;

	public Edge(Vertex sommet1, Vertex sommet2, double value, Color color) {
		this.id = counterId++;
		this.color = color;
		this.ends[0] = sommet1;
		this.ends[1] = sommet2;
		this.value = value;
	}

	public Vertex[] getEnds() {
		return this.ends;
	}

	public String toString() {
		return this.ends[0] + "--" + this.value + "--" + this.ends[1];
	}
}