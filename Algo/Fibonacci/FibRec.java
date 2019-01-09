import java.util.Scanner;
public class FibRec{
    static public int fibRec(int i){
	if(i < 2)
	    return i;
	else
	    return fibRec(i-1) + fibRec(i-2);
    }
    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter a no. ");
	int i = scan.nextInt();
	long st = System.currentTimeMillis();
	System.out.println(fibRec(i));
	long et = System.currentTimeMillis();
	System.out.println(et - st);
	scan.close();
    }
}
