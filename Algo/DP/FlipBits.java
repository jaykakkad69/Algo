import java.util.*;
import java.io.*;

class FlipBits{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

		flip(a);
	}

	private static void flip(int[] a){
		int max_so_far=0, max=0, count=0;
		for(int i=0; i<a.length; i++){
			int val=1;
			if(a[i] == 0){
				count++;
				val = -1;
			}
			max = Math.max(val, max+val);
			max_so_far = Math.max(max,max_so_far);
		}
		System.out.println(count+max_so_far);
	}
}
