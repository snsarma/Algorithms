public class Memoization {
	private String[][] L;
	
	Memoization(int a1Len, int a2Len) {
		L = new String[a1Len+1][a2Len+1];
	}
	
	public String findLCS(String a1, String a2, int a1Len, int a2Len) {
		if (a1Len <= 0 || a2Len <= 0) {
			return "";
		}
		
		if (L[a1Len][a2Len] != null) {
			return L[a1Len][a2Len];
		}
		
		int m = a1Len - 1;
		int n = a2Len - 1;
		
		
		if (a1.charAt(m) == a2.charAt(n)) {
			String attempt = findLCS(a1, a2, m, n);
			attempt += a1.charAt(m);
			L[a1Len][a2Len] = attempt;
			
			return attempt;
		} else {
			String temp1 = findLCS(a1,a2,m,n+1);
			String temp2 = findLCS(a1,a2,m+1,n);
			
			if (temp1.length() > temp2.length()) {
				L[a1Len][a2Len] = temp1;
				return temp1;
			} else {
				L[a1Len][a2Len] = temp2;
				return temp2;
			}
		}
	}
	
	public static void main(String[] args) {
		// ABAB CORRECT
//		String a = "abab";
//		String b = "ababc";
		
		// GGT CORRECT
//		String a = "ACCGGT"; //0
//		String b = "GTCGTT"; //0
		
		// GGTCGGTGCCGG CORRECT
//		String a = "ACCGGTCGAGTGCGCGGAAG"; //~1200
//		String b = "GTCGTTCGGAATGCCGTTGC"; //~1200
		
		// GTCGTCGGAAGCCGGCCGAA CORRECT
		String a = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"; //0
		String b = "GTCGTTCGGAATGCCGTTGCTCTGTAAA"; //0
		
		System.out.println(a + "  Size:" + a.length());
		System.out.println(b + "  Size:" + b.length());
		Memoization m = new Memoization(a.length(),b.length());
		long start = System.currentTimeMillis();
		String c = m.findLCS(a, b, a.length(), b.length());
		long stop = System.currentTimeMillis();
		System.out.println(c);
		System.out.println("Length of LCS:" + c.length());
		System.out.println("Length of time (milliseconds):" + (stop-start));
	}
}
