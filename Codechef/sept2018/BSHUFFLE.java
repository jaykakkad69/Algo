import java.util.*;

public class BSHUFFLE{
    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	if(n>2){
	    int[] a = new int[n];
	    for(int i=0; i<n; i++)
		a[i] = i+1;

	    String min = "";
	    min += a[n-1] + " ";
	    for(int j=0; j<n-1; j++)
		min += a[j] + " ";

	    int m = (n+1)/2 - 1;
	    int t = a[0];
	    a[0] = a[m];
	    a[m] = t;
	
	    int t1 = a[0];
	    int t2 = a[m+1];
	    for(int j=0; j<m-1; j++)
		a[j] = a[j+1];
	    a[m-1] = t1;

	    for(int j=m+1; j<n-1; j++)
		a[j] = a[j+1];
	    a[n-1] = t2;

	    String max = "";
	    for(int j=0; j<n; j++)
		max += a[j] + " ";

	    System.out.println(max + "\n" + min);
	}
	else
	    System.out.println("1 2\n2 1");
    }
}
