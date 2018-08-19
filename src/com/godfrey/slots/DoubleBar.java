package com.godfrey.slots;

public class DoubleBar extends Symbol implements AnyBar {

	private String [] rep = new String [12];
	
	public DoubleBar() {
		rep[0] = "                   ";
		rep[1] = "                   ";
		rep[2] = "                   ";
		rep[3] = "    ===========    ";
		rep[4] = "   |    BAR    |   ";
		rep[5] = "   |===========|   ";
		rep[6] = "   |    BAR    |   ";
		rep[7] = "    ===========    ";
		rep[8] = "                   ";
		rep[9] = "                   ";
	}
	
	@Override
	protected int getBaseValue() {
		return 20;
	}

	@Override
	public String toString() {
		return "Double Bar";
	}

	public int getAnyBarValue() {
		return 5;
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
