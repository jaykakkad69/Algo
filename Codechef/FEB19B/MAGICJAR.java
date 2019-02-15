import java.io.*;
import java.util.*;

class MAGICJAR{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine().trim());
			int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			long sum = Arrays.stream(a).sum();
			System.out.println(sum-n+1);
		}
	}
}
