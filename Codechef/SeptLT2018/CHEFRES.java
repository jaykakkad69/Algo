import java.util.*;

class CHEFRES{
    /*static class Interval implements Comparable<Interval>{
	public int l,r;
	public int compareTo(Interval i){
	    int cmp = l > i.l ? +1 : l < i.l ? -1 : 0;
	    return cmp;
	}
    }
    static int bs(ArrayList<Interval> ar, int l, int r, int x){
	int mid = (l+r)/2; 
	while(l<=r){
	    if(x == ar.get(mid).l)
		return mid;
	    else if(x > ar.get(mid).l)
		return bs(ar,mid+1,r,x);
	    else
		return bs(ar,l,mid-1,x);
	}
	return mid;
    }
*/
    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int t = scan.nextInt();
	while(t-->0){
	    int m = scan.nextInt();
	    int n = scan.nextInt();
	    //int[] l = new int[m];
	    //int[] r = new int[m];
	    //ArrayList<Interval> ar = new ArrayList<Interval>(); 
	    int len = ((int)Math.pow(10,9))+1;
	    int[] a = new int[len];
	    int[] d = new int[len];
	    int max = 0;
	    for(int i=0; i<m; i++){
		/*
		val.l = scan.nextInt();
		val.r = scan.nextInt();
		ar.add(val);*/
		int l = scan.nextInt();
		int r = scan.nextInt();
		d[l] += 1;
		if(r < len)
		    d[r] -= 1;
	    }
	    for(int i=1; i<n; i++){
		a[i] = a[i-1] + d[i];
		if(a[i] == 1)
		    max = i;
	    }
	    //Arrays.sort(l);
	    //Arrays.sort(r);
	    //Collections.sort(ar);
	    while(n-- > 0){
		int x = scan.nextInt();
		/*int idx = bs(ar,0,m-1,x);
		if(ar.get(idx).r > x){
		    if(ar.get(idx).l <= x)
			System.out.println(0);
		    else
			System.out.println(ar.get(idx).l - x);
		}
		else if(idx < m-1)
		    System.out.println((ar.get(idx+1).l - x));
		else
		    System.out.println(-1);
		*/
		if(a[x] == 1)
		    System.out.println(0);
		else if(x <= max){
		    int id = 0;
		    while(a[x++] != 1)
			id++;
		    System.out.println(id);
		}
		else
		    System.out.println(-1);
	    }
	}
    }
}
