import java.io.*;
import java.util.*;

class DEPCHEF{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			int max = -1;
			int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int[] d = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			
			if(a[n-1]+a[1] < d[0])
				max = d[0];
			for(int i=1; i<n-1; i++){
				if(a[i-1]+a[i+1] < d[i])
					max = Math.max(max, d[i]);
			}
			if(a[n-2]+a[0] < d[n-1])
				max = Math.max(max, d[n-1]);

			System.out.println(max);
		}
	}
}
