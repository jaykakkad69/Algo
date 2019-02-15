import java.io.*;
import java.util.*;

class MaxinSubarray{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0){
			String[] temp = br.readLine().split("\\s");
			int n = Integer.parseInt(temp[0]);
			int k = Integer.parseInt(temp[1]);
			int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

			int[] b = new int[n];
			int t=0, h=0, j=b[t];
			b[0] = 0;
			for(int i=1; i<k; i++){
				while(h>=0 && a[b[h]] < a[i])
					h--;
				b[++h] = i;
			}
			for(int i=k; i<n; i++){
				System.out.print(a[j] + " ");
				while(h>=0 && a[b[h]] < a[i])
					h--;
				b[++h] = i;
				if(i+1-j > k)
					j = b[++t];
			}
			System.out.print("\n");
		}
	}
}
