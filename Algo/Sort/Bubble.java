import java.util.Scanner;

class Bubble{
    public static int[] bubble(int[] a){
	for(int i=0; i<a.length-1; i++){
	    for(int j=0; j<a.length-i-1; j++){
		if(a[j] > a[j+1]){
		    a[j] = a[j] ^ a[j+1];
		    a[j+1] = a[j] ^ a[j+1];
		    a[j] = a[j] ^ a[j+1];
		}
	    }
	}
	return a;
    }

    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter N: ");
	int n = scan.nextInt();
	int[] a = new int[n];
	System.out.println("Enter the Numbers: ");
	for(int i=0; i<n; i++)
	    a[i] = scan.nextInt();
	//for(int i=0; i<n; i++)
	//    System.out.print(a[i] + " ");

	int[] b = bubble(a);
	for(int i=0; i<n; i++)
	      System.out.print(a[i] + " ");
	System.out.println(" ");
	for(int i=0; i<n; i++)
	    System.out.print(b[i] + " ");
	System.out.println(" ");
    }
}
