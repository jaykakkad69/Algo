import java.util.*;
import java.io.*;

class BoolPar{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str = br.readLine().toCharArray();
		char[] op = br.readLine().toCharArray();

		boolpar(str,op);
	}

	private static void boolpar(char[] str, char[] op){
		int n = str.length, m = op.length;
		long[][] T = new long[n][n];
		long[][] F = new long[n][n];
		//int i=0; j=0;
		for(int i=0; i<n; i++){
			if(str[i] == 'T'){
				T[i][i] = 1;
				F[i][i] = 0;
			} else{
				T[i][i] = 0;
				F[i][i] = 1;
			}
		}

		for(int l=0; l<n; l++){
			for(int i=0,j=l; j<n; i++,j++){
				for(int g=0; g<l; g++){
					int k = i+g;
					if(op[k] == '|'){
						T[i][j] += (T[i][k]+F[i][k]) * (T[k+1][j]+F[k+1][j]) - (F[i][k] * F[k+1][j]);
						F[i][j] += F[i][k] * F[k+1][j];
					} else if(op[k] == '&'){
						T[i][j] += T[i][k] * T[k+1][j];
						F[i][j] += (T[i][k]+F[i][k]) * (T[k+1][j]+F[k+1][j]) - (T[i][k] * T[k+1][j]);
					} else{
						T[i][j] += (T[i][k]*F[k+1][j]) + (T[k+1][j]*F[i][k]);
						F[i][j] += (T[i][k]*T[k+1][j]) + (F[i][k]*F[k+1][j]);
					}
				}
			}
		}
		//for(long[] a:T)
		//	System.out.println(Arrays.toString(a));
		System.out.println(T[0][n-1]);
	}
}
