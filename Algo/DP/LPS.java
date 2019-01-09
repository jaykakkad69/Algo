import java.util.*;
import java.io.*;

class LPS{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the String: ");
		String str = br.readLine();
		lps(str);
	}

	public static void lps(String s){
		int n = s.length();
		int[][] dp = new int[n][n];

		for(int i=0; i<n; i++)
			dp[i][i] = 1;

		int j=0;
		for(int l=2; l<=n; l++){
			for(int i=0; i<n-l+1; i++){
				j = l+i-1;
				if(s.charAt(i) == s.charAt(j))
					dp[i][j] = 2 + dp[i+1][j-1];
				else
					dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
			}
		}

		for(int[] a : dp)
			System.out.println(Arrays.toString(a));
		System.out.println(dp[0][n-1]);
	}
}
