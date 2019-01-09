import java.util.Scanner;

public class Shknum{

    public static int l(int x){
	return (int) (Math.log((double)x) / Math.log(2.0));
    }

    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int t = scan.nextInt();
	while(t-- > 0){
	    int p = 0, q = 0, min = 0, m=0, x=0, y=0;
	    int a = scan.nextInt();

	    if(a == 1){
		System.out.println("2");
		continue;
	    }
	    x = l(a);
	    p = (int)Math.pow(2,x+1);
	    min = p+1-a;

	    p = p/2;
	    if(a-p == 0){
		System.out.println("1");
		continue;
	    }
	    y = l(a - p);
	    q = (int)Math.pow(2,y);
	    m = p+q;
	    if(a-m < min)
		min = a-m;

	    if(y+1 != x){
		q = (int)Math.pow(2,y+1);
		m = p+q;
		if(Math.abs(a-m) < min)
		    min = Math.abs(a-m);
	    }

	    System.out.println(min);
	}
    }
}
