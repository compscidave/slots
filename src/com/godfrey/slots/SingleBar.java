package com.godfrey.slots;

public class SingleBar extends Symbol implements AnyBar {

	private String [] rep = new String [12];
	
	public SingleBar() {
		rep[0] = "                   ";
		rep[1] = "                   ";
		rep[2] = "                   ";
		rep[3] = "                   ";
		rep[4] = "    ===========    ";
		rep[5] = "   |    BAR    |   ";
		rep[6] = "    ===========    ";
		rep[7] = "                   ";
		rep[8] = "                   ";
		rep[9] = "                   ";
	}
	
	@Override
	protected int getBaseValue() {
		return 10;
	}

	@Override
	public String toString() {
		return "Single Bar";
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
