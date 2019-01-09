import java.io.*;
import java.util.*;

class SNCKYEAR{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		set.add("2010");
		set.add("2015");
		set.add("2016");
		set.add("2017");
		set.add("2019");
		while(t-- > 0){
			if(set.contains(br.readLine()))
				System.out.println("HOSTED");
			else
				System.out.println("NOT HOSTED");
		}
	}
}
