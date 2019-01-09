import java.util.Scanner;

class Selection{
    public static int[] selection(int[] a){
	for(int i=0; i<a.length-1; i++){
	    int min = i;
	    for(int j=i; j<a.length; j++){
		if(a[j] < a[min]){
		    min = j;
		}
	    }
	    if(min != i){
		a[i] = a[i] ^ a[min];
		a[min] = a[i] ^ a[min];
		a[i] = a[i] ^ a[min];
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
	for(int i=0; i<n; i++)
	    System.out.print(a[i] + " ");

	int[] b = selection(a);
	for(int i=0; i<n; i++)
	      System.out.print(a[i] + " ");
	System.out.println(" ");
	for(int i=0; i<n; i++)
	    System.out.print(b[i] + " ");
	System.out.println(" ");
    }
}
