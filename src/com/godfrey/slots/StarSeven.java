package com.godfrey.slots;

public class StarSeven extends Symbol implements AnySeven {

	private String [] rep = new String [12];
	
	public StarSeven() {
		rep[0] = "                   ";
		rep[1] = "                   ";
		rep[2] = "  ***************  ";
		rep[3] = "  ***************  ";
		rep[4] = "  **************   ";
		rep[5] = "        *******    ";
		rep[6] = "       *******     ";
		rep[7] = "      *******      ";
		rep[8] = "     *******       ";
		rep[9] = "    *******        ";
	}
	
	@Override
	protected int getBaseValue() {
		return 120;
	}

	public int getAnySevenValue() {
		return ANY_SEVEN_VALUE;
	}

	@Override
	public String toString() {
		return "StarSeven";
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
