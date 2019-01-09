import java.util.*;
import java.io.*;

class Shops{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Profits of A: ");
		int[] A = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

		System.out.print("Profits of B: ");
		int[] B = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		
		System.out.print("Enter the Cost: ");
		int c = Integer.parseInt(br.readLine());

		shop(A,B,c);
	}

	private static void shop(int[] A, int[] B, int c){
		int n = A.length;
		int[][] dp = new int[n][2];
		dp[0][0] = A[0];
		dp[0][1] = B[0];
		for(int i=1; i<n; i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-50) + A[i];
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-50) + B[i];
		}
		for(int[] a: dp)
			System.out.println(Arrays.toString(a));

		int i=n-1,j=1;
		String str = "";
		if(dp[i][0] > dp[i][1])
			j=0;
		while(i>0){
			if(j==1){
				str = "B" + str;
				if(dp[i][j] != dp[i-1][j] + B[i])
					j = j&1;
			}
			else{
				str = "A" + str;
				if(dp[i][j] != dp[i-1][j] + A[i])
					j = j&1;
			}
			i--;
		}
		if(j==1)
			str = "B" + str;
		else
			str = "A" + str;
		System.out.println(str);
	}
}
