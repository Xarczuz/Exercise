package Euler1to50;
public class NumberLetterCounts {

	public static void main(String[] args) {
		NumberLetterCounts nlc = new NumberLetterCounts();
		System.out.println(nlc.nrToWord(99));
		System.out.println(nlc.nrToWord(19));
		System.out.println(nlc.nrToWord(20));
		System.out.println(nlc.nrToWord(342));
		System.out.println(nlc.nrToWord(115));
		System.out.println(nlc.nrToWord(200));
		String s = "";
		for (int i = 1; i <= 1000; i++) {
			s += nlc.nrToWord(i);
		}
		System.out.println(s.length());
	}
	public String nrToWord(int nr) {

		if (nr <= 10) {
			return oneToTen(nr);
		} else if (nr <= 19) {
			return elevenToNineteen(nr);
		} else if (nr <= 99) {
			return twentyToNinetyNine(nr);
		} else if (nr <= 999) {
			return NinetyNineToNineHundredAndNinetyNine(nr);
		} else if (nr <= 1000) {
			return "onethousand";
		}
		return "error";
	}

	public String oneToTen(int nr) {
		switch (nr) {
			case 1 :
				return "one";
			case 2 :
				return "two";
			case 3 :
				return "three";
			case 4 :
				return "four";
			case 5 :
				return "five";
			case 6 :
				return "six";
			case 7 :
				return "seven";
			case 8 :
				return "eight";
			case 9 :
				return "nine";
			case 10 :
				return "ten";
			case 0 :
				return "";
			default :
				return "Error";
		}
	}

	public String elevenToNineteen(int nr) {
		switch (nr) {
			case 11 :
				return "eleven";
			case 12 :
				return "twelve";
			case 13 :
				return "thirteen";
			case 14 :
				return "fourteen";
			case 15 :
				return "fifteen";
			case 16 :
				return "sixteen";
			case 17 :
				return "seventeen";
			case 18 :
				return "eighteen";
			case 19 :
				return "nineteen";
			default :
				return "Error";
		}
	}

	public String twentyToNinetyNine(int nr) {
		int ones = nr % 10;
		switch (nr / 10) {
			case 2 :
				return "twenty" + oneToTen(ones);
			case 3 :
				return "thirty" + oneToTen(ones);
			case 4 :
				return "forty" + oneToTen(ones);
			case 5 :
				return "fifty" + oneToTen(ones);
			case 6 :
				return "sixty" + oneToTen(ones);
			case 7 :
				return "seventy" + oneToTen(ones);
			case 8 :
				return "eighty" + oneToTen(ones);
			case 9 :
				return "ninety" + oneToTen(ones);
			default :
				return "Error";
		}

	}
	private String NinetyNineToNineHundredAndNinetyNine(int nr) {
		String tmpNr = "" + nr;
		int hundreds = nr/100;
		int tens = Integer.parseInt(tmpNr.substring(1, 3));
		if (tens > 0) {
			return oneToTen(hundreds) + "hundredand" + nrToWord(tens);
		} else {
			return oneToTen(hundreds) + "hundred";
		}
	}

}
