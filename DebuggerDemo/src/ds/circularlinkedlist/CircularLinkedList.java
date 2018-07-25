package ds.circularlinkedlist;

import ds.singlylinkedlist.Node;

public class CircularLinkedList {

	Node first;
	Node last;
	
	public CircularLinkedList() {
		first = null;
		last = null;
	}
	
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			last = newNode;
		}
		newNode.next = first; // newNode --> old first
		first = newNode; // first place
	}


	private boolean isEmpty() {
		return first==null;
	}
	
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			first = newNode;
		}
		else {
			last.next = newNode;  // the next value of the last node will point to the new Node
			last = newNode;
		}
	}
	
	public int deleteFirst() {
		int temp = first.data;
		
		if(first.next == null) {
			last = null;
		}
		
		first = first.next; // first will point to old's next value
		return temp;
	}
	
	public void displayList() {
		System.out.println("List (first --> last)");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
}
