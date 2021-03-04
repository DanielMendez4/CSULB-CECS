package lab1;

public class TruthTable {
	
	private String impResult;
	private String orResult;
	private String andResult;
	private String biResult;
	private String negResult;
	private boolean impAns;
	private boolean orAns;
	private boolean andAns;
	private boolean biAns;
	private boolean negAns;
	
	public boolean implication(boolean p, boolean q) {
		if (p == true) {
			if (q == true) {
				impResult = "true";
			}
		}
		if (p == true) {
			if (q == false) {
				impResult = "false";
			}
		}
		if (p == false) {
			if (q == true) {
				impResult = "true";
			}
		}
		if (p == false) {
			if (q == false) {
				impResult = "true";
			}
		}
		if (impResult == "true") {
			impAns = true;
		} else {
			impAns = false;
		}
		return impAns;
	}
	
	public boolean or(boolean p, boolean q) {
		if (p == true) {
			if (q == true) {
				orResult = "true";
			}
		}
		if (p == true) {
			if (q == false) {
				orResult = "true";
			}
		}
		if (p == false) {
			if (q == true) {
				orResult = "true";
			}
		}
		if (p == false) {
			if (q == false) {
				orResult = "false";
			}
		}
		if (orResult == "true") {
			orAns = true;
		} else {
			orAns = false;
		}
		return orAns;
	}
	
	public boolean and(boolean p, boolean q) {
		if (p == true) {
			if (q == true) {
				andResult = "true";
			}
		}
		if (p == true) {
			if (q == false) {
				andResult = "false";
			}
		}
		if (p == false) {
			if (q == true) {
				andResult = "false";
			}
		}
		if (p == false) {
			if (q == false) {
				andResult = "false";
			}
		}
		if (andResult == "true") {
			andAns = true;
		} else {
			andAns = false;
		}
		return andAns;
	}
	
	public boolean biconditional(boolean p, boolean q) {
		if (p == true) {
			if (q == true) {
				biResult = "true";
			}
		}
		if (p == true) {
			if (q == false) {
				biResult = "false";
			}
		}
		if (p == false) {
			if (q == true) {
				biResult = "false";
			}
		}
		if (p == false) {
			if (q == false) {
				biResult = "true";
			}
		}
		if (biResult == "true") {
			biAns = true;
		} else {
			biAns = false;
		}
		return biAns;
	}
	
	public boolean negation(boolean p) {
		if (p == true) {
			negResult = "false";
		} else {
			if (p == false) {
				negResult = "true";
			}
		}
		if (negResult == "true") {
			negAns = true;
		} else {
			negAns = false;
		}
		return negAns;
	}

	public static void main(String[] args) {
		
		boolean pList[] = new boolean[] {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
		boolean qList[] = new boolean[] {true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false,true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false};
		boolean rList[] = new boolean[] {true,true,true,true,false,false,false,false,true,true,true,true,false,false,false,false,true,true,true,true,false,false,false,false,true,true,true,true,false,false,false,false};
		boolean sList[] = new boolean[] {true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false,true,true,false,false};
		boolean tList[] = new boolean[] {true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false};
		boolean expList[] = new boolean[32];
		
		System.out.println("p\t\tq\t\tr\t\ts\t\tt\t\texpression");
		
		TruthTable lab1 = new TruthTable();
		
		for (int i = 0; i < pList.length; i++) {
			lab1.implication(pList[i], qList[i]);
			lab1.and(rList[i], tList[i]);
			lab1.negation(sList[i]);
			lab1.or(lab1.andAns, lab1.negAns);
			expList[i] = lab1.biconditional(lab1.impAns, lab1.orAns);
			System.out.println(pList[i] + "\t\t" + qList[i] + "\t\t" + rList[i] + "\t\t" + sList[i] + "\t\t" + tList[i] + "\t\t" + expList[i]);
		}
	}
}
