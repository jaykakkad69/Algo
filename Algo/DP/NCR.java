import java.util.*;
import java.io.*;

class NCR{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter N and R respectively: ");
		String[] str = br.readLine().split("\\s");
		int n = Integer.parseInt(str[0]);
		int r = Integer.parseInt(str[1]);

		ncr(n,r);
	}

	public static void ncr(int n, int r){
		int[][] dp = new int[n+1][r+1];

		for(int i=0; i<=n; i++)
			dp[i][0] = 1;
		for(int j=0; j<=r; j++)
			dp[j][j] = 1;

		for(int i=2; i<=n; i++){
			for(int j=1; j<=r; j++){
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
		System.out.println(dp[n][r]);
	}
}
