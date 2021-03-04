package hw2;

public class Records {
	
	private String className;
	private String grade;
	
	// The default constructor
	public Records() {
		className = "N\\A";
		grade = "N\\A";
	}
	
	/**
	 * The overloaded constructor
	 * @param className: name of the class
	 * @param grade: grade received for that class
	 * **/
	public Records(String className, String grade) {
		this.className = className;
		this.grade = grade;
	}
	
	/**
	 * Gets the class name
	 * @return className
	 * **/
	public String getClassName() {
		return className;
	}
	
	/**
	 * Gets the grade
	 * @return grade
	 * **/
	public String getGrade() {
		return grade;
	}
	
	/**
	 * Sets the class name
	 * @param className: name of the class
	 * **/
	public void setClass(String className) {
		this.className = className;
	}
	
	/**
	 * Sets the grade
	 * @param grade: grade received for that class
	 * **/
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String toString() {
		String info = String.format("%-20s%s", this.className, this.grade);
		return info;
	}
}
