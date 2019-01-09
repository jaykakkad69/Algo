import java.util.*;
import java.io.*;
class SubArraySum {
    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int[] b = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int n = b[0], sum=b[1];
			boolean f=false;
			for(int s=0; s<n; s++){
				int i=s,k=0;
				while(i<n && k<sum)
					k += a[i++];
				if(k==sum){
					f = true;
					System.out.println((s+1) + " " + (i));
					break;
				}
			}
			if(!f)
			    System.out.println("-1");
		}
    }
}

