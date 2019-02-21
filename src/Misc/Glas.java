package Misc;

/**
 * @author Chjun-chi
 *
 *
 *
 *				10 1
 *			20 0,5	20 0,5
 *		40 0,25	20 0,5	40 0,25
 *	80 0,125   0,25					80
 *
 *
 *
 *
 *
 *
 */
public class Glas {

	public static void main(String[] args) {

		Glass[][] g = new Glass[6][6];
		g[0][0] = new Glass(10, 1, 10);
		for (int i = 1; i < g.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.println(i + " " + j);

				double ttf = 0;
				double e1 = 0;
				double e2 = 0;
				double rttf = 0;
				if (j == 0) {
					ttf = g[i - 1][j].rowTimeToFill*2;
					rttf = g[i - 1][j].rowTimeToFill+ttf;
					e1 = g[i - 1][j].tickRate/2;
					g[i][j] = new Glass(ttf, e1, rttf);
					//System.out.println(g[i][j]);
					continue;
				}
				if (j==i) {
					ttf = g[i - 1][j-1].rowTimeToFill*2;	
					rttf = g[i - 1][j-1].rowTimeToFill+ttf;
					e1 = g[i - 1][j-1].tickRate/2;		
					g[i][j] = new Glass(ttf, e1, rttf);
					//System.out.println(g[i][j]);
					continue;
				}
				
					e1 = g[i - 1][j-1].tickRate/2;
					e2 = g[i - 1][j].tickRate/2;
					ttf = (g[i - 1][j-1].timeToFill-g[i - 1][j].timeToFill);
					double glasVolume=0;
					if (ttf>0) {
						double tempE=e1/1000;
					ttf*=1000;
					for (int k = 1; k < ttf; k++) {
						if (glasVolume < 10) {
							glasVolume+=tempE;
						}else {
							ttf=k;
							break;
						}
					}
					}else if(ttf<0) {
						double tempE=e2/1000;
						ttf= Math.abs(ttf)*1000;
						for (int k = 1; k <=ttf; k++) {
							if (glasVolume < 10) {
								glasVolume+=tempE;
								
							}else {
								ttf=k;
								break;
							}
					}
					}
					double tempE1=e1/1000;
					double tempE2=e2/1000;
						while (glasVolume < 10) {
							glasVolume+=tempE1;
							glasVolume+=tempE2;
							ttf++;
						}
						ttf=ttf/1000;
					if (g[i-1][j].rowTimeToFill<g[i-1][j-1].rowTimeToFill) {
						rttf=g[i-1][j-1].rowTimeToFill;
					}else{
						rttf=g[i-1][j].rowTimeToFill;
					}
					
					rttf +=ttf;
			

				g[i][j] = new Glass(ttf, e1+e2, rttf);
				// g[i][j] = new Glass(g[i-1][j].timeToFill,
				// g[i-1][j].efficiency/2, g[i-1][j].rowTimeToFill*2);
			System.out.println(g[i][j]);

			}
		}
		 
		// recursive(g, 0, 0);
	
		System.out.println(g[2][0]);
		System.out.println(g[2][1]);
		System.out.println(g[3][0]);
		System.out.println(g[3][1]);
		System.out.println(g[3][2]);
		System.out.println(g[3][3]);
		System.out.println(g[4][0]);
		System.out.println(g[4][1]);
		System.out.println(g[4][2]);
		System.out.println(g[4][3]);
		System.out.println(g[4][4]);
		System.out.println(g[5][0]);
		System.out.println(g[5][1]);
		System.out.println(g[5][2]);
		System.out.println(g[5][3]);
		System.out.println(g[5][4]);
		System.out.println(g[5][5]);
		
		System.out.println(g[2][1]);
		System.out.println(g[4][1]);
	}

//	public static void recursive(Glass[][] g, int row, int index) {
//		if (row == 0) {
//			recursive(g, row + 1, index);
//			recursive(g, row + 1, index + 1);
//			return;
//		}
//		// if (g.length - 1 == row) {
//		// g[row][index].efficiency += g[row - 1][index].efficiency / 2;
//		// g[row][index].rowTimeToFill = g[row - 1][index].rowTimeToFill * 2;
//		// g[row][index].timeToFill = g[row][index].rowTimeToFill
//		// / g[row][index].efficiency;
//		// if (index - 1 >= 0 && index <= row) {
//		//
//		// g[row][index].efficiency += g[row - 1][index - 1].efficiency
//		// / 2;
//		// }
//		//
//		// } else {
//		System.out.println(row + " " + index);
//		if (index - 1 >= 0 && index <= row) {
//			g[row][index].efficiency = g[row - 1][index - 1].efficiency / 2;
//			g[row][index].rowTimeToFill = g[row - 1][index - 1].rowTimeToFill
//					* 2;
//			g[row][index].timeToFill = g[row][index].rowTimeToFill
//					/ g[row][index].efficiency;
//		}
//		if (row - 1 < index) {
//
//		} else {
//
//			g[row][index].efficiency += g[row - 1][index].efficiency / 2;
//			g[row][index].rowTimeToFill = g[row - 1][index].rowTimeToFill * 2;
//			g[row][index].timeToFill = g[row][index].rowTimeToFill
//					/ g[row][index].efficiency;
//
//		}
//		System.out.println(g[row][index]);
//		if (row + 1 > g.length - 1) {
//			return;
//		} else {
//			recursive(g, row + 1, index);
//			recursive(g, row + 1, index + 1);
//		}
//
//		// }
//	}
}

class Glass {
	
	@Override
	public String toString() {
		return "Glass [timeToFill=" + timeToFill + ", tickRate=" + tickRate
				+ ", rowTimeToFill=" + rowTimeToFill + "]";
	}
	public Glass(double timeToFill, double tickRate, double rowTimeToFill) {
		this.timeToFill = timeToFill;
		this.tickRate = tickRate;
		this.rowTimeToFill = rowTimeToFill;
	}
	public double timeToFill;
	public double tickRate;
	public double rowTimeToFill;
	
}