package models;

public class CustomerEntry {
		    Integer id;
		    String fname;
		    String lname;
		    String emailAddress;

		    public CustomerEntry( Integer id, String fname, String lname, String emailAddress )
		    {
		        this.id = id;
		        this.fname = fname;
		        this.lname = lname;
		        this.emailAddress = emailAddress;
		    }

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getFname() {
				return fname;
			}

			public void setFname(String fname) {
				this.fname = fname;
			}

			public String getLname() {
				return lname;
			}

			public void setLname(String lname) {
				this.lname = lname;
			}

			public String getEmailAddress() {
				return emailAddress;
			}

			public void setEmailAddress(String emailAddress) {
				this.emailAddress = emailAddress;
			}

	
}
