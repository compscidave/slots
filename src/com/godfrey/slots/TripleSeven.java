package com.godfrey.slots;

public class TripleSeven extends Symbol implements AnySeven {

	private String [] rep = new String [12];
	
	public TripleSeven() {
		rep[0] = " ___________       ";
		rep[1] = "|  _________|__    ";
		rep[2] = "|__|   ________|__ ";
		rep[3] = "   |__|           |";
		rep[4] = "     /|______     |";
		rep[5] = "    /   /   /    / ";
		rep[6] = "   /   /   /    /  ";
		rep[7] = "  /___/   /    /   ";
		rep[8] = "     /___/    /    ";
		rep[9] = "        /____/     ";
	}
	
	public int getAnySevenValue() {
		return ANY_SEVEN_VALUE;
	}

	@Override
	protected int getBaseValue() {
		return 60;
	}

	@Override
	public String toString() {
		return "Triple Seven";
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
