import java.io.*;

class HMAPPY2{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			String[] temp = br.readLine().split("\\s");
			long n = Long.parseLong(temp[0]);
			long a = Long.parseLong(temp[1]);
			long b = Long.parseLong(temp[2]);
			long k = Long.parseLong(temp[3]);
			
			long ab = (a*b)/gcd(a,b);
			ab = n/ab;
			ab *= 2;
			a = n/a;
			b = n/b;

			if((a+b-ab) >= k)
				System.out.println("Win");
			else
				System.out.println("Lose");
		}
	}

	static long gcd(long a, long b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
}
