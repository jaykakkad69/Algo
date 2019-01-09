import java.util.Scanner;

class CHEFADV{
    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int t = scan.nextInt();
	while(t-- > 0){
	    int n = scan.nextInt() - 1;
	    int m = scan.nextInt() - 1;
	    int x = scan.nextInt();
	    int y = scan.nextInt();

	    if(n%x != 0 || m%y != 0){
		if(n!=0 && m!=0){
		    if((n-1)%x == 0 && (m-1)%y == 0)
			System.out.println("Chefirnemo");
		    else
			System.out.println("Pofik");
		}
		else
		    System.out.println("Pofik");
	    }
	    else
		System.out.println("Chefirnemo");
	}
    }
}
