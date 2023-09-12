package pojoclasses;

public class PartialUpdatePojo {
//	Required variables.
	private String firstname;
	private String lastname;

//	Constructor
	public PartialUpdatePojo(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
//	Getter setter methods.

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

}
