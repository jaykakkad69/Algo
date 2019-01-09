import java.util.*;

class BS{
    static void make(char[] a, String s){
	if(s.length() >= a.length)
	    System.out.println(s);
	else{
	    for(char x : a){
		make(a,s+x);
	    }
	}
    }
    public static void main(String[] arg){
	int n = 3;
	String s = "";
	char[] c = new char[n];
	for(int i=0; i<n; i++){
	    c[i] = (char)(i+1+'0');
	    System.out.println(c[i]);
	}
	make(c,s);
    }
}
