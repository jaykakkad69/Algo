import java.util.*;
import java.io.*;

class Movers{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter no. of Movers: ");
		int m = Integer.parseInt(br.readLine());
		System.out.print("Enter weights: ");
		int[] w = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

		mnp(m,w);
	}

	private static void mnp(int m, int[] w){
		int p = w.length;
		int[][] dp = new int[m+1][p+1];
		for(int[] a: dp)
			Arrays.fill(a,-1);
		int max = rec(0,0,m,p,w,dp);
		System.out.println(max);
	}

	private static int rec(int mover, int pack, int m, int p, int[] w, int[][] dp){
		if(mover == m){
			if(pack != p)
				return Integer.MAX_VALUE;
			return 0;
		}

		if(pack == p)
			return 0;

		if(dp[mover][pack] != -1)
			return dp[mover][pack];

		int sum=0, ans=Integer.MAX_VALUE;
	
		for(int i=pack; i<p; i++){
			sum += w[i];
			ans = Math.min(ans, Math.max(sum,rec(mover+1,i+1,m,p,w,dp)));
		}

		dp[mover][pack] = ans;
		return ans;
	}
}
