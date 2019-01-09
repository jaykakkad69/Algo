import java.io.*;
import java.util.*;

class MaxRectangleSum{
	public static void main(String[] arg) throws Exception{
		int[][] mat = new int[][] { 
                            {1, 2, -1, -4, -20}, 
                            {-8, -3, 4, 2, 1}, 
                            {3, 8, 10, 1, 3}, 
                            {-4, -1, 1, 7, -6} 
                            };
		maxRec(mat);
	}

	private static void maxRec(int[][] a){
		int row=a.length, col=a[0].length, maxSum=Integer.MIN_VALUE;
		int[] current;
		int l=0, r=0, b=0,t=0;

		for(int leftCol = 0; leftCol<col; leftCol++){
			int[] temp = new int[row];
			for(int rightCol = leftCol; rightCol<col; rightCol++){
				for(int i=0; i<row; i++)
					temp[i] += a[i][rightCol];
				current = kadane(temp);
				if(current[0] > maxSum){
					maxSum = current[0];
					l = leftCol;
					r = rightCol;
					t = current[1];
					b = current[2];
				}
			}
		}
		System.out.println("Max Sum: " + maxSum + "\n("+t+","+l+")\t("+b+","+r+")");
	}

	private static int[] kadane(int[] a){
		int n = a.length;
		int[] res = new int[]{Integer.MIN_VALUE,0,-1};//max,start,end
		int max_here = 0, s=0;
		for(int i=0; i<n; i++){
			max_here += a[i];
			if(max_here < 0){
				max_here = 0;
				s = i+1;
			}
			else if(max_here > res[0]){
				res[0] = max_here;
				res[1] = s;
				res[2] = i;
			}
		}
		if(res[2] == -1)
			res[0] = 0;
		return res;
	}
}
