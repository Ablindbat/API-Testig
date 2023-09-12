package pojoclasses;

public class BookingDatesPojo {
//	Required variables.
	private String checkin;
	private String checkout;
	
//	Constructor.
	public BookingDatesPojo(String checkin,String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

//	Getter setter methods.
	
	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	

}
