import java.util.*;
import java.io.*;

class PathInMatrix{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] m = br.readLine().split("\\s");
		int dim = (int)Math.sqrt(m.length);
		int[][] cost = new int[dim][dim];
		int k=0;
		for(int i=0; i<dim; i++){
			for(int j=0; j<dim; j++){
				cost[i][j] = Integer.parseInt(m[k++]);
			}
		}
		//for(int[] a : cost)
		//	System.out.println(Arrays.toString(a));
		path(cost);
	}

	public static void path(int[][] cost){
		int m = cost[0].length;
		int[][] dp = new int[m][m];

		for(int j=0; j<m; j++)
			dp[0][j] = cost[0][j];

		for(int i=1; i<m; i++){
			for(int j=0; j<m; j++){
				if(j-1>=0){
					if(j+1<m)
						dp[i][j] = cost[i][j] + Math.max(dp[i-1][j],Math.max(dp[i-1][j+1], dp[i-1][j-1]));
					else
						dp[i][j] = cost[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
				}
				else
					dp[i][j] = cost[i][j] + Math.max(dp[i-1][j], dp[i-1][j+1]);
			}		
		}
		int max = Integer.MIN_VALUE;
		for(int j=0; j<m; j++)
			max = Math.max(dp[m-1][j] , max);

		System.out.println(max);
	}
}
