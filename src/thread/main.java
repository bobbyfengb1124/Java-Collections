package thread;


public class main {

	public static void main(String[] args) {

		System.out.println("PURPLEEE: " + "Hello from the main thread.");
		
		Thread anotherThread = new AnotherThread();
		anotherThread.setName("== Another Thread ==");
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println("REDDD:" +"Hello from the anonymous class thread");
			}
		}.start();
		
		Thread myRunnableThread = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println("REDDDD: " + "Hello from the anonymous class's implementation of run ");
				try {
					anotherThread.join();
					System.out.println("REDDD: " + "AnotherThread terminated or timed out, so I'm running again");
				} catch (InterruptedException e) {
					System.out.println("REDDD: " + "I couln't wait after alll. I was interrupted");
				}
			}
		});
		myRunnableThread.start();
		
		System.out.println("Hello again from the main thread.");
	}

}
