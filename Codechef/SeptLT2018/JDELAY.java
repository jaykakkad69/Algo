import java.util.*;

class JDELAY{
    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int t = Integer.parseInt(scan.nextLine());
	while(t-- > 0){
	    int c=0;
	    int m = Integer.parseInt(scan.nextLine());
	    while(m-- > 0){
		String tmp = scan.nextLine();
		String[] a = tmp.split(" ");
		if(Integer.parseInt(a[1]) - Integer.parseInt(a[0]) > 5)
		    c++;
	    }
	    System.out.println(c);
	}
    }
}
