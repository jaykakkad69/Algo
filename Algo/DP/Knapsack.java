import java.util.*;
import java.io.*;

class Knapsack{
	public static void main(String[] arg) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Weights");
		String[] temp = bf.readLine().split("\\s");
		int[] w = new int[temp.length];
		int i = 0;
		for(String str : temp)
			w[i++] = Integer.parseInt(str);

		System.out.println("Enter Profits");
        temp = bf.readLine().split("\\s");
        int[] p = new int[temp.length];
        i = 0;
        for(String str : temp)
            p[i++] = Integer.parseInt(str);

		System.out.println("Enter capacity ");
		int s = Integer.parseInt(bf.readLine());
		System.out.println("  ");
		ks(w,p,s);
	}

	public static void ks(int[] w, int[] p, int s){
		int[][] dp = new int[w.length+1][s+1];
		
		for(int i=1; i<w.length+1; i++){
			for(int j=1; j<s+1; j++){
				if(w[i-1] <= j)
					dp[i][j] = Math.max(p[i-1] + dp[i-1][j-w[i-1]] , dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		//for(int[] a : dp)
		//	System.out.println(Arrays.toString(a));
		
		//Backtrack
		int i = dp.length-1, j = dp[0].length-1;
		System.out.print("Used objects(W|P): ");
		while(i > -1){
			if(i>0 && dp[i][j] != dp[i-1][j]){
				System.out.print(w[i-1] + "|" + p[i-1] + "   ");
				j -= w[i-1];
			}
			i--;
		}
		System.out.print("\n");
	}
}
