import java.util.*;

class MaxMinDiff{
    public static void main(String[] arg){
	int[] a = new int[10];
	for(int i=0; i<10; i++)    
	    a[i] = (int)(Math.random() * 100);
	
	System.out.println(Arrays.toString(a));

	maxDiff(a);
	minDiff(a);
    }

    static void maxDiff(int[] a){
	int max = a[0],min = a[0];
	for(int i=0; i < 10; i++){
	    if(a[i] > max)
		max = a[i];
	    if(a[i] < min)
		min = a[i];
	}
	System.out.println("Maximum Difference is between "+max+" and "+min+" : "+ (max - min));
    }

    static void minDiff(int[] a){
	Arrays.sort(a);
	int min = Integer.MAX_VALUE, min_i = 0;
	for(int i=0; i<9; i++){
	    if(a[i+1] - a[i] < min){
		min = a[i+1] - a[i];
		min_i = i;
	    }
	}
	System.out.println("Manimum Difference is between "+a[min_i+1]+" and "+a[min_i]+" : "+ min);
    }
}
