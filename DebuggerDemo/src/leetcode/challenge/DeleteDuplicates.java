package leetcode.challenge;

public class DeleteDuplicates {

	public static void main(String[] args) {
		DeleteDuplicates i = new DeleteDuplicates();
		ListNode n1 = i.new ListNode(1);
		ListNode n2 = i.new ListNode(1);
		n1.next = n2;
		ListNode n3 = i.new ListNode(2);
		n2.next = n3;
		deleteDuplicates(n1);
		printList(n1);

		ListNode n4 = i.new ListNode(1);
		ListNode n5 = i.new ListNode(1);
		ListNode n6 = i.new ListNode(2);
		ListNode n7 = i.new ListNode(3);
		ListNode n8 = i.new ListNode(3);
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		deleteDuplicates(n4);
		printList(n4);

		ListNode n9 = i.new ListNode(1);
		ListNode n10 = i.new ListNode(1);
		ListNode n11 = i.new ListNode(1);
		n9.next = n10;
		n10.next = n11;
		deleteDuplicates(n9);
		printList(n9);

	}

	public static void printList(ListNode n1) {
		ListNode cur = n1;
		while (cur != null) {
			System.out.print(cur.val + " ");

			cur = cur.next;
		}
		System.out.println("");
		System.out.println("=======");
	}

	public static ListNode deleteDuplicates(ListNode head) {

		ListNode cur = head;
		if (cur == null) {
			return null;
		}

		while (cur != null) {
			if (cur.next != null) {
				if (cur.val == cur.next.val) {
					if (cur.next.next != null) {
						cur.next = cur.next.next;
						continue;
					} else {
						cur.next = null;
						break;
					}
				}
			}
			cur = cur.next;
		}

		return head;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
