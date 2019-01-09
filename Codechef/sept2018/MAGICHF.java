import java.util.Scanner;

class MAGICHF{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int t = scan.nextInt();

	while(t-- > 0){
	    int n = scan.nextInt();
	    int x = scan.nextInt();
	    int s = scan.nextInt();
	    while(s-- > 0){
		int a = scan.nextInt();
		int b = scan.nextInt();
		if(a == x){
		    x = b;
		    continue;
		}
		if(b == x){
		    x = a;
		    continue;
		}
	    }
	    System.out.println(x);
	}   
    }
}
