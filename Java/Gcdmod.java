import java.util.*;
import java.math.BigInteger;
public class Gcdmod{
    static long power(long x, long y, long p)
    {
        // Initialize result
        long res = 1;     
        
        // Update x if it is more  
        // than or equal to p
        x = x % p; 
     
        while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;
     
            // y must be even now
            // y = y / 2
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }

    static long gcd(long a, long b)
    {
	if (a == 0)
	    return b;
	return gcd(b%a,a);
    }
    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int t = Integer.parseInt(scan.nextLine());
	while(t-- > 0){
	    long a = scan.nextLong();
	    long b = scan.nextLong();
	    long n = scan.nextLong();
	    //System.out.println(a + "\t" + b + "\t" + n);

	    long b1 = Math.abs(a-b);
	    if(b1 == 0){
		System.out.println((long)((power(a,n,1000000007) + power(b,n,1000000007)) % 1000000007));
		continue;
	    }
	    long a1 = power(a,n,b1);
	    long a2 = power(b,n,b1);
	    a = (a1 + a2) % b1;

	    System.out.println(gcd(b1,a) % 1000000007);
	}
	scan.close();
    }
}
