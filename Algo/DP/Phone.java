import java.util.*;
import java.io.*;

class Phone{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the costs: ");
		int[] c = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		System.out.print("Enter no: ");
		int n = Integer.parseInt(br.readLine());
		phone(c,n);
	}

	private static void phone(int[] c, int n){
		int l = c.length;
		int[][] dp = new int[l][l];
		for(int[] a: dp)
			Arrays.fill(a,Integer.MAX_VALUE);
		dp[0][0] = c[0];
		
		for(int i=1; i<l; i++){
			for(int j=0; j<l; j++){
				if(j<i)
					dp[i][j] = dp[i-1][j];
				else if(j>i)
					dp[i][j] = Math.min(dp[i-1][j],dp[i][j-i] + c[i]);
				else
					dp[i][j] = Math.min(dp[i-1][j], c[i]);
				
				if(i+j>9)
					dp[i][(i+j)%10] = Math.min(dp[i][(i+j)%10], dp[i][i] + dp[i][j]);
			}
		}

		for(int[] a : dp)
			System.out.println(Arrays.toString(a));

		int sum=0;
		while(n!=0){
			sum += dp[9][n%10];
			n/=10;
		}
		System.out.println(sum);
	}
}
