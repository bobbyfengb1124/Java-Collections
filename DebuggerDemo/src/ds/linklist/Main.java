package ds.linklist;

import java.nio.channels.Pipe.SourceChannel;

public class Main {

	public static void main(String[] args) {
		Node nodeA = new Node();
		nodeA.data = 4;
				
		Node nodeB = new Node();
		nodeB.data = 3;
		
		Node nodeC = new Node();
		nodeC.data = 7;
		
		Node nodeD = new Node();
		nodeD.data = 8;
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		
		System.out.println(nodeLenth(nodeA));
		System.out.println(nodeLenth(nodeB));
	}
	
	public static int nodeLenth(Node node) {
		
		int len=1;
		while(node.next != null) {
			len++;
			node=node.next;
		}
		return len;
		
	}

}
