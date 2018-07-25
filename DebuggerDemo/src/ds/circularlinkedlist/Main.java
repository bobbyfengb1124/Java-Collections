package ds.circularlinkedlist;

public class Main {

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertFirst(100);
		myList.insertFirst(1000);
		myList.insertFirst(10);
		myList.insertFirst(1);
		myList.insertFirst(500);
		myList.insertFirst(200);
		myList.insertFirst(300);
		myList.insertLast(999);
		
		myList.displayList();
		
	}


}
