package Euler50to100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Euler1to50.Timer;

public class PokerHands {

	public static void main(String[] args) throws IOException {
		Timer t = new Timer();
//		BufferedReader reader = Files.newBufferedReader(
//				Paths.get("files/p054_poker.txt"), Charset.forName("UTF-8"));
		List<String> fileArr = null;
		fileArr = Files.readAllLines(Paths.get("files/p054_poker.txt"),
				Charset.forName("UTF-8"));

		String line = null;
		int h1Wins = 0;
		int idx =0;
		while (idx<fileArr.size()) {
			String[] hand = fileArr.get(idx).split(" ");
			idx++;
			Hand h1 = new Hand(new Card(hand[0]), new Card(hand[1]),
					new Card(hand[2]), new Card(hand[3]), new Card(hand[4]));
			Hand h2 = new Hand(new Card(hand[5]), new Card(hand[6]),
					new Card(hand[7]), new Card(hand[8]), new Card(hand[9]));
			if (h1.handValue > h2.handValue) {
				h1Wins++;
			} else if (h1.handValue == h2.handValue) {
				for (int i = 0; i < h1.hand.size(); i++) {
					int h1Value = h1.hand.get(i).getValue();
					int h2Value = h2.hand.get(i).getValue();
					if (h1Value > h2Value) {
						h1Wins++;
						break;
					} else if (h1Value < h2Value) {
						break;
					}
					if (i == h1.hand.size() - 1 && h1Value == h2Value) {
						System.out.println("Draw");
					}
				}
			}
		}
		System.out.println("h1 wins: " + h1Wins);
		t.time();

	}
}

class Card {
	private int value;
	private String suit, card;
	public Card(String c) {
		this.card = c;
		String v = c.substring(0, 1);
		String s = c.substring(1, 2);
		switch (v) {
			case "T" :
				this.value = 10;
				break;
			case "J" :
				this.value = 11;
				break;
			case "Q" :
				this.value = 12;
				break;
			case "K" :
				this.value = 13;
				break;
			case "A" :
				this.value = 14;
				break;
			default :
				this.value = Integer.parseInt(v);
				break;
		}
		this.suit = s;
	}
	public int getValue() {
		return value;
	}
	public String getSuit() {
		return suit;
	}
	public String getCard() {
		return card;
	}
}

class Hand {
	public ArrayList<Card> hand;
	private boolean suit, straight;
	public int handValue = 0;

	public Hand(Card card, Card card2, Card card3, Card card4, Card card5) {
		hand = new ArrayList<Card>();
		this.hand.add(card);
		this.hand.add(card2);
		this.hand.add(card3);
		this.hand.add(card4);
		this.hand.add(card5);
		this.hand.sort((Card c1, Card c2) -> c2.getValue() - c1.getValue());
		this.suit = checkSuit();
		this.straight = checkStraight();
		this.handValue = handValue();
	}
	private boolean checkSuit() {
		String suit = this.hand.get(0).getSuit();
		for (int i = 1; i < this.hand.size(); i++) {
			if (!this.hand.get(i).getSuit().contentEquals(suit)) {
				return false;
			}
		}
		return true;
	}
	public void printHand() {
		String s = "";
		for (int i = 0; i < this.hand.size(); i++) {
			s = s + this.hand.get(i).getCard() + " ";
		}
		System.out.println(s + " - " + this.handValue);
	}
	public int handValue() {
		HashMap<Integer, Integer> hv = new HashMap<>();
		LinkedList<Card> tempStack = new LinkedList<Card>();
		this.hand.forEach((Card c) -> {
			if (hv.containsKey(c.getValue())) {
				hv.put(c.getValue(), hv.get(c.getValue()) + 1);
			} else {
				hv.put(c.getValue(), 1);
			}
		});
		for (Card card : this.hand) {
			if (hv.get(card.getValue()) > 1) {
				tempStack.addFirst(card);
			}
		}
		for (Card card : this.hand) {
			if (hv.get(card.getValue()) == 1) {
				tempStack.add(card);
			}
		}
		this.hand.clear();
		while (!tempStack.isEmpty()) {
			this.hand.add(tempStack.removeFirst());
		}

		if (hv.containsValue(4)) {
			return 7;
		} else if (suit && straight) {
			return 10;
		} else if (hv.containsValue(3) && hv.containsValue(2)) {
			return 6;
		} else if (suit) {
			return 5;
		} else if (straight) {
			return 4;
		} else if (hv.containsValue(3)) {
			return 3;
		} else if (hv.size() == 3 && hv.containsValue(2)) {
			return 2;
		} else if (hv.size() == 4 && hv.containsValue(2)) {
			return 1;
		} else {
			return 0;
		}
	}
	private boolean checkStraight() {
		HashSet<Integer> straight = new HashSet<>();
		ArrayList<Integer> sArr = new ArrayList<>();
		for (Card c : this.hand) {
			int value = c.getValue();
			if (value < 6 && value == 14) {
				value = 1;
			}
			straight.add(value);
			sArr.add(value);
		}
		if (straight.size() == 5) {
			sArr.sort((Integer c1, Integer c2) -> {
				return c1 - c2;
			});
			int idx = sArr.get(0);
			for (int i = 1; i < sArr.size(); i++) {
				if (sArr.get(i) - i != idx) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
