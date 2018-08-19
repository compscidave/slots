package com.godfrey.slots;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;


public class Slot {

	private static final int MAX_SPINS = 2000000;
	public static final int MAX_BET = 3;
	public static final int MAX_PAYOUT = 5000;
	public static final int ANY_TWO_MULTIPLIERS = 8;
	public static final int ANY_TWO_CHERRIES = 5;
	public static final int SINGLE_CHERRY = 1;
	private static int wager = 3;
	private Reel reelOne;
	private ReelTwo reelTwo;
	private ReelThree reelThree;
	private static Integer posOne;
	private static Integer posTwo;
	private static Integer posThree;
	private static Symbol symOne;
	private static Symbol symTwo;
	private static Symbol symThree;
	private static int bank = 100;
	private static int payout;
	private static int wins = 0;
	private static int spins = 0;
	private static int maxPaidOut = 0;
	private static List<Symbol> maxComb = new ArrayList<Symbol>();
	private static Set<Combination> combSet = new HashSet<Combination>();
	private static Map<Integer,Integer> payoutCounter = new TreeMap<Integer, Integer>();
	private static Map<Integer,Integer> randCounter = new TreeMap<Integer,Integer>();
	private static double avgWager = 0d;
	private static int totalWager = 0;
	private static int previousWager = -1;
	
