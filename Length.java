import java.util.Random;




public class Length {
	
	public static int findLCS(String a1, String a2) {
		// Use shorter string for length of array to save space
		if (a2.length() > a1.length()) {
			String temp = a1;
			a1 = a2;
			a2 = temp;
		}
		
		int m = a1.length(); //12
		int n = a2.length(); //1
		int[][] c = new int[2][m]; //c[2][12]
		
		for(int i = 0; i < m; i++) {
			c[0][i] = 0;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (j == 0) {
					if (a1.charAt(j) == a2.charAt(i)) {
						c[1][j] = 1;
					} else {
						c[1][0] = c[0][0];
					}
				} else {
					if (a1.charAt(j) == a2.charAt(i)) {
						c[1][j] = c[0][j-1] + 1;
					} else {
						c[1][j] = Math.max(c[0][j], c[1][j-1]);
					}
				}
				if (j >= 2) {
					c[0][j-2] = c[1][j-2];
				}
				if (j == m-1 && j-1 >= 0) {
					c[0][j-1] = c[1][j-1];
					c[0][j] = c[1][j];
				}	
			}
		}
		
		// Print out the last line of the table
//		System.out.print("  ");
//		for (int i = 0; i < m; i++) {
//			System.out.print(a1.charAt(i) + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			System.out.print(a2.charAt(i) + " ");
//			for (int j = 0; j < m; j++) {
//				System.out.print(c[1][j] + " ");
//			}
//			System.out.println();
//		}
		
		return c[1][m-1];
	}
	
	public static void main(String[] args) {
		//GC (2)
//		String a = "GACCA";
//		String b = "TTTGC";
		
		//111110 (6)
//		String a = "100111110";
//		String b = "111000110";
		
		//CTATGTGCTTG (11)
//		String a = "AGTCCCGTATGGTGCTTGT";
//		String b = "CTTCATGATAGCATCATAG";
		
//		GTCGTCGGAAGCCGGCCGAA (20)
//		String a = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"; //706047 , 817460
//		String b = "GTCGTTCGGAATGCCGTTGCTCTGTAAA"; //706047 , 817460
		
//		//X (1)
//		String a = "CAUWZXVC";
//		String b = "X";
		
		Random rand = new Random();
		String[] ALPHA = {"01","ACGT"};
		String a = "";
		String b = "";
		int alphabet = rand.nextInt(ALPHA.length);
		String usedAlpha = ALPHA[alphabet];
		
		int stringLen = 33000;
		for(int i = 0; i < stringLen; i++) {
			a = a + usedAlpha.charAt(rand.nextInt(usedAlpha.length()));
			b = b + usedAlpha.charAt(rand.nextInt(usedAlpha.length()));
		}
		
		//System.out.println(a);
		//System.out.println(b);
		int l = 0;
		long start = System.currentTimeMillis();
		l = findLCS(a,b);
		long end = System.currentTimeMillis() - start;
		
		System.out.println(l);
		System.out.println(end);
	
	}
}
