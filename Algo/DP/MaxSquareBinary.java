import java.util.*;

class MaxSquareBinary{
	public static void main(String[] arg) throws Exception{
		int M[][] = {{0, 1, 1, 0, 1},  
                    {1, 1, 0, 1, 0},  
                    {0, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 1}, 
                    {0, 0, 0, 0, 0}}; 
		
		maxSquare(M);
	}

	private static void maxSquare(int[][] m){
		int p=m.length, q=m[0].length, max=0, x=0, y=0;
		for(int i=1; i<p; i++){
			for(int j=1; j<q; j++){
				if(m[i][j] == 1){
					m[i][j] = 1 + Math.min(m[i-1][j-1], Math.min(m[i-1][j], m[i][j-1]));
					if(m[i][j] > max){
						max = m[i][j];
						x=i; y=j;
					}
				}
			}
		}
		System.out.println("Top left corner of Max Square is: ("+(x+2-max)+","+(y+2-max)+")");
		System.out.println("Dimention: " + max + "x" + max);
	}
}
