package labAssignment4;

public class Bug {
	
	//Instance Variables: attributes of BugTester object
	//Position
	
	private int position;
	
	/**
	 * default constructor initializes the position to be at 0
	 * **/
	public Bug() {
		position = 0;
	}
	
	/**
	 * move the bug up by 10
	 * **/
	public void up() {
		if (position < 100) {
			position = position + 10;
		}
		if (position >= 100) {
			position = 0;
		}
	}
	
	/**
	 * returns current position of the bug
	 * @return position as an integer
	 * **/
	public int getPosition() {
		return position;
	}
}