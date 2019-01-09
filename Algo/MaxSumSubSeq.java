import java.util.*;

class MaxSumSubSeq{
    public static void main(String[] arg){
	int[] a = new int[10];
	Random rand = new Random();
	int l = -100, r = 100;
	for(int i=0; i<10; i++)
	    a[i] = rand.nextInt(r - l + 1) + l;
	System.out.println(Arrays.toString(a));

	sum(a);
	product(a);
    }

    static void sum(int[] a){
	int max=0, sum=0, p=0, q=0, r=0;
	for(int j=0; j<a.length; j++){
	    sum += a[j];
	    if(sum > max){
		max = sum;
		q = j;
		p = r+1;
	    }
	    if(sum < 0){
		sum = 0;
		r = j;
	    }
	}
	System.out.println("Maximum sum: " + max + " from " + (p+1) + " to " + (q+1));
    }

    static void product(int[] a){
	int l = a.length;
	int j=0, i=0, n1=-1, n2=-1, max_i=-1, max_j=-1, ans_i, ans_j;
	long  p=1, p1=1, p2=1, max = 0;
	while(j<l && i<l){
	    while(a[i] == 0)
		i++;
	    j = i;
	    while(j<l && a[j] != 0){
		p *= a[j];
		if(n1 == -1)
		    p1 *= a[j];
		if(n2 != -1)
		    p2 *= a[j];
		if(a[j] < 0){
		    if(n1 == -1){
			n1 = j;
			n2 = j;
		    }
		    else
			n2 = j;

		    if(n2 != -1)
			p2 = a[j];
		}
		j++;
	    }
	    long ans;
	    if(p > 0){
		ans = p;
		ans_i = i;
		ans_j = j-1;
	    }
	    else if(p1 > p2){
		ans = p/p1;
		ans_i = n1+1;
		ans_j = j-1;
	    }
	    else{
		ans = p/p2;
		ans_i = i;
		ans_j = n2-1;
	    }

	    if(ans > max){
		max = ans;
		max_i = ans_i;
		max_j = ans_j;
	    }
	    i = j;
    	}
	//System.out.println(n1 + "\t" + n2 + "\t" + max_i + "\t" + max_j);
	System.out.println("Maximum product: " + max + " between " + a[max_i] + " and " + a[max_j]);
    }
}
