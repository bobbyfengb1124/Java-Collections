package thread;

public class AnotherThread  extends Thread {

	@Override
	public void run() {
		System.out.println(ThreadColor.ANSI_BLUE + "Hello from " + currentThread().getName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("BLUEEE: " + "Another Thread woke me up.");
			return;
		}
		
		System.out.println("BLUEEE: " + "Three second have passed and I'm awake");
	}
}
