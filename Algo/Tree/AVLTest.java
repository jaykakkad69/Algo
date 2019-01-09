import java.util.*;

class AVLTest{
    public static void main(String[] arg){
		Scanner scan = new Scanner(System.in);
		//System.out.print("Enter the no. of entries: ");
		//int n = s.nextLine();
		//int[] a = new int[n];
		String[] str = scan.nextLine().split(" ");
		int[] a = new int[str.length]; 
		for(int i=0; i<a.length; i++)
			a[i] = Integer.parseInt(str[i]);

		AVL avl = new AVL();
		avl.create(a);

		int choice;
		while(true){
			System.out.print("\n1.Add\n2.Delete\n3.Search\n4.Preorder\n5.Rank\n6.Find Rank\n7.Numbers b/w X and Y\n8.Sum b/w X and Y\n9.Average b/w X and Y\n10.Maxgap\n11.Mingap\n12.Max gap b/w X and Y\n13.EXIT\nCHOICE: ");
			choice = scan.nextInt();

			if(choice == 1){
				System.out.print("Enter the number to be added  ");
				avl.add(scan.nextInt());
				avl.preorder();
			}
			else if(choice == 2){
				System.out.print("Enter the number to be deleted  ");
				avl.delete(scan.nextInt());
				avl.preorder();
			}
			else if(choice == 3){
				System.out.print("Enter the number to be searched  ");
				avl.search(scan.nextInt());
				avl.preorder();
			}
			else if(choice == 4){
				avl.preorder();
			}
			else if(choice == 5){
				System.out.print("Enter the Number ");
				avl.rank(scan.nextInt());
			}
			else if(choice == 6){
				System.out.print("Enter the Rank ");
				avl.findRank(scan.nextInt());
			}
			else if(choice == 7){
				System.out.print("Enter X and Y ");
				avl.numbers(scan.nextInt(), scan.nextInt());
			}
			else if(choice == 8){
				System.out.print("Enter X and Y ");
				avl.sum(scan.nextInt(), scan.nextInt());
			}
			else if(choice == 9){
				System.out.print("Enter X and Y ");
				avl.average(scan.nextInt(), scan.nextInt());
			}
			else if(choice == 10){
				avl.maxgap();
			}
			else if(choice == 11){
				avl.mingap();
			}
			else if(choice == 12){
				System.out.print("Enter X and Y ");
				avl.maxgap(scan.nextInt(), scan.nextInt());
			}
			else if(choice == 13)
				break;
			else
				System.out.println("Try again");
		}
	}
}
