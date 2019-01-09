import java.util.Scanner;

class Merge{
    static int[] merge(int[] a, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r -q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];

		for(int i=0; i<n1; i++)
			L[i] = a[p+i];
		for(int j=0; j<n2; j++)
			R[j] = a[q+j+1];

		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i=0, j=0;
		for(int k=p; k<=r; k++){
			if(L[i] <= R[j]){
				a[k] = L[i];
				i++;
			}else{
				a[k] = R[j];
				j++;
			}
		}
		return a;
	}
	public static int[] mergeSort(int[] a, int p, int r){
		//r--;
		if(p<r){
			int q = (int)Math.floor((p+r)/2.0);
			a = mergeSort(a,p,q);
			a = mergeSort(a,q+1,r);
			a = merge(a,p,q,r);
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

		int[] b = mergeSort(a,0,n-1);
		for(int i=0; i<n; i++)
			System.out.print(a[i] + " ");
		System.out.println(" ");
		for(int i=0; i<n; i++)
			System.out.print(b[i] + " ");
		System.out.println(" ");
	}
}
