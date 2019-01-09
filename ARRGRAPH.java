import java.util.*;

class ARRGRAPH{
	public static void main(String[] arg){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		while(t-- > 0){
			s.nextLine();
			String[] str = s.nextLine().split(" ");
			int[] a = new int[str.length];
			for(int i=0; i<str.length; i++)
				a[i] = Integer.parseInt(str[i]);

			graph(a);
		}
	}

	public static void graph(int[] x){
		int[] a = x.clone();
		int[] b = new int[a.length];
		int[] temp = new int[a.length];
		int[] num = new int[51];
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
		for(int i=0; i<primes.length; i++)
			num[primes[i]] = 1;
		num[0] = 1;
		num[1] = 1;
		int count = 0;
		int g = a[0];
		b[0] = a[0];
		for(int i=1; i<a.length; i++){
			num[a[i]] = 0;
			g = gcd(g,a[i]);
			if(g != 1){
				count++;
				temp[i] = a[i];
				b[i] = a[i];
			}
			else{
				b[i] = a[i];
				int j = 0;
				while(count != 0){
					while(temp[j] == 0)
						j++;
					b[j] = temp[j];
					temp[j] = 0;
					count--;
				}
			}
		}
		int c = count;
		if(g != 1){
			/*int j = 0;
			while(count != 0){
				while(temp[j] == 0)
					j++;
				
				int k = 2;
				while(num[k] == 0 && gcd(k,b[j-1]) != 1)
					k++;
				num[temp[j]] = 0;
				num[k] = 1;
				count--;
				b[j] = k;
			}
			System.out.println(c);*/
			int j = 0;
			while(temp[j] == 0)
				j++;

			int p = 50;
			while(num[p] == 0)
				p--;

			b[j] = p;
			System.out.println("1");
			for(int i=0; i<a.length; i++)
				System.out.print(b[i] + " ");
			System.out.println(" ");
		}
		else{
			System.out.println("0");
			for(int i=0; i<a.length; i++)
				System.out.print(b[i] + " ");
			System.out.println(" ");
		}
	}

	public static int gcd(int a, int b) {
		return (b!=0) ? gcd(b, a%b) : a;
	}

}
