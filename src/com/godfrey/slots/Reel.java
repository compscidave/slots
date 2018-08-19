package com.godfrey.slots;
import java.util.Vector;


public class Reel {

	private Vector<Symbol> positions;
	
	public Reel() {
		init();
	}
	
	public void init() {
		positions = new Vector<Symbol>();
		for(int i = 0; i < 34; i++) {
			if(i % 2 == 0 || i == 11 || i == 23) {
				positions.add(new Blank());
			} else {
				if(i == 27) {
					positions.add(new Triple());
				}
				if(i == 1) {
					positions.add(new StarSeven());
				}
				if(i == 7) {
					positions.add(new TripleSeven());
				}
				if(i == 17) {
					positions.add(new DoubleSeven());
				}
				if(i == 5) {
					positions.add(new Seven());
				}
				if(i == 15 || i == 25) {
					positions.add(new TripleBar());
				}
				if(i == 19 || i == 29 || i == 33) {
					positions.add(new DoubleBar());
				}
				if(i == 3 || i == 13 || i == 31 || i == 9) {
					positions.add(new SingleBar());
				}
				if(i == 21) {
					positions.add(new Cherry());
				}
			}
		}
		System.out.println(positions.size());
	}
	
	public Symbol getPosition(Integer index) {
		return positions.get(index);
	}

	public int size() {
		return positions.size();
	}
	
}
