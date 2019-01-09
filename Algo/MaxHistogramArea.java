import java.util.*;

class MaxHistogramArea{
	public static void main(String[] arg){
		int[] a = new int[10];
		for(int i=0; i<a.length; i++)
			a[i] = (int)(Math.random() * 20);

		System.out.println(Arrays.toString(a));
		int[] rmin = RMin(a);
		int[] lmin = LMin(a);
		int max = 0, maxl = -1, maxr = a.length;
		for(int i=0; i<a.length; i++){
			int area = a[i] * (rmin[i] - lmin[i] - 1);
			if(area > max){
				max = area;
				maxl = lmin[i] + 1;
				maxr = rmin[i] - 1;
			}
		}
		System.out.println("Max area is between " + a[maxl]
				+ " and " + a[maxr] + " : " + max);
	}

	static int[] RMin(int[] a){
		int[] min = new int[a.length];
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		int i=-1;
		for(int j=1; j<a.length; j++){
			while(!s.empty()){
				i = s.peek();
				if(a[j] < a[i]){
					min[i] = j;
					s.pop();
				}
				else
					break;
			}
			s.push(j);
		}
		while(!s.empty()){
			i = s.peek();
			min[i] = a.length;;
			s.pop();
		}
		return min;
	}

	static int[] LMin(int[] a){
		int n = a.length;
		int[] min = new int[n];
		Stack<Integer> s = new Stack<Integer>();
		s.push(n-1);
		int i=-1;
		for(int j=n-2; j>=0; j--){
			i = s.peek();
			while(!s.empty()){
				i = s.peek();
				if(a[j] < a[i]){
					min[i] = j;
					s.pop();
				}
				else
					break;
			}
			s.push(j);
		}
		while(!s.empty()){
			i = s.peek();
			min[i] = -1;
			s.pop();
		}
		return min;
	}
}
