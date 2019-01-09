import java.util.*;
import java.io.*;

class AGECAL{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int[] b = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int[] c = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int yb=b[0], mb=b[1], db=b[2];
			int yc=c[0], mc=c[1], dc=c[2];

			int diff=0, sum=Arrays.stream(a).sum();
			diff = a[mb-1] - db + 1;
			for(int i=mb; i<n; i++)
				diff += a[i];
			for(int i=yb; i<yc; i++){
				diff += sum;
				if(i%4==0)
					diff++;
			}
			for(int i=0; i<mc-1; i++)
				diff += a[i];
			diff += dc;

			System.out.println(diff);
		}
	}
}
