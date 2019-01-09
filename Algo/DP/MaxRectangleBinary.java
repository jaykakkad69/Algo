import java.util.*;
import java.io.*;

class MaxRectangleBinary{
	public static void main(String[] arg) throws Exception{
		int[][] mat = { 
			{0, 1, 1, 0}, 
			{1, 1, 1, 1}, 
			{1, 1, 1, 1}, 
			{1, 1, 0, 0}, 
		};
		maxRectangle(mat);
	}

	private static void maxRectangle(int[][] mat){
		int m=mat.length, n=mat[0].length;
		int result = histArea(mat[0]);

		for(int i=1; i<m; i++){
			for(int j=0; j<n; j++){
				if(mat[i][j] == 1)
					mat[i][j] += mat[i-1][j];
			}
			result = Math.max(result, histArea(mat[i]));
		}
		System.out.println(result);
	}

	private static int histArea(int[] a){
		int n = a.length, area=0, i=0;
		Stack<Integer> s = new Stack<Integer>();
		while(i<n){
			if(s.empty() || a[s.peek()] <= a[i])
				s.push(i++);
			else{
				int top = a[s.peek()];
				s.pop();
				if(!s.empty())
					area = Math.max(area, top*(i-s.peek()-1));
				else
					area = Math.max(area, top*i);
			}
		}
		while(!s.empty()){
			int top = a[s.peek()];
			s.pop();
			if(!s.empty())
				area = Math.max(area, top*(i-s.peek()-1));
			else
				area = Math.max(area, top*i);
		}
		return area;
	}
}
