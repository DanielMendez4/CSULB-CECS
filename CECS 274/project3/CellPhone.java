package project3;

public class CellPhone {
	
	private Favorites[] favList;
	private PhoneBook myPB;
	private Favorites myFav;
	
	public CellPhone() {
		favList = new Favorites[5];
		myPB = new PhoneBook();
		myFav = new Favorites();
	}
	
	public void addToPB(String addName, String addPhone, String addEmail, String addNote) {
		myPB.addContact(addName, addPhone, addEmail, addNote);
	}
	
	public void editNamePB(String existName, String replaceName) {
		myPB.editName(existName, replaceName);
	}
	
	public void editPhonePB(String existPhone, String replacePhone) {
		myPB.editPhone(existPhone, replacePhone);
	}
	
	public void editEmailPB(String existEmail, String replaceEmail) {
		myPB.editEmail(existEmail, replaceEmail);
	}
	
	public void editNotePB(String existNote, String replaceNote) {
		myPB.editNote(existNote, replaceNote);
	}
	
	public void deletePB(String delName, String delPhone, String delEmail, String delNote) {
		myPB.deleteContact(delName, delPhone, delEmail, delNote);
	}
	
	public void displayPB() {
		myPB.displayContact();
	}
	
	public boolean searchPB(String name) {
        return myPB.doesExist(name);
    }
	
	public void addFav(String name, String phoneNum, String email, String note, String image, int pos) {
		myFav = new Favorites(name, phoneNum, email, note, image);
        if (pos == 0) {
            favList[4] = favList[3];
            favList[3] = favList[2];
            favList[2] = favList[1];
            favList[1] = favList[0];
            favList[pos] = myFav;
        }
        
        if (pos == 1) {
            favList[4] = favList[3];
            favList[3] = favList[2];
            favList[2] = favList[1];
            favList[pos] = myFav;
        }
        
        if (pos == 2) {
            favList[4] = favList[3];
            favList[3] = favList [2];
            favList[pos] = myFav;
        }
        
        if (pos == 3) {
            favList[4] = favList[3];
            favList[pos] = myFav;
        }
        
        if (pos == 4) {
            favList[pos] = myFav;
        }
	}
    
    public void moveFav(int fav,int pos) {
        Favorites temp = favList[fav];
        for (int i = (fav - 1); i >= 0; i--) {                
            favList[i+1] = favList[i];
        }
        favList[pos] = temp;
    }
    
    public void deleteFav(int fav) {
        favList[fav] = null;
    }
    
    public void displayFav(String i) {
        int fWidth = 1200;
        int fHeight = 600;
        if(i.equals("0")) {
            FavoriteContactFrame favorite1 = new FavoriteContactFrame(favList[0].getFavImage(), fWidth, fHeight, Favorites.getFavName(), favList[0].getFavPhoneNum(), favList[0].getFavEmail(), favList[0].getFavNote());
            favorite1.displayContactFrame();
        }
        if(i.equals("1")) {
            FavoriteContactFrame favorite2 = new FavoriteContactFrame(favList[1].getFavImage(), fWidth, fHeight, Favorites.getFavName(), favList[1].getFavPhoneNum(), favList[1].getFavEmail(), favList[1].getFavNote());
            favorite2.displayContactFrame();
        }
        if(i.equals("2")) {
            FavoriteContactFrame favorite3 = new FavoriteContactFrame(favList[2].getFavImage(), fWidth, fHeight, Favorites.getFavName(), favList[2].getFavPhoneNum(), favList[2].getFavEmail(), favList[2].getFavNote());
            favorite3.displayContactFrame();
        }
        if(i.equals("3")) {
            FavoriteContactFrame favorite4 = new FavoriteContactFrame(favList[3].getFavImage(), fWidth, fHeight, Favorites.getFavName(), favList[3].getFavPhoneNum(), favList[3].getFavEmail(), favList[3].getFavNote());
            favorite4.displayContactFrame();
        }
        if(i.equals("4")) {
            FavoriteContactFrame favorite5 = new FavoriteContactFrame(favList[4].getFavImage(), fWidth, fHeight, Favorites.getFavName(), favList[4].getFavPhoneNum(), favList[4].getFavEmail(), favList[4].getFavNote());
            favorite5.displayContactFrame();
        }
    }
}
