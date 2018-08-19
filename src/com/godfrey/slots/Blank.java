package com.godfrey.slots;

public class Blank extends Symbol {

	private String [] rep = new String [12];
	
	public Blank() {
		rep[0] = "                   ";
		rep[1] = "                   ";
		rep[2] = "                   ";
		rep[3] = "                   ";
		rep[4] = "                   ";
		rep[5] = "                   ";
		rep[6] = "                   ";
		rep[7] = "                   ";
		rep[8] = "                   ";
		rep[9] = "                   ";
	}
	
	@Override
	protected int getBaseValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Blank";
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
