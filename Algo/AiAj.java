import java.util.*;

class AiAj{
    public static void main(String[] arg){
    	/*int[] a = new int[10];
	for(int i=0; i<a.length; i++)
	    a[i] = (int)(Math.random() * 100);
    
	int x = (int)(Math.random() * 100);*/
	int[] a = {2,3,4,5,6,7,10,12,15,16};
	int x = 11;
	getx(a,x);
	geta(a);
    }

    static void getx(int[] a, int x){
	int[] temp = a.clone();
	Arrays.sort(temp);	// O(n logn)
	int[] ans = _getx(temp,x);
	if(ans[0] != -1  && ans[1] != -1)
	    System.out.println(x+" is sum of "+ans[0]+" and "+ans[1]+" of given array");
	else
	    System.out.println(x+" is not sum of any two numbers in given array");
    }

    // O(n)
    static int[] _getx(int[] a, int x){
	int l=0, r=a.length-1;
	boolean flag = false;
	while(l<=r){
	    if(a[l] + a[r] == x){
		int[] ans = {a[l], a[r]};
		flag = true;
		return ans;
	    }
	    if(a[l] + a[r] < x)
		l++;
	    else
		r--;
	}

	int[] ans = {-1,-1};
	return ans;
    }

    static void geta(int[] a){
	int[] temp = a.clone();	
	Arrays.sort(temp);  // O(n logn)
	
	// O(n^2)
	for(int i=0; i<temp.length; i++){	//O(n)
	    int[] ans = _getx(temp,temp[i]);	//O(n)
	    if(ans[0] != -1 && ans[1] != -1){
		System.out.println(a[i]+" is sum of "+ans[0]+" and "+ans[1]+" of given array");
		return;
	    }
	}
	System.out.println("There is no element such that it is sum of two elements in given array");
    }
}
