import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * DP로 굳이 구현하지 않아도 되는 문제이다
 * n * m - 1 => 바로 답을 도출할 수 있다
 * 백준에 DP 알고리즘으로 분류되어 있어서 한 번 DP로 구현해보았다
 * DP로 풀 때랑 아닐 때랑 메모리와 속도는 큰 차이가 없었다.
 * */
public class 초콜릿자르기_2163_DP {
	static int[][] dp;

	public static int solve(int n, int m) {
		if (n == 1)
			return dp[1][m] = m - 1;
		if (dp[n][m] > 0)
			return dp[n][m];
		int a = n / 2, b = n - a;
		return dp[n][m] = solve(a, m) + solve(b, m) + 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][m + 1];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solve(n,m) + "\n");
		bw.flush();
		bw.close();
	}

}
