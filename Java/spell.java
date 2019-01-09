import java.util.Scanner;

public class spell{
	public static void main(String[] arg){
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine());
		while(t-- > 0){
			int count = 0;
			char[] l1 = scan.nextLine().toCharArray();
			char[] l2 = scan.nextLine().toCharArray();
			
			for(int i=0; i<3; i++)
				if(l1[i] == 'b' || l1[i] == 'o' || l2[i] == 'b' || l2[i] == 'o')
				count++;
			
			if(count == 3)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
