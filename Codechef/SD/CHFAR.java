import java.io.*;

class CHDAR{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			String[] s = br.readLine().split("\\s");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);

			int[] a = new int[n];
			int i = 0;
			s = br.readLine().split("\\s");
			for(String str : s)
				a[i++] = Integer.parseInt(str);

			int count = 0;
			for(int x : a)
				if(x == 1)
					count++;

			if(count+k >= n)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
