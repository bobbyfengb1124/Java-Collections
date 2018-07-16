package ds.stack;

public class Stack {

	private int maxSize;
	private char[] stackArray;
	private int top;

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}

	public void push(char j) {
		if (!isFull()) {
			top++;
			stackArray[top] = j;
		} else {
			System.out.println(" this stack is already full");
		}
	}

	public char pop() {
		if (!isEmpty()) {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
		else {
			System.out.println("the stack is already empty");
			return '0';
		}
	}

	public long peak() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return ((maxSize - 1) == top);
	}
}
