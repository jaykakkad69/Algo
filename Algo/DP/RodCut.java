import java.io.*;
import java.util.*;

class RodCut{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Profits: ");
		String[] str = br.readLine().split("\\s");
		int[] a = new int[str.length];
		int i=0;
		for(String s : str)
			a[i++] = Integer.parseInt(s);
		rod(a);
	}

	public static void rod(int[] a){
		int n = a.length, ans=0;
		int[] dp = new int[n+1];
		int[] bt = new int[n+1];

		for(int l=1; l<n+1; l++){
			int max = Integer.MIN_VALUE;
			for(int i=0; i<l; i++){
				ans = a[i] + dp[l-i-1];
				if(max < ans){
					max = ans;
					bt[l] = i;
				}
			}
			dp[l] = max;
			//System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[n] + "\n" + Arrays.toString(bt));
		/*int temp = bt[n];
		while(temp!=0){
			System.out.print(temp + "  ");
			temp = n+1-temp;
		}
		System.out.print("\n");*/
	}
}
