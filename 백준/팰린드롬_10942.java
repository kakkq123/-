import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 팰린드롬_10942 {
	static int n;
	static int[] a;
	static int[][] dp;

	public static int solve(int s, int e) {
		if (s > e)
			return 0;
		if (dp[s][e] == 1)
			return dp[s][e];
		if (s == e || (e - s == 1 && a[s] == a[e]))
			return dp[s][e] = 1;
		if (a[s] == a[e] && solve(s + 1, e - 1) == 1)
			return dp[s][e] = 1;
		return dp[s][e] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n + 1];
		dp = new int[n + 1][n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		/*
		 * bufferedWriter을 반드시 사용 System.out.println()를 사용하면 시간초과가 발생함
		 */
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bufferedWriter.write(solve(s, e) + "\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		br.close();

	}

}
