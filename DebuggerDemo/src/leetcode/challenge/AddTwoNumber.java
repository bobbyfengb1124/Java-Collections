package leetcode.challenge;


public class AddTwoNumber {

	public static void main(String[] args) {
		ListNode list1Node1 = new ListNode(2);
		ListNode list1Node2 = new ListNode(4);
		ListNode list1Node3 = new ListNode(3);
		list1Node1.next = list1Node2;
		list1Node2.next = list1Node3;

		ListNode list2Node1 = new ListNode(5);
		ListNode list2Node2 = new ListNode(6);
		ListNode list2Node3 = new ListNode(4);
//		ListNode list2Node4 = new ListNode(9);
//		ListNode list2Node5 = new ListNode(9);
//		ListNode list2Node6 = new ListNode(9);
//		ListNode list2Node7 = new ListNode(9);
//		ListNode list2Node8 = new ListNode(9);
//		ListNode list2Node9 = new ListNode(9);
//		ListNode list2Node10 = new ListNode(9);
		list2Node1.next = list2Node2;
		list2Node2.next = list2Node3;
//		list2Node3.next = list2Node4;
//		list2Node4.next = list2Node5;
//		list2Node5.next = list2Node6;
//		list2Node6.next = list2Node7;
//		list2Node7.next = list2Node8;
//		list2Node8.next = list2Node9;
//		list2Node9.next = list2Node10;

		ListNode ret = addTwoNumbers(list1Node1, list2Node1);
		ListNode cur = ret;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = l1.val+l2.val;
		boolean addBit=false;
		ListNode ret = new ListNode(sum%10);
		addBit = jinwei(sum);
		myAddTwoNumbers(ret, l1.next, l2.next, addBit);
		
		return ret;

//		ListNode cur1 = l1;
//		ListNode cur2 = l2;
//		ListNode cur;
//		boolean addBit = false;
//		int i = 0;
//		int sum = 0;
//		while (cur1 != null && cur2 != null) {
//			if (addBit) {
//				sum = cur1.val + cur2.val + 1;
//			} else {
//				sum = cur1.val + cur2.val;
//			}
//			ret = new ListNode(sum%10);
//
//			if (sum > 9) {
//				ret.next = new ListNode(0);
//				addBit = true;
//			} else {
//				ret.next = null;
//				addBit = false;
//			}
//			
//			ret = new ListNode(sum%10);
//			ret.next = new ListNode(0);
//
//			i++;
//			cur1 = cur1.next;
//			cur2 = cur2.next;
//		}

		// Stack<Integer> nums = new Stack<>();
		//
		// String n1 = formNumberString(l1);
		// String n2 = formNumberString(l2);
		//
		// String sum = calculateSumString(n1, n2);
		//
		// // long sum = n1 + n2;
		//
		// System.out.println("*******************");
		// System.out.println(n1);
		// System.out.println(n2);
		// // System.out.println(sum);
		// System.out.println("*******************");
		//
		// String currentNumber = sum.substring(0, 1);
		// int number = Integer.valueOf(currentNumber);
		// nums.push(number);
		//
		// for (int i = 1; i < sum.length(); i++) {
		// currentNumber = sum.substring(i, i + 1);
		// number = Integer.valueOf(currentNumber);
		//
		// nums.push(number);
		//
		// }
		//
		// ret = new ListNode(nums.pop());
		// ListNode cur = ret;
		// for (int i = 1; i < sum.length(); i++) {
		// cur.next = new ListNode(nums.pop());
		// cur = cur.next;
		// }
		//
		// return ret;
	}

	public static boolean jinwei(int sum) {
		boolean addBit;
		if(sum>9) {
			addBit=true;
		}
		else {
			addBit=false;
		}
		return addBit;
	}

	private static void myAddTwoNumbers(ListNode ret, ListNode next, ListNode next2, boolean addBit) {
		if(next==null && next2==null && addBit==false) {
			return;
		}
		
		if(next==null && next2==null && addBit==true) {
			ret.next = new ListNode(1);
			return;
		}
		
		int add=0;
		if(addBit) {
			add=1;
		}
		
		if(next==null && next2!=null) {
			ret.next = new ListNode((add + next2.val)%10);
			myAddTwoNumbers(ret.next, null, next2.next, jinwei(add + next2.val));
		}
		
		if(next!=null && next2==null) {
			ret.next = new ListNode((add + next.val)%10);
			myAddTwoNumbers(ret.next, next.next, null, jinwei(add + next.val));
		}
		
		if(next!=null && next2!=null) {
			ret.next = new ListNode((add + next.val+ next2.val)%10);
			myAddTwoNumbers(ret.next, next.next, next2.next, jinwei(add + next.val+ next2.val));
		}
		
		
	}

	private static String calculateSumString(String n1, String n2) {
		int maxLength = 0, minLength = 0;
		if (n1.length() >= n2.length()) {
			maxLength = n1.length();
			minLength = n2.length();
		} else {
			maxLength = n2.length();
			minLength = n1.length();
		}

		StringBuffer ret = new StringBuffer();
		boolean addBit = false;
		int num1 = 0, num2 = 0;

		for (int i = 0; i < maxLength; i++) {
			if (i < minLength) {
				num1 = Integer.valueOf(n1.substring(i, i + 1));
				num2 = Integer.valueOf(n2.substring(i, i + 1));
			} else {
				if (n1.length() > n2.length()) {
					num1 = Integer.valueOf(n1.substring(i, i + 1));
					num2 = 0;
				} else {
					num1 = 0;
					num2 = Integer.valueOf(n2.substring(i, i + 1));
				}
			}
			int sum = num1 + num2;

			if (addBit) {
				sum = (num1 + num2) % 10 + 1;
			} else {
				sum = (num1 + num2) % 10;
			}

			if (sum > 10) {
				addBit = true;
			} else {
				addBit = false;
			}

			ret.append(sum);
		}

		return ret.toString();
	}

}
