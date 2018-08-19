package com.godfrey.slots;

public class DoubleSeven extends Symbol implements AnySeven {

	private String [] rep = new String [12];
	
	public DoubleSeven() {
		rep[0] = "                   ";
		rep[1] = "  ___________      ";
		rep[2] = " |  _________|__   ";
		rep[3] = " |__|           |  ";
		rep[4] = "    |______     |  ";
		rep[5] = "      /   /    /   ";
		rep[6] = "     /   /    /    ";
		rep[7] = "    /   /    /     ";
		rep[8] = "   /___/    /      ";
		rep[9] = "      /____/       ";
	}
	
	@Override
	protected int getBaseValue() {
		return 50;
	}

	@Override
	public String toString() {
		return "Double Seven";
	}

	public int getAnySevenValue() {
		return ANY_SEVEN_VALUE;
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
