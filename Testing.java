import java.util.Random;


public class Testing {
	private static String[] ALPHA = {"01","ACGT"};
	
	public static void main(String[] args) {
		
		final int MAX_LENGTH_OF_STRING = 20;
		final int MAX_LENGTH_OF_LENGTH_STRING = 100000;
		
		Random rand = new Random();
		long start = System.currentTimeMillis();
		long stop = System.currentTimeMillis();
		long lengthTime = 0;
		long naiveTime = 0;
		long memTime = 0;
		long dynTime = 0;
		
		// Looks for LCS of randomly chosen strings of randomly chosen lengths 
		// (up to 20) for any alphabet
		while (stop-start < 100) {
			String a = "10010101";
			String b = "010110110";
//			int alphabet = rand.nextInt(ALPHA.length);
//			String usedAlpha = ALPHA[alphabet];
//			
//			int stringLen = rand.nextInt(MAX_LENGTH_OF_STRING) + 1;
//			for(int i = 0; i < stringLen; i++) {
//				a = a + usedAlpha.charAt(rand.nextInt(usedAlpha.length()));
//			}
//			stringLen = rand.nextInt(MAX_LENGTH_OF_STRING) + 1;
//			for(int i = 0; i < stringLen; i++) {
//				b = b + usedAlpha.charAt(rand.nextInt(usedAlpha.length()));
//			}
			
			//Run Length
			long startLength = System.currentTimeMillis();
			int length = Length.findLCS(a, b);
			lengthTime += System.currentTimeMillis() - startLength;
			
			//Run Naive
			long startNaive = System.currentTimeMillis();
			String naive = Naive.findLCS(a, b, a.length(), b.length());
			naiveTime += System.currentTimeMillis() - startNaive;
			
			//Run Memoization
			Memoization m = new Memoization(a.length(),b.length());
			long startMem = System.currentTimeMillis();
			String mem = m.findLCS(a, b, a.length(), b.length());
			memTime += System.currentTimeMillis() - startMem;
			
			//Run Dynamic
			long startDyn = System.currentTimeMillis();
			Dynamic d = new Dynamic(a,b);
			dynTime += System.currentTimeMillis() - startDyn;
			
//			if (length != naive.length() || naive.length() != mem.length() || mem.length() != d.lcs.length()) {
//				System.out.println("-----ERROR-----");
				System.out.println("String a = \"" + a + "\";");
				System.out.println("String b = \"" + b + "\";");
				System.out.println("Length: " + length);
				System.out.println("Naive: " + naive);
				System.out.println("Memoization: " + mem);
				System.out.println("Dynamic: " + d.lcs);
//				System.out.println("-----ERROR-----");
//			}
			
			stop = System.currentTimeMillis();
			System.out.println("Current Time Lapse: " + (stop-start));
		}
			
		System.out.println("Length of LCS time in milliseconds:" + lengthTime);
		System.out.println("Naive LCS time in milliseconds:" + naiveTime);
		System.out.println("Memoization LCS time in milliseconds:" + memTime);
		System.out.println("Dynamic LCS time in milliseconds:" + dynTime);
			
//		String a = "";
//		String b = "";
//		int alphabet = rand.nextInt(ALPHA.length);
//		String usedAlpha = ALPHA[alphabet];
//		
////		int stringLen = rand.nextInt(MAX_LENGTH_OF_LENGTH_STRING) + 1;
////		for(int i = 0; i < stringLen; i++) {
//		for(int i = 0; i < 100000; i++) {
//			a = a + usedAlpha.charAt(rand.nextInt(usedAlpha.length()));
//			b = b + usedAlpha.charAt(rand.nextInt(usedAlpha.length()));
//		}
//		
//		//Run Length
//		long startLength = System.currentTimeMillis();
//		int length = Length.findLCS(a, b);
//		lengthTime = System.currentTimeMillis() - startLength;
//		
//		System.out.println("String a = " + a.substring(0, 20) + "...");
//		System.out.println("String b = " + b.substring(0, 20) + "...");
//		System.out.println("LCS Length of " + MAX_LENGTH_OF_LENGTH_STRING + " character string: " + length);
//		System.out.println("Length of LCS time in milliseconds:" + lengthTime);
	}
	
	
}
