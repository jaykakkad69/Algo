import java.io.*;

class GUESSRT{
	static long gcd(long a, long b){ 
		if (b == 0) 
			return a; 
		return gcd(b, a % b);  
	}

	static void ans(long p, long q){
		long x = 1000000007;
		System.out.println((p*modInverse(q))%x);
	}

	static long modInverse(long a){
		long m = 1000000007;
		return power(a, m - 2); 
	}

	static long power(long x, long y)
	{
		long m = 1000000007;
		if (y == 0)
			return 1;

		long p = power(x, y / 2) % m;
		p = (p * p) % m;

		if (y % 2 == 0)
			return p;
		else
			return (x * p) % m;
	}

	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			String[] temp = br.readLine().split("\\s");
			int n = Integer.parseInt(temp[0]);
			int k = Integer.parseInt(temp[1]);
			int m = Integer.parseInt(temp[2]);

			boolean prevm1 = true;
			long p=1, q=1;
			long p1=1, q1=1, p2=1, q2=n;
			q=n;
			m--;
			if(m%2==1){
				n += k;
				p1=q-p;
				q1=q;
				q2=n;

				p1 = p1*p2;
				q1 = q1*q2;

				long l = (q*q1)/gcd(q,q1);
				p = p * (l/q);
				p1 = p1 * (l/q1);

				p = p + p1;
				q = l;
				m--;
			}

			while(m>0){
				n -= (n/k)*k ;
				if(n==0)
					n=k;
				m--;

				p1=q-p;
				q1=q;
				q2=n;

				p1 = p1*p2;
				q1 = q1*q2;

				long l = (q*q1)/gcd(q,q1);
				p = p * (l/q);
				p1 = p1 * (l/q1);

				p = p + p1;
				q = l;

				n += k;
				m--;
			}
			ans(p,q);
		}
	}
}
