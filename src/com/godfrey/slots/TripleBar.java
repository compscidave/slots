package com.godfrey.slots;

public class TripleBar extends Symbol implements AnyBar {

	private String [] rep = new String [12];
	
	public TripleBar() {
		rep[0] = "                   ";
		rep[1] = "                   ";
		rep[2] = "    ===========    ";
		rep[3] = "   |    BAR    |   ";
		rep[4] = "   |===========|   ";
		rep[5] = "   |    BAR    |   ";
		rep[6] = "   |===========|   ";
		rep[7] = "   |    BAR    |   ";
		rep[8] = "    ===========    ";
		rep[9] = "                   ";
	}
	
	@Override
	protected int getBaseValue() {
		return 30;
	}

	@Override
	public String toString() {
		return "Triple Bar";
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
