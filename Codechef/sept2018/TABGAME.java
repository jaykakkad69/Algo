import java.util.*;

class TABGAME{
    static int RA(int[][] a, int i, int j){
	if(a[i-1][j] == 1 || a[i][j-1] == 1){
	    //System.out.print("1");
	    return 1;
	}
	else if(a[i-1][j] == -1)
	    return RB(a,i,j-1);
	else if(a[i][j-1] == -1)
	    return RB(a,i-1,j);
	else if(a[i-2][j] == -1)
	    return RB(a,i-1,j);
	else if(a[i][j-2] == -1)
	    return RB(a,i,j-1);
	else{
	    //System.out.print("0");
	    return 0;
	}
    }

    static int RB(int[][] a, int i, int j){
	if(a[i-1][j] == 1 || a[i][j-1] == 1){
	    //System.out.print("0");
	    return 0;
	}
	else if(a[i-1][j] == -1)
	    return RA(a,i,j-1);
	else if(a[i][j-1] == -1)
	    return RA(a,i-1,j);
	else if(a[i-2][j] == -1)
	    return RA(a,i-1,j);
	else if(a[i][j-2] == -1)
	    return RA(a,i,j-1);
	else
	    return 0;
    }

    public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	int t = Integer.parseInt(s.nextLine());
	while(t-- > 0){
	    String M = s.nextLine();
	    String N = s.nextLine();
	    int m = M.length();
	    int n = N.length();

	    int[][] a = new int[n+1][m+1];
	    for(int i=0; i<m; i++){
		if((int)M.charAt(i) - '0' == 0)
		    a[0][i+1] = 1;
		else
		    a[0][i+1] = -1;
	    }
	    for(int j=0; j<n; j++){
		if((int)N.charAt(j) - '0' == 0)
		    a[j+1][0] = 1;
		else
		    a[j+1][0] = -1;
	    }
	    //System.out.println(Arrays.deepToString(a));

	    int q = s.nextInt();
	    while(q-- > 0){
		int i = s.nextInt();
		int j = s.nextInt();

		System.out.print(RA(a,i,j));
	    }
	}
    }
}
