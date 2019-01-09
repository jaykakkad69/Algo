import java.util.*;

class CHSERVE{
    public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	int t = Integer.parseInt(s.nextLine());
	while(t-- > 0){
	    String[] x = s.nextLine().split(" ");
	    int p1 = Integer.parseInt(x[0]);
	    int p2 = Integer.parseInt(x[1]);
	    int k = Integer.parseInt(x[2]);

	    if(((p1+p2)/k) % 2 == 0)
		System.out.println("CHEF");
	    else
		System.out.println("COOK");
	}
    }
}
