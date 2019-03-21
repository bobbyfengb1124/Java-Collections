package leetcode.challenge;

public class SortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		SortList sortList = new SortList();
		ListNode n1 = sortList.new ListNode(4);
		ListNode n2 = sortList.new ListNode(2);
		ListNode n3 = sortList.new ListNode(1);
		ListNode n4 = sortList.new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		printList(n1);
		n1 = sortList(n1);
		printList(n1);
	}

	private static void printList(ListNode n1) {
		ListNode cur = n1;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static ListNode sortList(ListNode head) {

		if (head.next == null || head == null) {
			return head; // we are done traversing the list
		}

		// partition
		ListNode b = cutHalf(head);

		head = sortList(head);
		b = sortList(b);

		return merge(head, b);
	}

	private static ListNode merge(ListNode head, ListNode b) {
		ListNode newListCur = head;
		
		if(head==null) {
			return b;
		}
		else {
			if(b==null) {
				return head;
			}
		}

		if(head.val <= b.val) {
			newListCur = head;
			newListCur.next = merge(head.next, b);
		}else {
			newListCur = b;
			newListCur.next = merge(head, b.next);
		}
		
		return newListCur;
	}

	private static ListNode cutHalf(ListNode head) {
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			head = head.next;
			fast = fast.next.next;
		}

		ListNode b = head.next;
		head.next = null;

		return b;
	}

}
