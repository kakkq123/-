import java.io.*;
import java.util.*;

public class 발전소_1102 {
	static int[][] cost = new int[16][16];
	static int[] dp = new int[1 << 16];
	static final int INF = 2000000000;
	static int N, P;

	public static int dfs(int path, int len) {
		if (len == P)
			return 0;
		if (dp[path] != -1)
			return dp[path];
		dp[path] = INF;
		for (int from = 0; from < N; from++) {
			if ((~path & (1 << from)) > 0) {
				for (int to = 0; to < N; to++) {
					if (to == from)
						continue;
					if ((path & (1 << to)) > 0) {
						int npath = path - (1 << to);
						int value = dfs(npath, len + 1) + cost[from][to];
						dp[path] = Math.min(dp[path], value);
					}
				}
			}
		}
		return dp[path];
	}

	public static int solve(String s) {
		int path = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'Y')
				cnt++;
			else
				path |= 1 << i;
		}
		if (cnt == 0) {
			if (P == 0)
				return 0;
			else
				return -1;
		}
		if (cnt >= P) {
			return 0;
		}
		Arrays.fill(dp, -1);
		return dfs(path, cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		String s = br.readLine();
		P = Integer.parseInt(br.readLine());
		br.close();
		bw.write(solve(s) + "\n");
		bw.close();
	}

}
