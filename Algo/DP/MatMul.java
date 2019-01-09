import java.io.*;
import java.util.*;

class MatMul {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter Dimentions(Space seperated): ");
		String[] s = br.readLine().split("\\s");
		int[] a = new int[s.length];
		int i = 0;
		for (String x : s)
			a[i++] = Integer.parseInt(x);

		matmul(a);
	}

	public static void matmul(int[] a) {
		int n = a.length;
		int[][] dp = new int[n][n];
		int[][] kp = new int[n][n];
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				int min = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int ans = dp[i][k] + dp[k + 1][j] + a[i - 1] * a[k] * a[j];
					if (ans < min) {
						min = ans;
						kp[i][j] = k;
					}
					dp[i][j] = min;
				}
			}
		}
		// for(int[] x : kp)
		// System.out.println(Arrays.toString(x));
		final char name = 'A';
		par(kp, 1, n - 1, name);
		System.out.println("\nNo. of Multiplications: " + dp[1][n - 1]);
	}

	public static void par(int[][] kp, int i, int j, char name) {
		if (i == j) {
			System.out.print((char) (name + i - 1));
			return;
		}
		System.out.print("(");
		par(kp, i, kp[i][j], name);
		par(kp, kp[i][j] + 1, j, name);
		System.out.print(")");
	}
}

