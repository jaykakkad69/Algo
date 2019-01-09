import java.util.*;
import java.io.*;

class SubsetSum{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the set values: ");
		int[] set = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		System.out.print("Enter the number: ");
		int n = Integer.parseInt(br.readLine());

		subset(set,n);
	}

	public static void subset(int[] set, int n){
		int m = set.length;
		boolean[][] dp = new boolean[m][n+1];

		for(int i=0; i<m; i++)
			dp[i][0] = true;
		
		dp[0][set[0]] = true;
		for(int i=1; i<m; i++){
			for(int j=1; j<=n; j++){
				if(j<set[i])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i]];
			}
		}

		//for(boolean[] a : dp)
		//	System.out.println(Arrays.toString(a));
		if(dp[m-1][n]){
			//System.out.println("Possible");
			back(dp,set);
		}
		else
			System.out.println("Not Possible");
	}

	public static void back(boolean[][] dp, int[] set){
		int i=dp.length-1, j=dp[0].length-1;
		while(j>0){
			if(j-set[i]>=0 && dp[i][j-set[i]]){
				System.out.print(set[i] + " ");
				j = j-set[i];
			}
			i--;
		}
		System.out.print("\n");
	}
}
