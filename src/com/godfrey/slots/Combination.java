package com.godfrey.slots;

public class Combination {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			builder = builder.append("| " + reelOnePref.toString(false, i) + " | ");
			builder = builder.append(reelTwoPref.toString(false, i) + " | ");
			builder = builder.append(reelThreePref.toString(true, i));
		}
		for(int i = 0; i < 10; i++) {
			builder = builder.append("| " + positionOne.toString(false, i) + " | ");
			builder = builder.append(positionTwo.toString(false, i) + " | ");
			builder = builder.append(positionThree.toString(true, i));
		}
		for(int i = 0; i < 10; i++) {
			builder = builder.append("| " + reelOneSuff.toString(false, i) + " | ");
			builder = builder.append(reelTwoSuff.toString(false, i) + " | ");
			builder = builder.append(reelThreeSuff.toString(true, i));
		}
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Combination) {
			Combination c = (Combination) obj;
			return c.positionOne == this.positionOne && c.positionTwo == this.positionTwo && c.positionThree == this.positionThree;
		} else {
			return false;
		}
	}

	private Symbol positionOne;
	private Symbol positionTwo;
	private Symbol positionThree;
	private Symbol reelOnePref;
	private Symbol reelOneSuff;
	private Symbol reelTwoPref;
	private Symbol reelTwoSuff;
	private Symbol reelThreePref;
	private Symbol reelThreeSuff;
	
	public Combination(Symbol positionOne, Symbol positionTwo, Symbol positionThree) {
		this.positionOne = positionOne;
		this.positionTwo = positionTwo;
		this.positionThree = positionThree;
	}
	
	public int getPayout(int bet) {
		if(positionOne instanceof Triple && positionTwo instanceof Triple && positionThree instanceof Triple) {
			if(bet == Slot.MAX_BET) {
				return Slot.MAX_PAYOUT;
			} else if (bet == 1) {
				return 1200;
			} else {
				//bet == 2
				return 2400;
			}
		}else if(positionOne instanceof Double && positionTwo instanceof Double && positionThree instanceof Double) {
			return positionOne.getBaseValue() * bet;
		}else if(positionOne instanceof Multiplier && positionTwo instanceof Multiplier && positionThree instanceof Multiplier) {
			return bet * ((Multiplier) positionOne).getAnyMultiplierValue();
		} else if(positionOne instanceof Cherry && positionTwo instanceof Cherry && positionThree instanceof Cherry) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof SingleBar && positionTwo instanceof SingleBar && positionThree instanceof SingleBar) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof DoubleBar && positionTwo instanceof DoubleBar && positionThree instanceof DoubleBar) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof TripleBar && positionTwo instanceof TripleBar && positionThree instanceof TripleBar) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof StarSeven && positionTwo instanceof StarSeven && positionThree instanceof StarSeven) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof Seven && positionTwo instanceof Seven && positionThree instanceof Seven) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof DoubleSeven && positionTwo instanceof DoubleSeven && positionThree instanceof DoubleSeven) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof TripleSeven && positionTwo instanceof TripleSeven && positionThree instanceof TripleSeven) {
			return positionOne.getBaseValue() * bet;
		} else if(positionOne instanceof AnyBar && positionTwo instanceof AnyBar && positionThree instanceof AnyBar) {
			return ((AnyBar) positionOne).getAnyBarValue() * bet;
		} else if(positionOne instanceof AnySeven && positionTwo instanceof AnySeven && positionThree instanceof AnySeven) {
			return ((AnySeven) positionOne).getAnySevenValue() * bet;
		} else if(positionOne instanceof Multiplier || positionTwo instanceof Multiplier || positionThree instanceof Multiplier) {
			if(positionOne instanceof Multiplier && !(positionTwo instanceof Multiplier || positionThree instanceof Multiplier)) {
				//x,n,n
				if(positionThree instanceof Cherry || positionTwo instanceof Cherry) {
					if(positionThree instanceof Cherry && positionTwo instanceof Cherry) {
						return ((Multiplier) positionOne).getMultiplier() * Slot.ANY_TWO_CHERRIES * bet;
					} else {
						return ((Multiplier) positionOne).getMultiplier() * Slot.SINGLE_CHERRY * bet;
					}
				} else if(positionThree instanceof SingleBar && positionTwo instanceof SingleBar) {
					return ((Multiplier) positionOne).getMultiplier() * positionThree.getBaseValue() * bet;
				}else if(positionThree instanceof DoubleBar && positionTwo instanceof DoubleBar) {
					return ((Multiplier) positionOne).getMultiplier() * positionThree.getBaseValue() * bet;
				}else if(positionThree instanceof TripleBar && positionTwo instanceof TripleBar) {
					return ((Multiplier) positionOne).getMultiplier() * positionThree.getBaseValue() * bet;
				}else if(positionThree instanceof StarSeven && positionTwo instanceof StarSeven) {
					return ((Multiplier) positionOne).getMultiplier() * positionThree.getBaseValue() * bet;
				}else if(positionThree instanceof Seven && positionTwo instanceof Seven) {
					return ((Multiplier) positionOne).getMultiplier() * positionThree.getBaseValue() * bet;
				}else if(positionTwo instanceof DoubleSeven && positionThree instanceof DoubleSeven) {
					return ((Multiplier) positionOne).getMultiplier() * positionThree.getBaseValue() * bet;
				} else if(positionTwo instanceof TripleSeven && positionThree instanceof TripleSeven) {
					return ((Multiplier) positionOne).getMultiplier() * positionThree.getBaseValue() * bet;
				} else if(positionThree instanceof AnyBar && positionTwo instanceof AnyBar) {
					return ((Multiplier) positionOne).getMultiplier() * ((AnyBar) positionThree).getAnyBarValue() * bet;
				}else if(positionThree instanceof AnySeven && positionTwo instanceof AnySeven) {
					return ((Multiplier) positionOne).getMultiplier() * ((AnySeven) positionThree).getAnySevenValue() * bet;
				}  else {
					return positionOne.getBaseValue() * bet;
				}
			} else if(!(positionOne instanceof Multiplier || positionThree instanceof Multiplier) && positionTwo instanceof Multiplier) {
				//n,x,n
				if(positionOne instanceof Cherry || positionThree instanceof Cherry) {
					if(positionOne instanceof Cherry && positionThree instanceof Cherry) {
						return ((Multiplier) positionTwo).getMultiplier() * Slot.ANY_TWO_CHERRIES * bet;
					} else {
						return ((Multiplier) positionTwo).getMultiplier() * Slot.SINGLE_CHERRY * bet;
					}
				} else if(positionOne instanceof SingleBar && positionThree instanceof SingleBar) {
					return ((Multiplier) positionTwo).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof DoubleBar && positionThree instanceof DoubleBar) {
					return ((Multiplier) positionTwo).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof TripleBar && positionThree instanceof TripleBar) {
					return ((Multiplier) positionTwo).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof StarSeven && positionThree instanceof StarSeven) {
					return ((Multiplier) positionTwo).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof Seven && positionThree instanceof Seven) {
					return ((Multiplier) positionTwo).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof DoubleSeven && positionThree instanceof DoubleSeven) {
					return ((Multiplier) positionTwo).getMultiplier() * positionOne.getBaseValue() * bet;
				} else if(positionOne instanceof TripleSeven && positionThree instanceof TripleSeven) {
					return ((Multiplier) positionTwo).getMultiplier() * positionOne.getBaseValue() * bet;
				} else if(positionOne instanceof AnyBar && positionThree instanceof AnyBar) {
					return ((Multiplier) positionTwo).getMultiplier() * ((AnyBar) positionOne).getAnyBarValue() * bet;
				}else if(positionOne instanceof AnySeven && positionThree instanceof AnySeven) {
					return ((Multiplier) positionTwo).getMultiplier() * ((AnySeven) positionOne).getAnySevenValue() * bet;
				} else {
					return positionTwo.getBaseValue() * bet;
				}
			} else if(!(positionOne instanceof Multiplier || positionTwo instanceof Multiplier) && positionThree instanceof Multiplier) {
				//n,n,x
				if(positionOne instanceof Cherry || positionTwo instanceof Cherry) {
					if(positionOne instanceof Cherry && positionTwo instanceof Cherry) {
						return ((Multiplier) positionThree).getMultiplier() * Slot.ANY_TWO_CHERRIES * bet;
					} else {
						return ((Multiplier) positionThree).getMultiplier() * Slot.SINGLE_CHERRY * bet;
					}
				} else if(positionOne instanceof SingleBar && positionTwo instanceof SingleBar) {
					return ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof DoubleBar && positionTwo instanceof DoubleBar) {
					return ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof TripleBar && positionTwo instanceof TripleBar) {
					return ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof StarSeven && positionTwo instanceof StarSeven) {
					return ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof Seven && positionTwo instanceof Seven) {
					return ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof DoubleSeven && positionTwo instanceof DoubleSeven) {
					return ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				}else if(positionOne instanceof TripleSeven && positionTwo instanceof TripleSeven) {
					return ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				}  else if(positionOne instanceof AnyBar && positionTwo instanceof AnyBar) {
					return ((Multiplier) positionThree).getMultiplier() * ((AnyBar) positionOne).getAnyBarValue() * bet;
				}else if(positionOne instanceof AnySeven && positionTwo instanceof AnySeven) {
					return ((Multiplier) positionThree).getMultiplier() * ((AnySeven) positionOne).getAnySevenValue() * bet;
				}  else {
					return positionThree.getBaseValue() * bet;
				}
			} else if(positionOne instanceof Multiplier && positionThree instanceof Multiplier) {
				//x,n,x
				if(!(positionTwo instanceof Blank)) {
					return ((Multiplier) positionOne).getMultiplier() * ((Multiplier) positionThree).getMultiplier() * positionTwo.getBaseValue() *bet;
				} else {
					return Slot.ANY_TWO_MULTIPLIERS * bet;
				}
			} else if(positionOne instanceof Multiplier && positionTwo instanceof Multiplier) {
				//x,x,n
				if(!(positionThree instanceof Blank)) {
					return ((Multiplier) positionOne).getMultiplier() * ((Multiplier) positionTwo).getMultiplier() * positionThree.getBaseValue() * bet;
				} else {
					return Slot.ANY_TWO_MULTIPLIERS * bet;
				}
			} else if(positionTwo instanceof Multiplier && positionThree instanceof Multiplier) {
				//n,x,x
				if(!(positionOne instanceof Blank)) {
					return ((Multiplier) positionTwo).getMultiplier() * ((Multiplier) positionThree).getMultiplier() * positionOne.getBaseValue() * bet;
				} else {
					return Slot.ANY_TWO_MULTIPLIERS *bet;
				}
			} else {
				return 0;
			}
		} else if(positionOne instanceof Cherry || positionTwo instanceof Cherry || positionThree instanceof Cherry) {
			if(positionOne instanceof Cherry && positionTwo instanceof Cherry) {
				return Slot.ANY_TWO_CHERRIES * bet;
			} else if(positionTwo instanceof Cherry && positionThree instanceof Cherry) {
				return Slot.ANY_TWO_CHERRIES * bet;
			} else if(positionOne instanceof Cherry && positionThree instanceof Cherry) {
				return Slot.ANY_TWO_CHERRIES * bet;
			} else {
				return Slot.SINGLE_CHERRY * bet;
			}
		} else {
			return 0;
		}
	}

	public void setPrefAndSuff(Symbol reelOnePref, Symbol reelOneSuff,
			Symbol reelTwoPref, Symbol reelTwoSuff, Symbol reelThreePref,
			Symbol reelThreeSuff) {
		this.reelOnePref = reelOnePref;
		this.reelOneSuff = reelOneSuff;
		this.reelTwoPref = reelTwoPref;
		this.reelTwoSuff = reelTwoSuff;
		this.reelThreePref = reelThreePref;
		this.reelThreeSuff = reelThreeSuff;
	}
}
