package abstractclass;


public class Main {

	public static void main(String[] args) {

		Dog dog = new Dog("Yorkie");
		dog.breathe();
		dog.eat();
		
		Parrot bird= new Parrot("Australian ringneck");
		bird.breathe();
		bird.eat();
		bird.fly();
		
		Penguin penguin = new Penguin("Emperor");
		penguin.fly();
		
		
	}

}
