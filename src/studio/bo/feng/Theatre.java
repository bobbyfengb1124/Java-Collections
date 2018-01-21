/**
 * 
 */
package studio.bo.feng;

import java.util.ArrayList;
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
		Seat requestedSeat = null;
		for(Seat seat : seats) {
			if(seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}
		}
		
		if (requestedSeat == null) {
			System.out.println("There is no seat" + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve();
	}
	
	public void getSeats() {
		for(Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	
	
}
