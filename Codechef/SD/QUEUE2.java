import java.io.*;
import java.util.*;
class QUEUE2 {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
		String[] s = null;
		while(t-- > 0){
			s = br.readLine().split("\\s");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);
			int l = Integer.parseInt(s[3]);

			int[] a = new int[n];
			int c=0,i=0, min=Integer.MAX_VALUE;
			s = br.readLine().split("\\s");
			for(String str : s)
				a[i] = Integer.parseInt(str);

			Arrays.sort(a);
			for(i=0; i<n; i++){
				int x = (n+1+i)*l - a[i];
				if(x < min)
					min = x;;
				if(a[i] < k)
					c++;
			}
			int x = (n+1+c)*l - k ;
			if(x < min)
				min = x;
			System.out.println(min);
		}
	}
}
