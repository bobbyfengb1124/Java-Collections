package leetcode.challenge;

public class LinkedListCycleI {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListCycleI t = new LinkedListCycleI();
		ListNode n1 = t.new ListNode(3);
		ListNode n2 = t.new ListNode(2);
		n1.next = n2;
		ListNode n3 = t.new ListNode(0);
		n2.next = n3;
		ListNode n4 = t.new ListNode(-4);
		n3.next = n4;
		n4.next = n2;
		System.out.println(hasCycle(n1));
		
		ListNode n5 = t.new ListNode(1);
		System.out.println(hasCycle(n5));

	}

	public static boolean hasCycle(ListNode head) {

		ListNode fast = head, slow = head;

		while (fast != null && slow != null) {

			if (fast.next != null) {
				if (fast.next.next != null) {
					fast = fast.next.next;
				}
				else {
					break;
				}
			} else {
				break;
			}
			
			if(slow.next!=null) {
				slow = slow.next;
			}
			else {
				break;
			}
			
			if(fast == slow) {
				return true;
			}
		}

		return false;

	}

}
