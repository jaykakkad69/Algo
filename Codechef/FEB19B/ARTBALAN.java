import java.io.*;
import java.util.*;

class ARTBALAN{
	static void test(String str){
		int[] freq = new int[26];
		int n = str.length();
		for(int i=0; i<n; i++)
			freq[str.charAt(i) - 'A']++;

		Arrays.sort(freq);
		int c=0,min=Integer.MAX_VALUE,j,occ;
		for(int i=1; i<=26; i++){
			if(n%i == 0){
				j=0; c=0; occ=n/i;
				while(freq[j] > occ)
					j++;
				for(int k=0; k<i; k++){
					c += occ - freq[j];
					j++;
				}
				min = Math.min(min,c);
			}
		}
		System.out.println(min);
	}

	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String[] str = new String[t];
		for(int i=0; i<t; i++)
			str[i] = br.readLine();
		for(int i=0; i<t; i++)
			test(str[i]);
	}	
}
