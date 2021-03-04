package week7;

public class Contact {
	
	private String name;
	private String phone;
	private String email;
	private String note;
	
	public Contact() {
		name = "N/A";
		phone = "N/A";
		email = "N/A";
		note = "N/A";
	}
	
	public Contact(String name, String phone, String email, String note) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.note = note;	
	}
	
	public void add(String newName, String newPhoneNum, String newEmail, String newNote) {
		name = newName;
		phone = newPhoneNum;
		email = newEmail;
		note = newNote;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public void deleteContact(String name, String phone, String email, String note) {
		this.name = "N/A";
		this.phone = "N/A";
		this.email = "N/A";
		this.note = "N/A";
	}
	
	public String getName() {
		return name;
	}
		
	public String getPhone() {	
		return phone;
	}
		
	public String getEmail() {	
		return email;
	}
		
	public String getNote() {	
		return note;
	}
		
	public String toString() {	
		String info = String.format("%s  %s  %s  %s", this.name, this.phone, this.email, this.note);
		return info;
	}
}
