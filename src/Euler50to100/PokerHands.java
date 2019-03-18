package Euler50to100;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class PokerHands {

	public static void main(String[] args) {

		try (BufferedReader reader = Files.newBufferedReader(
				Paths.get("files/p054_poker.txt"), Charset.forName("UTF-8"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				String[] hand = line.split(" ");
				Hand h1, h2;
				h1 = new Hand(new Card(hand[0]), new Card(hand[1]),
						new Card(hand[2]), new Card(hand[3]),
						new Card(hand[4]));
				h2 = new Hand(new Card(hand[5]), new Card(hand[6]),
						new Card(hand[7]), new Card(hand[8]),
						new Card(hand[9]));

				
				if (h1.handValue> h2.handValue) {
					System.out.println("h1 wins");
					h1.printHand();
					h2.printHand();
					
				}else {
					System.out.println("h2 wins");
					h1.printHand();
					h2.printHand();
					
				}
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

}

class Card {
	private int value;
	private String suit;
	private String card;
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
	ArrayList<Card> hand;
	private boolean suit;
	int handValue = 0;
	public Hand(Card card, Card card2, Card card3, Card card4, Card card5) {
		hand = new ArrayList<Card>();
		this.hand.add(card);
		this.hand.add(card2);
		this.hand.add(card3);
		this.hand.add(card4);
		this.hand.add(card5);
		this.hand.sort((Card c1, Card c2) -> c1.getValue() - c2.getValue());
		this.suit = checkSuit();
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
		this.hand.forEach((Card c) -> {
			if (hv.containsKey(c.getValue())) {
				hv.put(c.getValue(), hv.get(c.getValue()) + 1);
			} else {
				hv.put(c.getValue(), 1);
			}
		});

		if (hv.containsValue(4)) {
			return 5;
		} else if (hv.containsValue(3) && hv.containsValue(2)) {
			return 4;
		} else if (hv.containsValue(3)) {
			return 3;
		}else if(hv.size()==3 && hv.containsValue(2)) {
			return 2;
		}else if(hv.size()==4 && hv.containsValue(2)){
			return 1;
		}
		return 0;
	}
}
