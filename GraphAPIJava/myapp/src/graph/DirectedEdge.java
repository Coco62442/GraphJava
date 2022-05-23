package graph;

public class DirectedEdge extends Edge {
	// Attributs
	private int source;
	static int counterId = -1;
	private int id;
	private Color color;
	private Vertex[] ends;
	private double value;

	public DirectedEdge(Vertex sommet1, Vertex sommet2, int source, double value, Color color) throws SaisieErronneeException{
		super(sommet1, sommet2, value, color);
		if (source == 0 || source == 1) {
			this.source = source;
		}
		else {
			throw new SaisieErronneeException("La valeur de source et de 0 ou de 1\n");
		}
	}

	public Vertex getSource() {
		return getEnds()[this.source];
	}

	public Vertex getSink() {
		return getEnds()[(this.source+1) % 2];
	}

	public int id() {
		return this.id;
	}

	@Override
	public String toString() {
		if (this.source == 0) {
			return this.ends[0] + "--" + this.value + "->" + this.ends[1];
		}
		else {
			return this.ends[0] + "<-" + this.value + "--" + this.ends[1];
		}
	}
}