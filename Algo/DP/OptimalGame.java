import java.util.*;
import java.io.*;

class OptimalGame{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the numbers: ");
		int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		
		game(a);
	}

	private static void game(int[] a){
		int n = a.length;
		int[][] dp = new int[n][n];
		int i=0,j=n-1,x=0,y=0,z=0;
		while(i<=j){
			x = (i+2<=j) ? dp[i+2][j] : 0;
			y = (i+1<=j-1) ? dp[i+1][j-1] : 0;
			z = (i<=j-2) ? dp[i][j-2] : 0;

			//dp[i][j] = Math.max((a[i] + Math.min(x,y)), a[j] + Math.min(y,z));
			int p = a[i] + Math.min(x,y);
			int q = a[j] + Math.min(y,z);
			if(p>q)
				i++;
			else
				j--;
		}

		System.out.println(dp[n-1][n-1]);
	}
}
