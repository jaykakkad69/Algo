import java.io.*;

class LIS{
	public static void main(String[] arg) throws Exception{
	BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		System.out.println("Enter Numbers");
		String[] line = bf.readLine().split("\\s");
		int[] a = new int[line.length];
		int i = 0;
		for(String str : line)
			a[i++] = Integer.parseInt(str);

		lis(a);
	}

	public static void lis(int[] a){
		int n = a.length;
		int[] lis = new int[n];
		for(int i=0; i<n; i++)
			lis[i] = 1;

		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(a[i] > a[j] && lis[i] <  1 + lis[j])
					lis[i] = lis[j] + 1;
			}
		}
		int max = 0;
		for(int x : lis)
			if(x > max)
				max = x;
		System.out.println(max);
	}
}
