//import java.util.Scanner;
public class FibDp{
    static int fibDp(int n){
	int[] a = new int[n+1];
	a[0] = 0;
	a[1] = 1;
	for(int i=2; i<=n; i++)
	    a[i] = (a[i-1] + a[i-2])%100;
	return a[n];
    }
    public static void main(String[] arg){
	System.out.println(fibDp(Integer.parseInt(arg[0])));
    }
}
