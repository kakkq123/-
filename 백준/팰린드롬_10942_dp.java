import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 팰린드롬_10942_dp {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n + 1];
		boolean[][] dp = new boolean[n + 1][n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		for (int d = 0; d < n; d++) {
			for (int k = 1; k <= n - d; k++) {
				if (d == 0)
					dp[k][k + d] = true;
				else if (d == 1 && a[k] == a[k + 1])
					dp[k][k + d] = true;
				else
					dp[k][k + d] = a[k] == a[k + d] && dp[k + 1][k + d - 1];
			}
		}
		int m = Integer.parseInt(br.readLine());
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		/*
		 * bufferedWriter을 반드시 사용 System.out.println()를 사용하면 시간초과가 발생함
		 */
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (dp[s][e])
				bufferedWriter.write(1 + "\n");
			else
				bufferedWriter.write(0 + "\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		br.close();

	}

}
