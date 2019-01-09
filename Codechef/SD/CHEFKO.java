import java.util.*;
import java.io.*;

class SL implements Comparable<SL>{
	public int l,r;
	public SL(int l, int r){
		this.l = l;
		this.r = r;
	}
	public int compareTo(SL s){
		int a = this.l, b = s.l;
		int cmp = a > b ? +1 : a < b ? -1 : 0;
		return cmp;
    }
}

class SR implements Comparable<SR>{
    public int l,r;
    public SR(int l, int r){
        this.l = l;
        this.r = r;
    }
    public int compareTo(SR s){
        int a = this.l, b = s.l;
        int cmp = a > b ? +1 : a < b ? -1 : 0;
        return cmp;
    }
}

public class CHEFKO{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String[] s = null;
		while(t-- > 0){
			s = br.readLine().split("\\s");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			int size = n;
			ArrayList<SL> L = new ArrayList<SL>();
			ArrayList<SR> R = new ArrayList<SR>();

			while(n-- > 0){
				s = br.readLine().split("\\s");
				int l = Integer.parseInt(s[0]);
				int r = Integer.parseInt(s[1]);

				L.add(new SL(l,r));
				R.add(new SR(l,r));
			}

			Collections.sort(L);
			Collections.sort(R);

			int count = 0,i=0,j=0,max=0;
			ArrayList<SL> active = new ArrayList<SL>();
			while (i < size && j < size)
			{
				if (L.get(i).l <= R.get(j).r){
					count++;
					active.add(L.get(i));
					i++;
				}
				else{
					while(R.get(j).r == R.get(j+1).r){
						count--;
						active.remove(R.get(j));
						j++;
					}
					count--;
					active.remove(R.get(j));
					j++;
				}
				
				if(count == k){
					int ans = R.get(j).r = active.get(active.size()-1).l;
					if(ans > max)
						max = ans;
				}
			}
			/*while (i < size){
				count++;
				i++;
				active.add(L[i]);
				if(count == k){
					int ans = R[j].r = active.get(active.size()-1);
					if(ans > max)
						max = ans;
				}
			}*/
			while (j < size){
				while(j+1 < size && R.get(j).r == R.get(j+1).r){
						count--;
						active.remove(R.get(j));
						j++;
				}
				count--;
				active.remove(R.get(j));
				j++;
				if(count == k){
					int ans = R.get(j).r = active.get(active.size()-1).l;
					if(ans > max)
						max = ans;
				}
			}
			System.out.println(max);
		}
	}
}
