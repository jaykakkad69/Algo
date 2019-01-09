import java.util.*;
import java.io.*;

class CoverDistance{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the values of steps: ");
		int[] step = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		System.out.print("Enter the N: ");
		int n = Integer.parseInt(br.readLine());

		cd(step,n);
	}

	public static void cd(int[] step, int n){
		int m = step.length;
		int[][] dp = new int[m][n+1];
		
		for(int j=1; j<=n; j++)
			if(j%step[0] == 0)
				dp[0][j] = 1;
		for(int i=1; i<m; i++){
			for(int j=1; j<=n; j++){
				if(j < step[i])
					dp[i][j] = dp[i-1][j];
				else if(j == step[i])
					dp[i][j] = 1+dp[i-1][j];
				else{
					for(int k=0; k<=i; k++){
						dp[i][j] += dp[i][j-step[k]];
					}
				}
			}
		}
		//for(int[] a : dp)
		//	System.out.println(Arrays.toString(a));
		System.out.println(dp[m-1][n]);
	}
}
