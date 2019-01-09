import java.util.*;
//import BST.*;
class BSTTest{
    public static void main(String[] arg){
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = scan.nextInt();

		BST bst = new BST();
		bst.create(a);

		int choice;
		while(true){
			System.out.println("\n1.Add\n2.Delete\n3.Search\n4.Preorder\n5.EXIT");
			choice = scan.nextInt();

			if(choice == 1){
				System.out.print("Enter the number to be added  ");
				bst.add(scan.nextInt());
				bst.preorder();
			}
			else if(choice == 2){
				System.out.println("Enter the number to be deleted  ");
				bst.delete(scan.nextInt());
				bst.preorder();
			}
			else if(choice == 3){
				System.out.println("Enter the number to be searched  ");
				bst.search(scan.nextInt());
				bst.preorder();
			}
			else if(choice == 4){
				bst.preorder();
			}
			else if(choice == 5)
				break;
			else
			System.out.println("Try again");
		}
    }
}
