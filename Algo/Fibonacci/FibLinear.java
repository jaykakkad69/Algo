public class FibLinear{
    static void fibLinear(int n){
	int a=0,b=1,c=0;
	for(int i=2; i<=n; i++){
	    c = a+b;
	    a = b;
	    b = c;
	}
	System.out.println(c);
    }
    public static void main(String[] arg){
	fibLinear(Integer.parseInt(arg[0]));
    }
}
