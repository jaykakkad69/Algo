import java.util.*;
import java.io.*;
class Kadane {
    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			long currMax = a[0], gMax = a[0];
			for(int i=1; i<n; i++){
				currMax = Math.max(a[i],currMax+a[i]);
				gMax = Math.max(gMax,currMax);
			}
			System.out.println(gMax);
		}
    }
}

