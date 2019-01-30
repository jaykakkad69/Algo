import java.io.*;
import java.util.*;

class MaxinSubarray{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			String[] temp = br.readLine().split("\\s");
			int n = Integer.parseInt(temp[0]);
			int k = Integer.parseInt(temp[1]);
			int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		}
	}
}
