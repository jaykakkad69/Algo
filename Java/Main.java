import java.util.Scanner;

public class Main{
	public static void main(String[] arg){
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());
		while(t-- > 0){
			boolean bf[] = new boolean[3];
			boolean of[] = new boolean[3];
			int bc=0, oc=0;
			boolean flag = false;
			char[] l1 = scan.nextLine().toCharArray();
			char[] l2 = scan.nextLine().toCharArray();
			for(int i=0; i<3; i++){
				if(l1[i] == 'b' || l2[i] == 'b'){
					bf[i] = true;
					bc++;
				}
				if(l1[i] == 'o' || l2[i] == 'o'){
					oc++;
					of[i] = true;
				}
			}
			if(oc >= 1){
			    if(bc == 3)
				flag = true;
			    else if(bc == 2){
				for(int i=0; i<3; i++){
				    if(bf[i] == false && of[i] == true){
					flag = true;
					break;
				    }
				}
			    }
			    
			    if(flag)
				System.out.println("yes");
			    else
				System.out.println("no");
			}
			else
			    System.out.println("no");
		}
	}
}
