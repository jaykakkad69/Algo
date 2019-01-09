import java.util.*;
import java.io.*;

class MaxKSquareSum{
	public static void main(String[] arg) throws Exception{
		int[][] mat = new int[][]
			{{1, 1, 1, 1, 1}, 
			{2, 2, 2, 2, 2}, 
			{3, 8, 6, 7, 3}, 
			{4, 4, 4, 4, 4}, 
			{5, 5, 5, 5, 5}, 
			}; 
		int k = 3;

		sum(mat,k);
	}

	private static void sum(int[][] m, int k){
		int n = m.length;
		if(k>n)
			return;
		//column sum for k rows
		int colSum[][] = new int[n-k+1][n];
		for(int j=0; j<n; j++){
			int sum = 0;
			for(int i=0; i<k; i++)
				sum += m[i][j];
			colSum[0][j] = sum;

			for(int i=1; i<n-k+1; i++){
				sum += m[i+k-1][j] - m[i-1][j];
				colSum[i][j] = sum;
			}
		}

		int max = Integer.MIN_VALUE, x=0,y=0;
		for(int i=0; i<n-k+1; i++){
			int sum = 0;
			for(int j=0; j<k; j++)
				sum += colSum[i][j];
			if(sum > max){
				max = sum;
				x=i;y=0;
			}

			for(int j=1; j<n-k+1; j++){
				sum += colSum[i][j+k-1] - colSum[i][j-1];
				if(sum > max){
					max = sum;
					x=i;y=j;
				}
			}
		}

		System.out.println(max + "\n" + ++x + " " + ++y);
	}
}
