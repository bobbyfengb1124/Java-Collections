package abstractclass;

public class Penguin extends Bird {

	public Penguin(String name) {
		super(name);
	}

	@Override
	public void fly() {
		super.fly();
		System.out.println("I am not very good at that, can I go for a swim instead?");
	}

}
