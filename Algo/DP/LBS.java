import java.util.*;
import java.io.*;

class LBS{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter numbers: ");
		String[] str = br.readLine().split("\\s");
		int[] a = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

		lbs(a);
	}

	public static void lbs(int[] a){
		int n = a.length;
		int[] ddp = new int[n];
		int[] idp = new int[n];

		Arrays.fill(ddp,1);
		Arrays.fill(idp,1);

		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(a[i] > a[j])
					idp[i] = Math.max(idp[i], 1+idp[j]);
			}
		}

		for(int i=n-2; i>=0; i--){
			for(int j=n-1; j>i; j--){
				if(a[i] > a[j])
					ddp[i] = Math.max(ddp[i], 1+ddp[j]);
			}
		}
		int max = Integer.MIN_VALUE;
		for(int k=0; k<n; k++)
			max = Math.max(max, ddp[k] + idp[k] - 1);

		System.out.println(max);
	}
}
