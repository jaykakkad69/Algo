import java.util.*;
import java.io.*;

class MAXPRODU {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int m = 1000000007;
		while (t-- > 0) {
			String[] s = br.readLine().split("\\s");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);

			if(n<=k) {
				System.out.println("-1");
				return;
			}
			Queue<Integer> q = maxProduct(n, k);
			if (q.size() < k)
				System.out.println("-1");
			else {
				if (q.contains(1))
					System.out.println("0");
				else {
					int p = 1;
					int x = 0;
					while (!q.isEmpty()) {
						x = q.remove();
						p = (((p * x) % m) * (x - 1)) % m;
					}
					System.out.println(p);
				}
			}
		}
	}

	public static Queue<Integer> maxProduct(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while (q.size() != k) {
			int x = q.remove();
			boolean flag = true;
			// int t1 = Math.ceil(x/2.0) - 1;
			int t1 = x / 2, t2 = -1;
			while (flag) {
				if (t1 <= 0)
					return q;

				while (q.contains(t1)) {
					t1--;
					if(t1 == 0)
						return q;
				}

				t2 = x - t1;
				if ((t1 == t2 && q.size() + 2 == k) || q.contains(t2))
					t1--;
				else
					flag = false;
			}
			q.add(t2);
			q.add(t1);
		}
		return q;
	}
}
