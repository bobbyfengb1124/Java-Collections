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
		if(last.previous == null) {
			last = null;
		} else {
			last.previous.next = null;
		}
		
		last = last.previous;
		return temp;
	}
}
