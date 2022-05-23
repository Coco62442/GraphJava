package graph;

public class Vertex {
	// Attributs
	static int counterId = 0;
	private int id;
	private Object info;
	private Color color;


	public Vertex(Color color, Object info) {
		this.id = counterId++;
		this.info = info;
		this.color = color;
	}

	public int id() {
		return this.id;
	}

	public String toString() {
		return Integer.toString(this.id);
	}
}