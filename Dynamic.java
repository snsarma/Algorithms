
public class Dynamic {

	private static int[][] c;
	private static char[][] b;
	public int length;
	public String lcs;
	
	public Dynamic(String x, String y) {
		c = new int[x.length()+1][y.length()+1];
		b = new char[x.length()][y.length()];
		length = findLCSLength(x,y);
		lcs = "";
		findLCS(x,x.length(),y.length());
	}
	
	private int findLCSLength(String a1, String a2) {
		int m = a1.length();
		int n = a2.length();
		
		for(int i = 1; i <= m; i++) {
			c[i][0] = 0;
		}
		for(int i = 0; i <= n; i++) {
			c[0][i] = 0;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if (a1.charAt(i-1) == a2.charAt(j-1)) {
					c[i][j] = c[i-1][j-1] + 1;
					b[i-1][j-1] = 'd';
				} else if(c[i-1][j] >= c[i][j-1]) {
					c[i][j] = c[i-1][j];
					b[i-1][j-1] = 'u';
				} else {
					c[i][j] = c[i][j-1];
					b[i-1][j-1] = 'l';
				}
			}
		}
		
		return c[m][n];
	}
	
	private void findLCS(String X,int i,int j) {
		if (i == 0 || j == 0)
			return;
		if (b[i-1][j-1] == 'd') {
			findLCS(X,i-1,j-1);
			lcs += X.charAt(i-1);
		} else if (b[i-1][j-1] == 'u') {
			findLCS(X,i-1,j);
		} else {
			findLCS(X,i,j-1);
		}
					
	}
	
	public static void main(String[] args) {
//		BCBA
//		String a = "ABCBDAB";
//		String b = "BDCABA";
		
//		GTCGTCGGAAGCCGGCCGAA Correct
		String a = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"; //706047 , 817460
		String b = "GTCGTTCGGAATGCCGTTGCTCTGTAAA"; //706047 , 817460
		
		Dynamic d = new Dynamic(a,b);
		System.out.println(d.lcs);
		
	}
}
