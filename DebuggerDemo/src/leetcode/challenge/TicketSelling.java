package leetcode.challenge;

public class TicketSelling {

	private static int num = 0;
	private static int i = 0;

	public static void main(String[] args) {
		TicketSelling r = new TicketSelling();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				while (i < 10) {
					synchronized (this) {
						if (num == 0) {
							System.out.println(Thread.currentThread().getName() + " : " + num++);
						}
						i++;
					}
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				while (i < 10) {
					synchronized (this) {
						if (num == 1) {
							System.out.println(Thread.currentThread().getName() + " : " + num--);
						}
						i++;
					}
				}

			}
		});

		t1.start();
		t2.start();

	}

}
