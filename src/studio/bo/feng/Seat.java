/**
 * 
 */
package studio.bo.feng;

/**
 * @author bobbyfeng
 *
 */
public class Seat implements Comparable<Seat>{

	private final String seatNumber;
	private boolean reserved = false;
	
	
	public Seat(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	@Override
	public int compareTo(Seat seat) {
		return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
	}

	public boolean reserve() {
		if(!this.reserved) {
			this.reserved = true;
			System.out.println("Seat" + seatNumber + " reserved");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean cancel() {
		if(this.reserved) {
			this.reserved = false;
			System.out.println("Reservation of seat " + seatNumber + " cancelled");
			return true;
		}
		else {
			return false;
		}
	}

	public String getSeatNumber() {
		return this.seatNumber;
	}
}
