package graphImpl;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.UndirectedEdge;
import graph.Vertex;

public class TestIncidenceArrayGraph {
	private IncidenceArrayGraph graph;
	private Vertex v1;
	private Vertex v2;
	private Vertex v3;
	private UndirectedEdge e1;
	private UndirectedEdge e2;
	private UndirectedEdge e3;

	@Before
	public void setUp() {
		this.graph = new IncidenceArrayGraph(2, false);
		this.v1 = new Vertex("v1", "rouge");
		this.v2 = new Vertex("v2", "bleu");
		this.v3 = new Vertex("v3", "jaune");
		this.e1 = new UndirectedEdge(v1, v2, 4, "rouge");
		this.e2 = new UndirectedEdge(v1, v2, 2, "bleu");
		this.e3 = new UndirectedEdge(v1, v2, 2, "gris");
	}

	@Test
	public void nbOfVerticesIs0() {
		assertEquals(0, graph.nbOfVertices());
	}

	@Test
	public void nbOfVerticesIs2() {
		this.graph.addVertex(v1);
		this.graph.addVertex(v2);
		assertEquals(2, this.graph.nbOfVertices());
	}

	@Test
	public void nbOfEdgesIs0() {
		assertEquals(0, this.graph.nbOfEdges());
	}

	@Test
	public void nbOfEdgesIs2() {
		this.graph.addUndirectedEdge(e1);
		this.graph.addUndirectedEdge(e2);
		assertEquals(2, this.graph.nbOfEdges());
	}

	// @Test(expected = graphImpl.ErreurMaxSommets.class)
	// public void ErreurMaxSommets() {
	// 	this.graph.addVertex(v1);
	// 	this.graph.addVertex(v2);
	// 	this.graph.addVertex(v3);
	// }

	@Test
	public void getEdges() {
		this.graph.addUndirectedEdge(e1);
		assertArrayEquals(new UndirectedEdge[] {e1}, this.graph.getEdges());
	}
}