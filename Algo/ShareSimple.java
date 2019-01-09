import java.util.*;

class ShareSimple{
    public static void main(String[] arg){
	int[] a = new int[10];
	for(int i=0; i<10; i++)
	    a[i] = (int)(Math.random() * 100);
	
	System.out.println(Arrays.toString(a));
	share_simple(a);
	share_l(a,(int)(Math.random() * 9));
    }

    static void share_simple(int[] a){
	int i = 0, max = Integer.MIN_VALUE, min = a[0], max_i = 0;
	for(int j = i+1; j<10; j++){
	    if(a[j] - a[i] > max){
		max = a[j] - a[i];
		max_i = j;
	    }
	    if(a[j] < min){
		min = a[j];
		i = j;
	    }
	}
	System.out.println("But at: " + a[i] + "\tsell at: " + a[max_i] + "\tProfit: " + max);
    }

    static void share_l(int[] a, int l){
    int i = 0, max = Integer.MIN_VALUE, min = a[0], max_i = l, min_i = 0;
	for(int j = l; j<10; j++){
            if(a[j] - a[i] > max){
                max = a[j] - a[i];
		max_i = j;
		min_i = i;
	    }
            if(a[j+1-l] < min){
                min = a[j+1-l];
                i = j+1-l;
            }
        }
	System.out.println("But at: " + a[min_i] + "\tsell at(after " + l + " days) " + a[max_i] + "\tProfit: " + max);
    }
}
