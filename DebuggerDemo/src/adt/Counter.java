package adt;

public class Counter {
	
	private String name;
	private int value = 0;

	public Counter(String str) {
		this.name = str;
	}

	public void increment() {
		this.value++;
	}

	public int getCurrentValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "Counter [str=" + name + ", value=" + value + "]";
	}

}
