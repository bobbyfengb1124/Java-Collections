/**
 * 
 */
package studio.bo.feng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bobbyfeng
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Theatre theatre = new Theatre("Olympian", 8, 12);

		if (theatre.reserveSeat("D12")) {
			System.out.println("Please pay for D12");
		} else {
			System.out.println("Seat already reserved");
		}
		
		if (theatre.reserveSeat("D12")) {
			System.out.println("Please pay for D12");
		} else {
			System.out.println("Seat already reserved");
		}
		
		if (theatre.reserveSeat("B13")) {
			System.out.println("Please pay for B13");
		} else {
			System.out.println("Seat already reserved");
		}
		
		List<Seat> reserveSeats = new ArrayList<>(theatre.getSeats());
		Collections.reverse(reserveSeats);
		printList(reserveSeats);
		
		
		List<Seat> priceSeats = new ArrayList<>(theatre.getSeats());
		priceSeats.add(new Seat("B00", 13.00));
		priceSeats.add(new Seat("A00", 13.00));
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);

		printList(priceSeats);
	}

	public static void printList(List<Seat> list) {
		for (Seat seat : list) {
			System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
		}
		System.out.println();
		System.out.println("=============================================");
	}
	

}
