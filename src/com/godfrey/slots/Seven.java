package com.godfrey.slots;

public class Seven extends Symbol implements AnySeven {

	private String [] rep = new String [12];
	
	public Seven() {
		rep[0] = "                   ";
		rep[1] = "    ___________    ";
		rep[2] = "   |           |   ";
		rep[3] = "   |______     |   ";
		rep[4] = "         /    /    ";
		rep[5] = "        /    /     ";
		rep[6] = "       /    /      ";
		rep[7] = "      /    /       ";
		rep[8] = "     /____/        ";
		rep[9] = "                   ";
	}
	
	@Override
	protected int getBaseValue() {
		return 40;
	}

	public int getAnySevenValue() {
		return ANY_SEVEN_VALUE;
	}

	@Override
	public String toString() {
		return "Seven";
	}

	@Override
	public String toString(boolean b, int i) {
		if(b) {
			return rep[i] + " |\n";
		} else {
			return rep[i];
		}
	}
}
