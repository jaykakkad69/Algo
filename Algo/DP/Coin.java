import java.io.*;
import java.util.*;

class Coin{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the amount");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the values of coins");
		String[] s = br.readLine().split("\\s");
		int[] c = new int[s.length];
		int i=0;
		for(String str : s)
			c[i++] = Integer.parseInt(str);

		coin(c,n);
	}

	public static void coin(int[] c, int n){
		int m = c.length;
		int[][] dp = new int[m][n+1];

		Arrays.sort(c);
		//for(int j=1; j<n+1; j++)
		//	if(i % c[0] == 0)
		//		dp[0][j] = 1;
		for(int i=0; i<m; i++){
			for(int j=1; j<n+1; j++){
				if(c[i] > j)
					dp[i][j] = dp[i-1][j];
				else if(i > 0 && dp[i-1][j] < 1+dp[i][j-c[i]])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = 1+dp[i][j-c[i]];
			}
		}
		//printdp(dp);
		backTrack(dp,c);
	}

	public static void backTrack(int[][] dp, int[] c){
		int i = dp.length-1, j = dp[0].length-1;
		System.out.print("Given amount can be made using: ");
		while(j!=0){
			if(i>0 && dp[i][j] == dp[i-1][j])
				i--;
			else{
				j -= c[i];
				System.out.print(c[i] + "  ");
			}
		}
		System.out.print("\n");
	}

	public static void printdp(int[][] a){
		for(int[] s : a)
			System.out.println(Arrays.toString(s));
	}
}
