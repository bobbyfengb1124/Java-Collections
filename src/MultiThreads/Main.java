package MultiThreads;

public class Main {

	public static void main(String[] args) {
		CountDown countDown = new CountDown();
		
		CountdownTHread t1 = new CountdownTHread(countDown);
		t1.setName("Thread 1");
		
		CountdownTHread t2 = new CountdownTHread(countDown);
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
	}
}

class CountDown {
	int i;
	
	public void doCountdown() {
		String color;
		
		switch (Thread.currentThread().getName()) {
		case "Thread 1":
			color = "CYAN";
			break;
		case "Thread 2":
			color = "PURPLE";
			break;
		default:
			color = "GREEN";
			break;
		}
		
		for(i=10; i > 0; i--) {
			System.out.println(color +" " + Thread.currentThread().getName() + ": i =" + i);
		}
	}
}

class CountdownTHread extends Thread {
	private CountDown threadCountdown;

	public CountdownTHread(CountDown threadCountdown) {
		this.threadCountdown = threadCountdown;
	}
	
	public void run() {
		threadCountdown.doCountdown();
	}
}