	public static void main(String [] argsv) throws IOException, InterruptedException {
		Slot slot = new Slot();
		int losingStreak = 0;
		int maxLosingStreak = 0;
		int losingStreakCounter = 0;
		int losingStreakSum = 0;
		for(int i = 0; i < 20; i++) {
			while(spins < MAX_SPINS && bank > 0) {
				System.out.print("Enter wager (1-3): ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String wagerString = reader.readLine();
				try {
					wager = Integer.valueOf(wagerString);
				} catch (NumberFormatException nfe) {
					if(wagerString.isEmpty() || wagerString.contains("\n") && previousWager != -1) {
						wager = previousWager ;
					} else {
						System.out.println("Invalid Wager: " + wagerString + ". Please enter 1, 2 or 3.");
						continue;
					}
				}
				
				if(wager > 0 && wager <= bank) {
					Combination comb = slot.spin(wager);
					bank -= wager;
					bank += payout;
					previousWager = wager;
					totalWager += wager;
					if(payout > 0) {
						wins++;
						losingStreakSum += losingStreak;
						losingStreak = 0;
						wager = 1;
					} else {
						losingStreak++;
						if(maxLosingStreak < losingStreak) {
							maxLosingStreak = losingStreak;
						}
						if(losingStreak == 1) {
							losingStreakCounter++;
						}
						//System.out.println("average losing streak: " + (double) losingStreakSum / (double) losingStreakCounter);
						if(losingStreak > 5) {
							++wager;
						}
					}
					
					//check for uniform distribution over all reel positions
	/*				if(randCounter.containsKey(posOne)) {
						randCounter.put(posOne, randCounter.get(posOne) + 1);
					} else {
						randCounter.put(posOne, 1);
					}
					if(randCounter.containsKey(posTwo)) {
						randCounter.put(posTwo, randCounter.get(posTwo) + 1);
					} else {
						randCounter.put(posTwo, 1);
					}
	*/				if(randCounter.containsKey(posThree)) {
						randCounter.put(posThree, randCounter.get(posThree) + 1);
					} else {
						randCounter.put(posThree, 1);
					}
					
					spins++;
					System.out.print(comb.toString());
					if(payout > 0) {
						System.out.println("Win: " + payout);
					}
					System.out.println("Bank: " + bank);
					
					if(payoutCounter.containsKey(payout)) {
						payoutCounter.put(payout, payoutCounter.get(payout)+1);
					} else {
						payoutCounter.put(payout, 1);
					}
	//				Thread.sleep(2000);
				} else {
					System.out.println();
					System.out.println("Invalid wager, must be 1, 2 or 3 and cannot be more than what's in your bank.");
					continue;
				}
			}
			if(bank == 0) {
				System.out.print("Please insert more money: ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String wagerString = reader.readLine();
				try {
					bank = Integer.valueOf(wagerString);
				} catch (NumberFormatException nfe) {
					if(wagerString.isEmpty() || wagerString.contains("\n") || bank < 0) {
						bank = 0;
					} else {
						System.out.println("Invalid: " + wagerString + ". Please insert more.");
					}
					continue;
				}
			} else {
				if(wins > 0) {
					System.out.println(wins + " wins and " + spins + " spins");
					System.out.println("spins per win = " + spins / wins);
					//System.out.println(maxComb.get(0) + " <> " + maxComb.get(1) + " <> " + maxComb.get(2));
				} else {
					System.out.println("No wins");
				}
				System.out.println(combSet.size());
				for(Entry<Integer,Integer> entry : randCounter.entrySet()) {
					//System.out.println(comb.toString());
					System.out.println("pos: " + entry.getKey() + " count:" + entry.getValue());
				}
				Integer totalPayout = 0;
				for(Entry<Integer,Integer> entry : payoutCounter.entrySet()) {
					System.out.println("Payout: " + entry.getKey() + " count: " + entry.getValue());
					totalPayout += entry.getKey() * entry.getValue();
				}
				System.out.println("Total Payout: " + totalPayout);
				System.out.println("Payout Percentage: " + ((double) totalPayout) / ((double) totalWager));
				System.out.println("max losing streak: " + maxLosingStreak);
				System.out.println("losing streaks: " + losingStreakCounter);
				System.out.println("average losing streak: " + (double) losingStreakSum / (double) losingStreakCounter);
				spins = 0;
				wager = 1;
				losingStreak = 0;
				totalWager = 0;
				payoutCounter = new TreeMap<Integer,Integer>();
			}
		}
	}
	
	public Slot() {
		reelOne = new Reel();
		reelTwo = new ReelTwo();
		reelThree = new ReelThree();
	}
	
	public Combination spin(int bet) {
		double randOne = Math.random();
		double randTwo = Math.random();
		double randThree = Math.random();
		posOne = new Integer((int) Math.round((randOne * reelOne.size()) - 0.5));
		posTwo = new Integer((int) Math.round((randTwo * reelTwo.size()) - 0.5));
		posThree = new Integer((int) Math.round((randThree * reelThree.size()) - 0.5));

		//System.out.println(posOne + " " + posTwo + " " + posThree);
		symOne = reelOne.getPosition(posOne);
		Symbol reelOnePref = reelOne.getPosition((posOne + 1) % reelOne.size());
		Symbol reelOneSuff;
		if(posOne == 0) { 
			reelOneSuff = reelOne.getPosition(reelOne.size() - 1);
		} else {
			reelOneSuff = reelOne.getPosition((posOne - 1) % reelOne.size());
		}
		symTwo = reelTwo.getPosition(posTwo);
		Symbol reelTwoPref = reelTwo.getPosition((posTwo + 1) % reelTwo.size());
		Symbol reelTwoSuff;
		if(posTwo == 0) { 
			reelTwoSuff = reelTwo.getPosition(reelTwo.size() - 1);
		} else {
			reelTwoSuff = reelTwo.getPosition((posTwo - 1) % reelTwo.size());
		}
		symThree = reelThree.getPosition(posThree);
		Symbol reelThreePref = reelThree.getPosition((posThree + 1) % reelThree.size());
		Symbol reelThreeSuff;
		if(posThree == 0) { 
			reelThreeSuff = reelThree.getPosition(reelThree.size() - 1);
		} else {
			reelThreeSuff = reelThree.getPosition((posThree - 1) % reelThree.size());
		}
		
		Combination comb = new Combination(symOne,symTwo,symThree);
		comb.setPrefAndSuff(reelOnePref, reelOneSuff, reelTwoPref, reelTwoSuff, reelThreePref, reelThreeSuff);
		payout = comb.getPayout(bet);
		return comb;
	}
	
}
