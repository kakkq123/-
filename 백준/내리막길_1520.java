import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * dp의 모든 값을 -1로 초기화해준다. 
 * dfs()함수를 돌면서 dp의 값이 -1이 아니라면 이미 계산된 값이 존재하기 때문에 바로 가져다 사용하면 되고
 * 그렇지 않으면 dfs함수를 호출하여 값을 계산해준다.
 * 이렇게 하지 않으면 시간초과가 발생하기 때문에 중복 호출이나 계산이 되지 않도록 조심해야한다.
 * */


public class 내리막길_1520 {
	static int[][] a, dp;
	static int m, n;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	public static int dfs(int r, int c) {
		if (r == 0 && c == 0)
			return dp[0][0] = 1;

		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if (nr < 0 || nr >= m || nc < 0 || nc >= n || a[nr][nc] <= a[r][c])
				continue;
			if (dp[nr][nc] == -1)
				dp[nr][nc] = dfs(nr, nc);
			dp[r][c] += dp[nr][nc];
		}

		return dp[r][c];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[m][n];
		dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		br.close();
		dfs(m - 1, n - 1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(dp[m - 1][n - 1] + "\n");
		bw.flush();
		bw.close();

	}

}
