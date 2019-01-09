import java.util.*;

class InversionPair{
    public static void main(String arg[]){
	int[] a = new int[10];
	for(int i=0; i<a.length; i++)
	    a[i] = (int)(Math.random() * 100);
	System.out.println(Arrays.toString(a));
	int[] temp = a.clone();
	int c= MMS(a,temp,0,9);
	System.out.println("No. of Inversion pairs: " + c);
    }

    static int MMS(int[] a, int[] temp, int i, int j){
	int c = 0;
	if(i<j){
	    int k = (i+j)/2;
	    c = MMS(a,temp,i,k);
	    c += MMS(a,temp,k+1,j);
	    c += MMerge(a,temp,i,k,j);
	}
	return c;
    }

    static int MMerge(int[] a, int[] temp, int left, int mid, int right){
	int i = left, j = mid+1, k = left;
	int c = 0;

	while(i <= mid && j<=right){
	    if(a[i] <= a[j])
		temp[k++] = a[i++];
	    else{
		temp[k++] = a[j++];
		c += mid - i + 1;
	    }
	}
	while(i <= mid)
	    temp[k++] = a[i++];
	while(j <= right)
	    temp[k++] = a[j++];
	
	for(i=left; i<= right; i++)
	    a[i] = temp[i];
	return c;
    }
}
