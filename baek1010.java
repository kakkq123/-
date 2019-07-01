import java.util.Scanner;

public class baek1010 {
	static int[][] dp = new int[31][31];

	public static int bridge_dp(int a, int b) {
		if (a == b)
			return dp[a][b] = 1;
		if (b == 1)
			return dp[a][b] = a;
		if (b == 0)
			return dp[a][b] = 1;

		if (dp[a][b] != 0)
			return dp[a][b];

		return dp[a][b] = bridge_dp(a - 1, b) + bridge_dp(a - 1, b - 1);

	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		int[] test = new int[t];
		int n, m;

		// test
		for (int i = 0; i < t; i++) {
			n = kb.nextInt();
			m = kb.nextInt();

			test[i] = bridge_dp(m, n);

		}

		// print
		for (int i = 0; i < t; i++)
			System.out.printf("%d\n", test[i]);

	}

}
