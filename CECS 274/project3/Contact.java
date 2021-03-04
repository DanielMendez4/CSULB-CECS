package project3;

public class Contact {
	
	private String name;
    private String phoneNum;
    private String email;
    private String note;
    private String contactInfo[];
    
    // The default constructor
    public Contact() {
    	name = "N/A";
    	phoneNum = "N/A";
    	email = "N/A";
    	note = "N/A";
    }

    /** The overloaded constructor 
    * @param name: name of the contact
    * @param phoneNum: phone number of the contact
    * @param email: email of the contact
    * @param note: note for the contact
    **/
    public Contact(String name, String phoneNum, String email, String note) {
    	contactInfo = new String[4];
        this.name = name;
        contactInfo[0] = this.name;
        this.phoneNum = phoneNum;
        contactInfo[1] = this.phoneNum;
        this.email = email;
        contactInfo[2] = this.email;
        this.note = note;
        contactInfo[3] = this.note;
    }

    /** 
	* Gets the name of the contact 
	* @return name
	**/
    public String getName() {
    	return contactInfo[0];
    }

    /** 
	* Gets the phone number of the contact 
	* @return phoneNum
	**/
    public String getPhoneNum() {
        return contactInfo[1];
    }

	/** 
	* Gets the email address of the contact
	* @return email
	**/
    public String getEmail() {
        return contactInfo[2];
    }
	
	/** 
	* Gets the note for the contact 
	* @return note
	**/
    public String getNote() {
        return contactInfo[3];
    }

    /** 
	* Sets the name for the contact 
	* @param name: name of the contact
	**/
    public void setName(String name) {
        this.name = name;
        contactInfo[0] = this.name;
    }

    /**
    * Sets the phone number for the contact 
    * @param phoneNum: the phone number of the contact
    **/
    public void setPhoneNum(String phoneNum ) {
    	this.phoneNum = phoneNum;
    	contactInfo[1] = this.phoneNum;
    }

    /**
    * Sets the email for the contact 
    * @param email: the email of the contact
    **/
    public void setEmail(String email) {
        this.email = email;
        contactInfo[2] = this.email;
    }

    /** 
	* Sets the note for the contact
	* @param note: the note of the contact
	**/
    public void setNote(String note) {
    	this.note = note;
    	contactInfo[3] = this.note;
    }
    
    public String toString() {
    	String formatPhone = "";
    	if (contactInfo[1].length() == 10) {
    		formatPhone = contactInfo[1].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    	}
    	if (contactInfo[1].length() == 7) {
    		formatPhone = contactInfo[1].replaceFirst("(\\d{3})(\\d+)", "$1-$2");
    	}
    	return contactInfo[0] + "\t" + formatPhone + "\t" + contactInfo[2] + "\t" + contactInfo[3];
    }
}
