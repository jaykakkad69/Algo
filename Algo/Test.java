import java.util.*;
import java.io.*;

class Test{
    public static void main(String[] arg) throws Exception{
	File file = new File("input4.txt");
	BufferedReader br = new BufferedReader(new FileReader(file));
	HashSet<Integer> hash = new HashSet<Integer>();
	
	String temp;
	int blocks = 0, n, c=0;
	
	System.out.print("Enter K: ");
	int k = (new Scanner(System.in)).nextInt();
	
	while((temp = br.readLine()) != null){
	    n = Integer.parseInt(temp);
	    if(!hash.contains(n)){
		if(hash.size() == k){
		    hash.clear();
		    blocks++;
		}
		hash.add(n);
	    }
	    //System.out.print((c++) + " ");  
	}
	System.out.println(blocks + 1);
    }
}
