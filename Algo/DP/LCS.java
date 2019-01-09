import java.util.*;

class LCS{
	public static void main(String[] arg){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two Strings");
		String s1 = s.nextLine();
		String s2 = s.nextLine();
		lcs(s1,s2);
	}

	public static void lcs(String x, String y){
		int m = x.length(), n = y.length();
		int[][] lcs = new int[m+1][n+1];

		for(int i=1; i<m+1; i++){
			for(int j=1; j<n+1; j++){
				//if(i==0 || j==0)
					//lcs[i][j] = 0;
				if(x.charAt(i-1) == y.charAt(j-1))
					lcs[i][j] = lcs[i-1][j-1] + 1;
				else
					lcs[i][j] = Math.max(lcs[i-1][j] , lcs[i][j-1]);
			}
		}

		int index = lcs[m][n];
		char[] str = new char[index+1];
		str[index] = '\0';
		int i=m, j=n;
		while(i>0 && j>0){
			if(x.charAt(i-1) == y.charAt(j-1)){
				str[index-1] = x.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(lcs[i-1][j] > lcs[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println(new String(str).length());
	}
}
