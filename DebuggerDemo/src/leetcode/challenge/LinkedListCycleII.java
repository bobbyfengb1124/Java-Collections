package leetcode.challenge;


public class LinkedListCycleII {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListCycleII t = new LinkedListCycleII();
		ListNode n1 = t.new ListNode(3);
		ListNode n2 = t.new ListNode(2);
		n1.next = n2;
		ListNode n3 = t.new ListNode(0);
		n2.next = n3;
		ListNode n4 = t.new ListNode(-4);
		n3.next = n4;
		n4.next = n2;
		System.out.println(detectCycle(n1).val);
		
		ListNode n5 = t.new ListNode(1);
		System.out.println(detectCycle(n5));
		
		ListNode n6 = t.new ListNode(1);
		ListNode n7 = t.new ListNode(2);
		n6.next = n7;
		n7.next = n6;
		System.out.println(detectCycle(n6).val);

	}

	public static ListNode detectCycle(ListNode head) {

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
				return findCycleHead(head, fast);
			}
		}

		return null;

	}

	private static ListNode findCycleHead(ListNode head, ListNode meeting) {
		ListNode cur1 = head;
		ListNode cur2 = meeting;
		
		while(cur1!=null && cur2!=null) {
			if(cur1==cur2) {
				return cur1;
			}
			
			cur1 = cur1.next;
			cur2 = cur2.next;
		}

		return null;
	}

}
