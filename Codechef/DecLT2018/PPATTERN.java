import java.util.*;
import java.io.*;

class PPATTERN{
	public static void main(String[] arg) throws Exception{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
			int n = scan.nextInt(), c=1,k;
			int[][] m = new int[n][n];
			for(int i=0; i<n; i++){
				k=0;
				for(int j=i; j>-1; j--,k++){
					m[k][j] = c++;
				}
			}
			for(int i=1; i<n; i++){
				k=i;
				for(int j=n-1; k<n; j--,k++){
					m[k][j] = c++;
				}
			}
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++)
					System.out.print(m[i][j] + " ");
				System.out.print("\n");
			}
		}
	}
}
