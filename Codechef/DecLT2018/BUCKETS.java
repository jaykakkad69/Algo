import java.util.*;
import java.io.*;

class BUCKETS{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dim = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		int n=dim[0], k=dim[1];
		int[][] m = new int[n][k];
		for(int i=0; i<n; i++)
			m[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

		double[][] dp = new double[n][k];
		double sum = Arrays.stream(m[0]).sum();
		for(int i=0; i<k; i++)
			dp[0][i] = m[0][i]/sum;
		for(int i=1; i<n; i++){
			sum = 1 + Arrays.stream(m[i]).sum();
			for(int j=0; j<k; j++){
				dp[i][j] = (m[i][j]/sum)*(1-dp[i-1][j]) + (((m[i][j]+1)/sum) * dp[i-1][j]);
			}
		}
		//System.out.println(Arrays.toString(dp[n-1]));
		for(int i=0; i<k; i++)
			System.out.print((Math.round(dp[n-1][i] * 1000000.0)/1000000.0) + " ");
	}
}
