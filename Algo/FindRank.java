import java.util.*;

class FindRank{
    public static void main(String[] arg){
	int[] a = new int[10];
	for(int i=0; i<a.length; i++)
	    a[i] = (int)(Math.random() * 100);
	int r = (int)(Math.random() * 9);
	int n = findRank(a,0,a.length-1, r);
	System.out.println(Arrays.toString(a));
	//Arrays.sort(a);
	//System.out.println(Arrays.toString(a));
	System.out.println("Rank of " + a[r] + " is " + n);
	Arrays.sort(a);
	System.out.println(Arrays.toString(a));
    }

    static int findRank(int[] a, int left, int right, int r){
	if(left <= right){
	    //int p = right;
	    int k = partition(a,left,right);

	    if(r == right-k+1)
		return k;
	    else if(r < right-k+1)
		return findRank(a,k+1,right,r);
	    else
		return findRank(a,left,k-1,r-(right-k+1));
	}
	return -1;
    }

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
	//a[i+1] = a[i+1] ^ a[r];
	//a[r] = a[i+1] ^ a[r];
	//a[i+1] = a[i+1] ^ a[r];
	return i+1;
    }
}
