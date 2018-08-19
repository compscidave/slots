package com.godfrey.slots;

public class Double extends Symbol implements Multiplier {

	private String [] rep = new String [12];
	
	public Double() {
		rep[0] = "                   ";
		rep[1] = "                   ";
		rep[2] = "                   ";
		rep[3] = "                   ";
		rep[4] = "                   ";
		rep[5] = "       DOUBLE      ";
		rep[6] = "                   ";
		rep[7] = "                   ";
		rep[8] = "                   ";
		rep[9] = "                   ";
	}
	
	public int getMultiplier() {
		return 2;
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
		return "Double Star!!";
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
