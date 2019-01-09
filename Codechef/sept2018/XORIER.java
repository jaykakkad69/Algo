import java.util.*;
class XORIER{
    static long count(ArrayList<Integer> a){
	int c = 0;
	long n=a.size();
	HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
	for(int j=0; j<n; j++){
	    int p = a.get(j);
	    int x = p ^ 2;
	    int y = p ^ 0;
	    if(m.containsKey(x))
		c += m.get(x);
	    if(m.containsKey(y))
		c += m.get(y);
	    if(m.containsKey(p))
		m.put(p, m.get(p)+1);
	    else
		m.put(p,1);		    
	}
	return (((n*(n-1)) / 2)-c);
    }
    public static void main(String [] arg){
	Scanner s = new Scanner(System.in);
	int t = s.nextInt();
	while(t-- > 0){
	    long c = 0;
	    int n = s.nextInt();
	    int[] a = new int[n];
	    for(int i=0; i<n; i++)
	    a[i] = s.nextInt();
    
	    ArrayList<Integer> odd = new ArrayList<Integer>();
	    ArrayList<Integer> even = new ArrayList<Integer>();
	    for(int i=0; i<n; i++){
		if(a[i] % 2 == 0)
		    even.add(a[i]);
		else
		    odd.add(a[i]);
	    }
	    c = count(odd);
	    c += count(even);
	    System.out.println(c);
	}
    }
}
