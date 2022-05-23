package graphImpl;

import graph.*;

public class IncidenceArrayGraph implements Graph {
	// Attributs
	private int nbSommetsMax;
	private Edge[][] incidence;
	private Vertex[] vertices;
	private int edges = 0;
	private boolean isDirectedGraph;
	

	public IncidenceArrayGraph(int nbSommets, boolean isDirectedGraph) {
		this.nbSommetsMax = nbSommets;
		this.vertices = new Vertex[nbSommets];
		// this.edges = new Edge[2*nbSommets*nbSommets];
		this.isDirectedGraph = isDirectedGraph;
		this.incidence = new Edge[nbSommets][nbSommets*2];
	}

	@Override
	public int nbOfVertices() {
		int nbVertices = 0;
		for (int i = 0; i < this.vertices.length; i++) {
			if (this.vertices[i] != null) {
				nbVertices++;
			}
		}
		return nbVertices;
	}

	@Override
	public int nbOfEdges() {
		// int nbEdges = 0;
		// for (int i = 0; i < this.nbOfVertices(); i++) {
		// 	int j = 0;
		// 	while (j < this.incidence[i].length && this.incidence[i][j] != null) {
		// 		nbEdges++;
		// 		j++;
		// 	}
		// }
		// return nbEdges;
		return this.edges/2;
	}

	@Override
	public void addVertex(Vertex v1) {
		int i = 0;
		while (i < this.vertices.length && this.vertices[i] != null ) {
			if (v1.getId()%nbSommetsMax == this.vertices[i].getId()%nbSommetsMax) {
				i = this.vertices.length;
				break;
			}
			i++;
		}
		if (i < this.vertices.length) {
			try {
				this.addVertexPrivate(v1);
			} catch (Exception ErreurMaxSommets) {
				System.out.println("Erreur");
				System.out.println(ErreurMaxSommets);
			}
		}
	}

	private void addVertexPrivate(Vertex v1) throws ErreurMaxSommets {
		int nbVertices = this.nbOfVertices();
		if (nbVertices != this.nbSommetsMax) {
			this.vertices[nbVertices] = v1;
		}
		else {
			throw new ErreurMaxSommets("Vous ne pouvez pas ajouté plus de sommets");
		}
	}

	@Override
	public void addUndirectedEdge(UndirectedEdge e) {

		Vertex[] buffer = e.getEnds();
		addVertex(buffer[0]);
		addVertex(buffer[1]);

		this.edges++;
		this.edges++;
		
		int i = 0;
		while (this.incidence[buffer[0].getId()%nbSommetsMax][i] != null) {
			i++;
		}
		this.incidence[buffer[0].getId()%nbSommetsMax][i] = e;

		int j = 0;
		while (this.incidence[buffer[1].getId()%nbSommetsMax][j] != null) {
			j++;
		}
		this.incidence[buffer[1].getId()%nbSommetsMax][j] = e;
	}

	@Override
	public void addDirectedEdge(DirectedEdge e) {
		Vertex[] buffer = new Vertex[2];
		buffer[0] = e.getSource();
		buffer[1] = e.getSink();
		addVertex(buffer[0]);
		addVertex(buffer[1]);


		this.edges++;

		int i = 0;
		while (this.incidence[buffer[0].getId()%nbSommetsMax][i] != null) {
			i++;
		}
		this.incidence[buffer[0].getId()%nbSommetsMax][i] = e;

		DirectedEdge inverseEdge = new DirectedEdge(buffer[0], buffer[1], e.getValue(), e.getColor(), (e.source()+1)%2);

		this.edges++;

		int j = 0;
		while (this.incidence[buffer[1].getId()%nbSommetsMax][j] != null) {
			j++;
		}
		this.incidence[buffer[1].getId()%nbSommetsMax][j] = inverseEdge;
	}

	@Override
	public boolean isConnected(Vertex v1, Vertex v2) {
		return true;
	}

	@Override
	public boolean isConnected() {
		return true;
	}

	@Override
	public Edge[] getEdges(Vertex v1, Vertex v2) {
		Edge[] allEdges = new Edge[this.incidence[v1.getId()%nbSommetsMax].length + this.incidence[v2.getId()%nbSommetsMax].length];
		int k = 0;
		for (int i = 0; i < this.incidence[v1.getId()%nbSommetsMax].length; i++) {
			for (int j = 0; j < this.incidence[v2.getId()%nbSommetsMax].length; j++) {
				if (this.incidence[v1.getId()%nbSommetsMax][i].getId()%nbSommetsMax == this.incidence[v2.getId()%nbSommetsMax][j].getId()%nbSommetsMax) {
					allEdges[k] = this.incidence[v1.getId()%nbSommetsMax][i];
					k++;
				}
			}
		}
		return allEdges;
	}

	@Override
	public Edge[] getEdges() {
		int j;
		int cpt = 0;
		Edge[] edge = new Edge[this.edges];
		for (int i = 0; i < this.incidence.length; i++) {
			j = 0;
			while (this.incidence[i][j] != null) {
				edge[cpt] = this.incidence[i][j];
				cpt++;
				j++;
			}
		}
		return edge;
	}

	@Override
	public Vertex[] getVertices() {
		return this.vertices;
	}

	@Override
	public Edge[] getNeighborEdges(Vertex v1) {
		return this.incidence[v1.getId()%nbSommetsMax];
	}

	public String toString() {
		String dessin = "";
		Vertex[] sommets = new Vertex[2];
		for (int i = 0; i < this.vertices.length; i++) {
			dessin = dessin + this.vertices[i].getId()%nbSommetsMax + "\t";
			for (int j = 0; j < this.incidence[i].length; j++) {
				if (this.incidence[i][j] != null) {
					sommets[0] = this.incidence[i][j].getEnds()[0];
					sommets[1] = this.incidence[i][j].getEnds()[1];
					dessin += sommets[0].getId()%nbSommetsMax + "--" + sommets[1].getId()%nbSommetsMax;
					dessin += "\t";
				}
				else {break;}
			}
			dessin += "\n";
		}
		return dessin;
	}
}