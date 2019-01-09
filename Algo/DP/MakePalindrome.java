import java.util.*;
import java.io.*;

class MakePalindrome{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter String: ");
		String s1 = br.readLine();
		String s2 = new StringBuilder(s1).reverse().toString();

		edit(s1,s2);
	}

	public static void edit(String str1, String str2){
		int m = str1.length(), n = str2.length();
		int[][] dp = new int[m+1][n+1];
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		for(int j=0; j<=n; j++)
			dp[0][j] = j;
		for(int i=0; i<=m; i++)
			dp[i][0] = i;
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(s1[i-1] == s2[j-1])
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + Math.min(dp[i-1][j] // remove
											,Math.min(dp[i][j-1] // insert
											,dp[i-1][j-1])); // replace
			}
		}
		//for(int[] a : dp)
		//	System.out.println(Arrays.toString(a));
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++)
			min = Math.min(min,dp[i][i]);
		System.out.println(min);
	}
}
