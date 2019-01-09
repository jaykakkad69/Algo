public class FibLargeBin{

    static void printar(char[] c){
	for(int i=0; i<c.length; i++)
	    System.out.print(c[i]);
	System.out.println("");
    }
    static char[] toBin(char[] c){
	String bin = "";
	while(c.length != 0){
	    bin = (c[c.length-1] % 2) + bin;
	    //System.out.println(bin);
	    c = divideBy2(c);
	}
	System.out.println(bin);
	return bin.toCharArray();
    }
    static char[] divideBy2(char[] number){
		int idx = 0;
		String ans = "";
		if(!(number.length == 1 && number[0] == '0')){
		//printar(number);
		int temp = number[idx] - '0';
		while (temp < 2 && idx < number.length-1)
		    temp = temp * 10 + (number[++idx] - '0');
		ans += temp/2;
		while (number.length-1 > idx){
	            temp = (temp % 2) * 10 + number[++idx] - '0';
		    ans += (temp / 2);
		}
		//System.out.println("ans: " + ans);
		}
		return ans.toCharArray();
	}
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
		return c;
	}
	static void matPow(int[][] x, char[] y){
		int i = 1;
		int m = (int)(Math.random() *(Math.pow(10,4) + 10 ));
		System.out.println(m);
		int[][] res = new int[][]{{1,0},{0,1}};
		while (y.length > i){
			if (y[y.length-i]  == '1') 
				res = matMul(res,x,m);   
			i++; // y = y/2 
			x = matMul(x,x,m);  // Change x to x^2 
		} 

		System.out.println("\n" +res[0][0]);
	}

	static void fibMat(char[] n){
		int[][] a = new int[][]{{1,1},{1,0}};

		// performing N-1
		int i=1;
		while(n[n.length-i] == '0'){
			n[n.length-i] = '9';
			i++;
		}
		n[n.length - i] -= 1;
		//System.out.println("N-1:  " + n);
		n = toBin(n);
		matPow(a,n);
	}

	public static void main(String[] arg){
		//int n = (int)(Math.random() * Math.pow(10,3));
		int[] n = new int[1000];
		char[] nn = new char[1000];
		for(int i=0; i<1000; i++){
			n[i] = (int)(Math.random() * 9);
			nn[i] += (char)(n[i] + (int)'0');
		}
		printar(nn);
		fibMat(nn);
	}
}
