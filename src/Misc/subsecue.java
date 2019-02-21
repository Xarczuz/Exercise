package Misc;

public class subsecue {

	public static void main(String[] args) {
//		String s1 = "ABAZDC";
//		String s1 = "ABAZDC";
//		String s1 = "AGGTAB";
//		String s2 = "GXTXAYB";
//		String s1 = "ABBA";
//		String s2 = "ABACABA";
		String s1 = "";
		String s2 = "ABACABA";
		
		String result = "";

		for (int k = 0; k < s1.length(); k++) {
			String tempR = "";
			int j = 0;
			int jtemp=0;
			for (int i = k; i < s1.length(); i++) {
				for (; j < s2.length(); j++) {
					String temp1 = s1.substring(i, i + 1);
					String temp2 = s2.substring(j, j + 1);

					if (temp1.equals(temp2)) {
						tempR += temp2;	
						j++;
						jtemp=j;
						break;
					}
				}
				j=jtemp;
			}
			
			if (tempR.length() > result.length()) {
				result = tempR;
			}
		}
		
		System.out.println(result);
	}

}
