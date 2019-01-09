import java.util.*;
import java.io.*;

class Egg{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Floors and Eggs: ");
		String[] s = br.readLine().split("\\s");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		egg(n,k);
	}

	public static void egg(int n, int k){
		int[][] dp = new int[k][n+1];

		for(int i=1; i<n+1; i++){
			dp[0][i] = i;
			dp[1][i] = (int)Math.ceil((-1 + Math.sqrt(1+8*i))/2.0);
		}
		int ans = 0, min = 0;
		for(int i=2; i<k; i++){
			for(int j=1; j<n+1; j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int p=1; p<k; p++)
					dp[i][j] = Math.min(dp[i][j] , Math.max(dp[i-1][j-1] , dp[i][j-p]));
			}
		}

		//for(int[] x : dp)
		//	System.out.println(Arrays.toString(x));
		int x = dp[k-1][n], temp=x, i=0;
		while(temp<=n){
			System.out.print(temp + "  ");
			temp = temp + x - i;
			i++;
		}
		System.out.print("\n");
	}
}
