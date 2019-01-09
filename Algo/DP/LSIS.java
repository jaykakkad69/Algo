import java.util.*;
import java.io.*;

class LSIS{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter numbers: ");
		String[] str = br.readLine().split("\\s");
		int[] a = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		lsis(a);
	}

	public static void lsis(int[] a){
		int n = a.length;
		int[] dp = new int[n];

		for(int i=0; i<n; i++)
			dp[i] = a[i];

		int max = dp[0];
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(a[i] > a[j])
					dp[i] = Math.max(dp[i], a[i] + dp[j]);
			}
			max = Math.max(max,dp[i]);
		}
		System.out.println(max);
	}
}
