/**
 * 
 */
package studio.bo.feng;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bobbyfeng
 *
 */
public class Theatre {

	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {

		@Override
		public int compare(Seat seat1, Seat seat2) {
			if(seat1.getPrice() < seat2.getPrice()) {
				return -1;
			}else if (seat1.getPrice() > seat2.getPrice()) {
				return 1;
			}
			else {
				return 0;
			}
		}
	};

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				double price = 12.00;
				if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
					price = 14.00;
				} else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
					price = 7.00;
				}
				Seat seat = new Seat(row + String.format("%02d", seatNum), price);
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}

	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = new Seat(seatNumber, 0);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if (foundSeat >= 0) {
			return seats.get(foundSeat).reserve();
		} else {
			System.out.println("There is no seat" + seatNumber);
			return false;
		}

		// for(Seat seat : seats) {
		// System.out.print(".");
		// if(seat.getSeatNumber().equals(seatNumber)) {
		// requestedSeat = seat;
		// break;
		// }
		// }
		//
		// if (requestedSeat == null) {
		// System.out.println("There is no seat" + seatNumber);
		// return false;
		// }
		//
		// return requestedSeat.reserve();
	}

	public Collection<Seat> getSeats() {
		return seats;
	}

}
