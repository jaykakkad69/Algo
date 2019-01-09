import java.util.*;

class MINDSUM{
    public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	int t = Integer.parseInt(s.nextLine());

	while(t-- > 0){
	    String[] temp = s.nextLine().split(" ");
	    long n = Long.parseLong(temp[0]);
	    long d = Long.parseLong(temp[1]);
	    
	    int operation = 0;
	    /*int prevroot = digitRoot(ni);
	    operation++;
	    n += d;
	    int root = digitRoot(n);
	    while(root <  prevroot){
		operation++;
		prevroot = root;
		n += d;
		root = digitRoot(n);
	    }
	    n -= d;
	    

	    int r = 0; 
	    // Loop to do sum while 
	    // sum is not less than 
	    // or equal to 9 
	    while (n > 0 || r > 9)  
	    { 
		operation++;
		if (n == 0) { 
		    n = r; 
		    r = 0; 
		} 
              
		r += n % 10; 
		n /= 10; 
	    } 
	
	    System.out.println(prevroot + " " + operation);*/

	    int repeat = digitRoot(n);
	    int k=1, min = repeat;
	    int root = digitRoot(n + (k*d));
	    if(root < min)
		min = root;
	    while(root != repeat || min != 1){
		k++;
		root = digitRoot(n + (k*d));
		if(root < min)
		    min = root;
	    }
	    operation = k+1;
	    int r = 0;
	    // Loop to do sum while
	    // sum is not less than
	    // or equal to 9
	    while (n > 0 || r > 9)
	    {
		if (n == 0) {
		    n = r;
		    r = 0;
		    operation++;
		}

		r += n % 10;
		n /= 10;
	    }
	    System.out.println(min + " " + operation);
	}
    }

    public static int digitRoot(long n){
	if (n == 0)  
	    return 0; 
        return (n % 9L == 0L) ? 9 : (int)(n % 9L); 
    }
}
