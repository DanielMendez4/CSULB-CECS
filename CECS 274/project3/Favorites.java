package project3;

public class Favorites {
	
	private String favname;
    private String favphoneNum;
    private String favemail;
    private String favnote;
    private String favimage;
    private static String favoritesInfo[];
       
    // The default constructor
    public Favorites() {
       favname = "N/A";
       favphoneNum = "N/A";
       favemail = "N/A";
       favnote = "N/A";
       favimage = "N/A";
    }

    /** The overloaded constructor
     * @param name: name of the contact
     * @param phoneNum: phone number of the contact
     * @param email: email of the contact
     * @param note: note for the contact
     * **/
    public Favorites(String favname, String favphoneNum, String favemail, String favnote, String favimage) {
    	favoritesInfo = new String[5];
    	this.favname = favname;
        favoritesInfo[0] = this.favname;
        this.favphoneNum = favphoneNum;
        favoritesInfo[1] = this.favphoneNum;
        this.favemail = favemail;
        favoritesInfo[2] = this.favemail;
        this.favnote = favnote;
        favoritesInfo[3] = this.favnote;
        this.favimage = favimage;
        favoritesInfo[4] = this.favimage;
    }

    /**
     * Gets the name of the contact
     * @return name
     * **/
    public static String getFavName() {
    	return favoritesInfo[0];
    }
    
    /**
     * Gets the phone number of the contact
     * @return phoneNum
     * **/
    public String getFavPhoneNum() {
    	return favoritesInfo[1];
    }

    /**
     * Gets the email address of the contact
     * @return email
     * **/
    public String getFavEmail() {
    	return favoritesInfo[2];
    }
       
    /**
     * Gets the note for the contact
     * @return note
     * **/
    public String getFavNote() {
    	return favoritesInfo[3];
    }
    
    public String getFavImage() {
    	return favoritesInfo[4];
    }

    /**
     * Sets the name for the contact
     * @param name: name of the contact
     * **/
    public void setFavName(String favname) {
    	this.favname = favname;
    	favoritesInfo[0] = this.favname;
    }

    /**
     * Sets the phone number for the contact
     * @param phoneNum: the phone number of the contact
     * **/
    public void setFavPhoneNum(String favphoneNum ) {
    	this.favphoneNum = favphoneNum;
    	favoritesInfo[1] = this.favphoneNum;
    }

    /**
     * Sets the email for the contact
     * @param email: the email of the contact
     * **/
    public void setFavEmail(String favemail) {
    	this.favemail = favemail;
    	favoritesInfo[2] = this.favemail;
    }

    /**
     * Sets the note for the contact
     * @param note: the note of the contact
     * **/
    public void setFavNote(String favnote) {
    	this.favnote = favnote;
    	favoritesInfo[3] = this.favnote;
    }
    
    /**
     * Sets the image for the contact
     * @param favimage: the image for the contact
     * **/
    public void setFavImage(String favimage) {
    	this.favimage = favimage;
    	favoritesInfo[4] = this.favimage;
    }
    
    public String toString() {
    	String formatPhone = "";
    	if (favoritesInfo[1].length() == 10) {
    		formatPhone = favoritesInfo[1].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    	}
    	if (favoritesInfo[1].length() == 7) {
    		formatPhone = favoritesInfo[1].replaceFirst("(\\d{3})(\\d+)", "$1-$2");
    	}
    	return favoritesInfo[0] + "\t" + formatPhone + "\t" + favoritesInfo[2] + "\t" + favoritesInfo[3] + "\t" + favoritesInfo[4];
    }
}
