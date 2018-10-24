package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.prism.impl.VertexBuffer;

import ds.singlylinkedlist.SinglyLinkedList;

public class BetterGraph {

	Vertex[] arrayOfLists;
	int indexCounter = 0;
	boolean undirected = true;

	class Node {
		public int vertexIdx;
		public Node next;

		public Node(int vertexIdx, Node node) {
			this.vertexIdx = vertexIdx;
			next = node;
		}
	}

	class Vertex {
		String name;
		Node adjList;

		Vertex(String name, Node aNode) {
			this.name = name;
			this.adjList = aNode;
		}
	}

	public BetterGraph(int vCount, String graphType) {
		if (graphType.equals("directed")) {
			undirected = false;
		}

		arrayOfLists = new Vertex[vCount];
	}

	public void addVertex(String vertexName) {
		// ArrayList<String> value = new ArrayList<>();
		// adjacents.put(vertex, value);

		arrayOfLists[indexCounter] = new Vertex(vertexName, null);
		indexCounter++;
	}

	public void addEdge(String srcVertexName, String destVertexName) {
		// ArrayList<String> value = adjacents.get(vertex);
		// if(value!=null) {
		// value.add(edge);
		// }

		int v1Idx = indexForName(srcVertexName);
		int v2Idx = indexForName(destVertexName);
		arrayOfLists[v1Idx].adjList = new Node(v2Idx, arrayOfLists[v1Idx].adjList);
		if (undirected) {
			arrayOfLists[v2Idx].adjList = new Node(v1Idx, arrayOfLists[v2Idx].adjList);
		}
	}

	private int indexForName(String name) {
		for (int v = 0; v < arrayOfLists.length; v++) {
			if (arrayOfLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}

	public void print() {

		System.out.println();
		for(int v=0;v<arrayOfLists.length;v++) {
			System.out.print(arrayOfLists[v].name);
			for(Node aNode = arrayOfLists[v].adjList; aNode!=null; aNode = aNode.next) {
				System.out.print(" --> " + arrayOfLists[aNode.vertexIdx].name);
			}
			System.out.println();
		}
	}

}
