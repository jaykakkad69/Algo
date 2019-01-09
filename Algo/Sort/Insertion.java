import java.util.Scanner;

class Insertion{
    public static int[] insertion(int[] a){
	for(int i=1; i<a.length; i++){
	    int key = a[i], j=i-1;
	    while(j>=0 && key < a[j]){
		a[j+1] = a[j];
		j--;
	    }
	    a[j+1] = key;
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

	int[] b = insertion(a);
	for(int i=0; i<n; i++)
	      System.out.print(a[i] + " ");
	System.out.println(" ");
	for(int i=0; i<n; i++)
	    System.out.print(b[i] + " ");
	System.out.println(" ");
    }
}
