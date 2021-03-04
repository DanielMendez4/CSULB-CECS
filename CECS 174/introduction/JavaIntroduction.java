package introduction;
/**
 * @author Daniel
 *
 */
public class JavaIntroduction {
	private static final float MartianWeightRatio = 0.377f;
	private static final float MartianAgeRatio = 0.53191489361702127659574468085106f; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String myName = "Daniel";
		int myAge = 18;
		boolean amIaStudent = true;
		int myWeight = 154;
		float newWeight = myWeight * MartianWeightRatio;
		float newAge = myAge * MartianAgeRatio;
		String result = String.format("My name is %s and I am %d years old.\nAm I a student? %b.\nMy Martian age would be %f and my Martian weight would be %f.",myName,myAge,amIaStudent,newAge,newWeight);
		System.out.println(result);
	}
}
