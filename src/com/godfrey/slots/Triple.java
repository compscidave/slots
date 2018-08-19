package com.godfrey.slots;

public class Triple extends Symbol implements Multiplier {

	private String [] rep = new String [12];
	
	public Triple() {
		rep[0] = "                   ";
		rep[1] = "         .         ";
		rep[2] = "        ,O,        ";
		rep[3] = "       ,OOO,       ";
		rep[4] = " 'ooooo     ooooo' ";
		rep[5] = "   `OO  x3x  OO`   ";
		rep[6] = "     `O     O`     ";
		rep[7] = "     OO O'O OO     ";
		rep[8] = "    OOO'   'OOO    ";
		rep[9] = "   O'         'O   ";
	}
	
	public int getMultiplier() {
		return 3;
	}

	@Override
	protected int getBaseValue() {
		return 2;
	}

	public int getAnyMultiplierValue() {
		return 500;
	}

	@Override
	public String toString() {
		return "Triple Star!!!";
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
