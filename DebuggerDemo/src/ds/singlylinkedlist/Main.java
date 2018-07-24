package ds.singlylinkedlist;

public class Main {

	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
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
