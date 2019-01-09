import java.util.*;

class BITOBYT{
    public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	int t = s.nextInt();
	while(t-- > 0){
	    int n = s.nextInt();
	    n--;
	    int q = n/26;
	    int r = n%26;
	    long b = (long)(Math.pow(2,q));

	    if(r < 2)
		System.out.println(b + " 0 0");
	    else if(r >= 2 && r < 10)
		System.out.println("0 " + b + " 0");
	    else
		System.out.println(" 0 0 " + b);
	}
    }
}
