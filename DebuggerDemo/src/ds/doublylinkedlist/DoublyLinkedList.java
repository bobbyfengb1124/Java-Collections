package ds.doublylinkedlist;

public class DoublyLinkedList {

	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first=null;
		this.last=null;
	}
	
	public boolean isEmpty() {
		return first ==null;
	}
	
	public void insertFirst(int data) {
		Node node = new Node();
		node.data = data;
		
		if(isEmpty()) {
			last = node;
		}
		else {
			first.previous = node;
		}
		
		node.next = first;
		this.first = node;
	}
	
	public void inserLast(int data) {
		Node node = new Node();
		node.data = data;
		
		if(isEmpty()) {
			first = node;
		}
		else {
			last.next = node;
		}
		
		node.previous = last; 
		this.last = node;
	}
	
	// assume non-empty list
	public Node deleteFirst() {
		Node temp = first;
		if(first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		
		first = first.next;
		return temp;
	}
	
	// assume non-empty list
	public Node deleteLast() {
		Node temp = last;
		if(first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		
		last = last.previous;
		return temp;
	}
	
	// assume non-empty list
	public boolean insertAfter(int key, int data) {
		Node current = first; // start from the beginning of the list 
		while(current.data !=key) { // as long as we have not found the key in a particular node
			current = current.next;
			if(current == null) {
				return false;
			}
		}
		
		Node node = new Node();
		node.data = data;
		
		if(current == last) {
			current.next = null;
			last = node;
		} else {
			node.next = current.next;
			node.next.previous = node;
		}
		node.previous = current;
		current.next = node;
		
		return true;
	}
	
	// assume non-empty list
	public Node deleteKey(int key) {
		Node current = first; // start from the beginning of the list 
		while(current.data !=key) { // as long as we have not found the key in a particular node
			current = current.next;
			if(current == null) {
				return null;
			}
		}
		
		if(current == first) {
			first = current.next;
		}
		else {
			current.previous.next = current.next;
		}
		
		if(current == last) {
			last = current.previous;
		}
		else {
			current.next.previous = current.previous;
		}
		
		return current;
	}
	
	public void displayForward() {
		System.out.println("List (first --> last)");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	public void displayBackward() {
		System.out.println("List (last --> first)");
		Node current = last;
		while(current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}
}
