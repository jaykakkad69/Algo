import java.util.*;
import java.io.*;

class XYPIZQ{
	public static int gcd(int k, int m){
		while (k !=0  &&  m != 0) {
			if (k > m)
			{ k = k % m; }
			else
			{ m = m % k; }
		}
		// At this point, GCD(K,M) = GCD(k,m) = max(k,m)
		return Math.max(k,m);
	}

	public static void main(String[] arrg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int N=(a[0]-1)*2, t=a[1], x=a[2], y=a[3], z=a[4];
			int m;
			if(t==1){
				if(x<y){
					if(y<z)
						m = N - z;
					else
						m = z;
				} else {
					if(y<z)
						m = z;
					else
						m = N - z;
				}
			}
			else if(t==2 || t == 4)
				m = N - (2*y);
			else{
				if(x<y){
					if(y<z)
						m = N - x;
					else
						m = z;
				} else {
					if(y<z)
						m = z;
					else
						m = N - x;
				}
			}

			int g = gcd(m,N);
			if(g!=1){
				m /= g;
				N /= g;
			}

			System.out.println(++m + " " + ++N);
		}
	}
}
