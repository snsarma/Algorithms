public class Naive {
	
	public static String findLCS(String a1, String a2, int a1Len, int a2Len) {
		if (a1Len <= 0 || a2Len <= 0) {
			return "";
		}
		
		int m = a1Len - 1;
		int n = a2Len - 1;
		
		if (a1.charAt(m) == a2.charAt(n)) {
			String attempt = findLCS(a1, a2, m, n);
			attempt += a1.charAt(m);
			return attempt;
		} else {
			String temp1 = findLCS(a1,a2,m,n+1);
			String temp2 = findLCS(a1,a2,m+1,n);
			
			if (temp1.length() > temp2.length()) {
				return temp1;
			} else {
				return temp2;
			}
		}
	}
	
	public static void main(String[] args) {
//		C
//		String a = "ACC"; //0
//		String b = "GTC"; //0
		
//		GGT
//		String a = "ACCGGT"; //0
//		String b = "GTCGTT";  //0	
		
//		GGTCGGTGCCGG
		String a = "ACCGGTCGAGTGCGCGGAAG"; //~1200
		String b = "GTCGTTCGGAATGCCGTTGC"; //~1200
		
//		GTCGTCGGAAGCCGGCCGAA
//		String a = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"; //706047 , 817460
//		String b = "GTCGTTCGGAATGCCGTTGCTCTGTAAA"; //706047 , 817460
		
		System.out.println(a + "  Size:" + a.length());
		System.out.println(b + "  Size:" + a.length());
		
		long start = System.currentTimeMillis();
		String array3 = findLCS(a, b, a.length(), b.length());
		long stop = System.currentTimeMillis();
		System.out.println(array3);
		System.out.println("Length of time (milliseconds):" + (stop-start));
	}
}
