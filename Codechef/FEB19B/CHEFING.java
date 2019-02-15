import java.io.*;
import java.util.*;

class CHEFING{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			String[] str = new String[n];
			for(int i=0; i<n; i++)
				str[i] = br.readLine();

			boolean[] a1 = new boolean[26];
			boolean[] a2 = new boolean[26];

			for(int i=0; i<str[0].length(); i++)
				a1[str[0].charAt(i) - 97] = true;
			
			for(int i=1; i<n; i++){
				int l = str[i].length();
				if(i%2 == 1){
					for(int j=0; j<l; j++){
						if(a1[str[i].charAt(j)-97])
							a2[str[i].charAt(j)-97] = true;
					}
					a1 = new boolean[26];
				}
				else{
					for(int j=0; j<l; j++){
						if(a2[str[i].charAt(j)-97])
							a1[str[i].charAt(j)-97] = true;
					}
					a2 = new boolean[26];
				}
			}

			int c = 0;
			if(n%2 == 1){
				for(int i=0; i<26; i++)
					if(a1[i])
						c++;
			}
			else{
				for(int i=0; i<26; i++)
					if(a2[i])
						c++;
			}
			System.out.println(c);
		}
	}
}
