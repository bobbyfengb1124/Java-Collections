/**
 * 
 */
package studio.bo.feng;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Templates;

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
		List<Seat> seatCopy = new ArrayList<>(theatre.seats);
		printList(seatCopy);

		seatCopy.get(1).reserve();
		if (theatre.reserveSeat("A02")) {
			System.out.println("Please pay for A02");
		} else {
			System.out.println("Seat already reserved");
		}

		Collections.shuffle(seatCopy);
		System.out.println("Printing seatCopy");
		printList(seatCopy);
		System.out.println("Print theatre.seat");
		printList(theatre.seats);

		Seat minSeat = Collections.min(seatCopy);
		Seat maxSeat = Collections.max(seatCopy);
		System.out.println("Min seat number is " + minSeat.getSeatNumber());
		System.out.println("Max seat number is " + maxSeat.getSeatNumber());
		
		sortList(seatCopy);
		System.out.println("Printing sorted seatCopy");
		printList(seatCopy);
		
		List<Seat> newList = new ArrayList<>(theatre.seats.size());
		Collections.copy(newList, theatre.seats);
	}

	public static void printList(List<Seat> list) {
		for (Seat seat : list) {
			System.out.print(" " + seat.getSeatNumber());
		}
		System.out.println();
		System.out.println("=============================================");
	}
	
	public static void sortList(List<? extends Seat> list) {
		for(int i =0; i<list.size()-1;i++) {
			for(int j =i+1; j<list.size();j++) {
				if(list.get(i).compareTo(list.get(j))>0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}

}
