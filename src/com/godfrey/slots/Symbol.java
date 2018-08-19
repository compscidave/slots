package com.godfrey.slots;

public abstract class Symbol {

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Symbol) {
			return ((Symbol) obj).toString().equals(toString());
		} else {
			return false;
		}
	}

	protected abstract int getBaseValue();
	
	public abstract String toString();

	public abstract String toString(boolean b, int i);
	
}
