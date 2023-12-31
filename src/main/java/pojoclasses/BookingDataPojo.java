package pojoclasses;

public class BookingDataPojo {
//		Required variables.
		private String firstname;
	    private String lastname;
	    private int totalprice;
	    private boolean depositpaid;
	    private BookingDatesPojo bookingdates;
	    private String additionalneeds;
	    
//	    Constructor.
	    public BookingDataPojo(String firstname,String lastname,
	    		int totalprice,boolean depositpaid,BookingDatesPojo bookingdates,String additionalneeds) {
	    	this.firstname = firstname;
	    	this.lastname = lastname;
	    	this.totalprice = totalprice;
	    	this.depositpaid = depositpaid;
	    	this.bookingdates = bookingdates;
	    	this.additionalneeds = additionalneeds;
	    }
	    
//	    getter setter methods.

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public int getTotalprice() {
			return totalprice;
		}

		public void setTotalprice(int totalprice) {
			this.totalprice = totalprice;
		}

		public boolean getDepositpaid() {
			return depositpaid;
		}

		public void setDepositpaid(boolean depositpaid) {
			this.depositpaid = depositpaid;
		}

		public BookingDatesPojo getBookingdates() {
			return bookingdates;
		}

		public void setBookingdates(BookingDatesPojo bookingdates) {
			this.bookingdates = bookingdates;
		}

		public String getAdditionalneeds() {
			return additionalneeds;
		}

		public void setAdditionalneeds(String additionalneeds) {
			this.additionalneeds = additionalneeds;
		}
	    
	    
}

