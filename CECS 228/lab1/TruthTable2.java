package lab1;

public class TruthTable2 {
	
	public static boolean implication(boolean p, boolean q) {
		boolean result = false;
		if (p == true) {
			if (q == true) {
				result = true;
			}
		}
		if (p == true) {
			if (q == false) {
				result = false;
			}
		}
		if (p == false) {
			if (q == true) {
				result = true;
			}
		}
		if (p == false) {
			if (q == false) {
				result = true;
			}
		}
		return result;
	}
	
	public static boolean or(boolean p, boolean q) {
		boolean result = false;
		if (p == true) {
			if (q == true) {
				result = true;
			}
		}
		if (p == true) {
			if (q == false) {
				result = true;
			}
		}
		if (p == false) {
			if (q == true) {
				result = true;
			}
		}
		if (p == false) {
			if (q == false) {
				result = false;
			}
		}
		return result;
	}
	
	public static boolean and(boolean p, boolean q) {
		boolean result = false;
		if (p == true) {
			if (q == true) {
				result = true;
			}
		}
		if (p == true) {
			if (q == false) {
				result = false;
			}
		}
		if (p == false) {
			if (q == true) {
				result = false;
			}
		}
		if (p == false) {
			if (q == false) {
				result = false;
			}
		}
		return result;
	}
	
	public static boolean biconditional(boolean p, boolean q) {
		boolean result = false;
		if (p == true) {
			if (q == true) {
				result = true;
			}
		}
		if (p == true) {
			if (q == false) {
				result = false;
			}
		}
		if (p == false) {
			if (q == true) {
				result = false;
			}
		}
		if (p == false) {
			if (q == false) {
				result = true;
			}
		}
		return result;
	}
	
	public static boolean negation(boolean p) {
		boolean result = false;
		if (p == true) {
			result = false;
		} else {
			if (p == false) {
				result = true;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		boolean pList[] = new boolean[] {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
		boolean qList[] = new boolean[] {true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false,true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false};
		boolean rList[] = new boolean[] {true,true,true,true,false,false,false,false,true,true,true,true,false,false,false,false,true,true,true,true,false,false,false,false,true,true,true,true,false,false,false,false};
		boolean sList[] = new boolean[] {true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false};
		boolean tList[] = new boolean[] {true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false};
		boolean expList[] = new boolean[32];
		
		System.out.println("p\t\tq\t\tr\t\ts\t\tt\t\texpression");
		
		for (int i = 0; i < pList.length; i++) {
			expList[i] = biconditional(implication(pList[i], qList[i]), or(and(rList[i], tList[i]), negation(sList[i])));
			System.out.println(pList[i] + "\t\t" + qList[i] + "\t\t" + rList[i] + "\t\t" + sList[i] + "\t\t" + tList[i] + "\t\t" + expList[i]);
		}
	}
}