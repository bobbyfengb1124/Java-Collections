package algo.mergesort;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode li11 = new ListNode(1);
		ListNode li12 = new ListNode(2);
		li11.next = li12;
		ListNode li13 = new ListNode(4);
		li12.next = li13;

		ListNode li21 = new ListNode(1);
		ListNode li22 = new ListNode(3);
		li21.next = li22;
		ListNode li23 = new ListNode(4);
		li22.next = li23;

		ListNode outcomeList = mergeTwoLists(li11, li21);

		while (outcomeList != null) {
			System.out.println(outcomeList.val);
			outcomeList = outcomeList.next;
		}

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode ret = new ListNode(0);

		ListNode cur = ret;
		while ((cur1 != null) && (cur2 != null)) {
			if (cur1.val < cur2.val) {
				cur.next = cur1;
				cur1 = cur1.next;
			} else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}

		if (cur1 == null) {
			cur.next = cur2;
		}

		if (cur2 == null) {
			cur.next = cur1;
		}

		return ret.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
