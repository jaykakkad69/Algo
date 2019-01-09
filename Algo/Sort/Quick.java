import java.util.Scanner;

class Quick{
    static int partition(int[] a, int l, int r){
	int i = l-1;
	int x = a[r];
	for(int j=l; j<r-1; j++){
	    if(a[j] <= x){
		i++;
		if(i!=j){
		    a[i] = a[i] ^ a[j];
		    a[j] = a[i] ^ a[j];
		    a[i] = a[i] ^ a[j];
		}
	    }
	}
	a[i+1] = a[i+1] ^ a[r];
	a[r] = a[i+1] ^ a[r];
	a[i+1] = a[i+1] ^ a[r];
	return i+1;
    }
    public static int[] quickSort(int[] a, int l, int r){
	r--;
	if(l<r){
	    int p = partition(a, l, r);
	    a = quickSort(a,l,p-1);
	    a = quickSort(a,p+1,r);
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

	int[] b = quickSort(a,0,n);
	for(int i=0; i<n; i++)
	      System.out.print(a[i] + " ");
	System.out.println(" ");
	for(int i=0; i<n; i++)
	    System.out.print(b[i] + " ");
	System.out.println(" ");
    }
}
