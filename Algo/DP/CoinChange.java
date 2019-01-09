import java.util.*;
import java.io.*;

class CoinChange{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Values of coins: ");
		String[] str = br.readLine().split("\\s");
		int[] coin = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

		System.out.print("Enter Value: ");
		int n = Integer.parseInt(br.readLine());
		//int[] coin = new int[str.length];
		//int i=0;
		//for(String s : str)
		//	coin[i] = Integer.parseInt(str);
		coinChange(coin,n);
	}

	public static void coinChange(int[] coin, int n){
		Arrays.sort(coin);
		int m = coin.length;
		int[][] dp = new int[m][n+1];

		for(int j=1; j<=n; j++){
			if(j>coin[0])
				dp[0][j] = dp[0][j-coin[0]];
			if(j-coin[0] == 0)
				dp[0][j] = 1;

		}
		for(int i=1; i<m; i++){
			for(int j=1; j<=n; j++){
				if(j>coin[i])
					dp[i][j] = dp[i][j-coin[i]] + dp[i-1][j];
				else if(j<coin[i])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = 1 + dp[i-1][j];
			}
		}
		System.out.println(dp[m-1][n]);
	}
}
