import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _5557 {
	static int n;
	static long[][] dp;
	static int[] num;

	public static long dfs(int index, int a) {
		if (a < 0 || a > 20)
			return 0;
		if (index == n - 2) {
			if (a == num[n - 1])
				return 1;
			else
				return 0;
		}
		if (dp[index][a] != -1)
			return dp[index][a];
		return dp[index][a] = dfs(index + 1, a + num[index + 1]) + dfs(index + 1, a - num[index + 1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[n][21];
		num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(0, num[0]));
	}

}
