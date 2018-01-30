/**
 * 
 */
package studio.bo.feng;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		for(char row = 'A'; row <= lastRow; row++) {
			for(int seatNum =1; seatNum<=seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}


	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = new Seat(seatNumber);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if(foundSeat >=0) {
			return seats.get(foundSeat).reserve();
		}
		else {
			System.out.println("There is no seat" + seatNumber);
			return false;
		}
		
//		for(Seat seat : seats) {
//			System.out.print(".");
//			if(seat.getSeatNumber().equals(seatNumber)) {
//				requestedSeat = seat;
//				break;
//			}
//		}
//		
//		if (requestedSeat == null) {
//			System.out.println("There is no seat" + seatNumber);
//			return false;
//		}
//		
//		return requestedSeat.reserve();
	}
	
	public void getSeats() {
		for(Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	
	
}
