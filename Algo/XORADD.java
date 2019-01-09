import java.io.*;

class XORADD{
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("XOR: ");
		int diff = Integer.parseInt(br.readLine());
		System.out.print("Addition: ");
		int add = Integer.parseInt(br.readLine());

		if(diff%2 == add%2)
			System.out.print((add + diff)/2 + "  " + (add-diff)/2 + "\n");
		else
			System.out.println("Not Possible");
	}
}
