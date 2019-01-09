public class FibMatrix{
    static int[][] matMul(int[][] a, int[][] b, int m){
	int[][] c = new int[2][2];
	for(int i=0; i<2; i++){
	    for(int j=0; j<2; j++){
		for(int k=0; k<2; k++){
		    c[i][j] += a[i][k] * b[k][j];
		}
		c[i][j] = c[i][j] % m;
	    }
	}
//	System.out.println(c[0][0] + "  " + c[0][1]);
//	System.out.println(c[1][0] + "  " + c[1][1] + "\n");

	return c;
    }
    static void matPow(int[][] x, int y, int m){
	int[][] res = new int[][]{{1,0},{0,1}};
	while (y > 0){ 
//	    System.out.println(y);
	    if ((y & 1) == 1) 
	        res = matMul(res,x,m);   
	    y = y>>1; // y = y/2 
	    x = matMul(x,x,m);  // Change x to x^2 
        } 

	System.out.println(res[0][0]);
    }

    static void fibMat(int n, int m){
	int[][] a = new int[][]{{1,1},{1,0}};
	matPow(a,n-1, m);
    }

    public static void main(String[] arg){
	fibMat(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]));
    }   
}
