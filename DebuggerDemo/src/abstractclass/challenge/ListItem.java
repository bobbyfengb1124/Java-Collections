package abstractclass.challenge;

public abstract class ListItem {
	
	Object value;
	
	protected ListItem rightLink = null;
	protected ListItem leftLink = null;
	
	public ListItem(Object value) {
		this.value = value;
	}
	abstract ListItem next();
	abstract ListItem setNext(ListItem item);
	abstract ListItem previous();
	abstract ListItem setPrevisou(ListItem item);
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}

	abstract int compareTo(ListItem item);
}
