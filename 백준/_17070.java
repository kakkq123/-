import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070 {
	static int[][] board;
	static int[] dr = { 0, 1, 1 }, dc = { 1, 0, 1 };
	static int n, answer = 0;

	public static boolean range(int r, int c) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}

	public static boolean check(int r, int c, int number) {
		if (number == 0 && range(r + dr[0], c + dc[0]) && board[r + dr[0]][c + dc[0]] == 0) 
			return true;
		if (number == 1 && range(r + dr[1], c + dc[1]) && board[r + dr[1]][c + dc[1]] == 0)
			return true;
		if (number == 2) {
			for (int i = 0; i < 3; i++) {
				if (!range(r + dr[i], c + dc[i]) || board[r + dr[i]][c + dc[i]] == 1)
					return false;
			}
			return true;
		}
		return false;
	}

	public static void dfs(int r, int c, int shape) {
		if (r == n && c == n) {
			answer++;
			return;
		}
		if (shape == 0 || shape == 2) {
			if (check(r, c, 0)) 
				dfs(r + dr[0], c + dc[0], 0);
		}
		if (shape == 1 || shape == 2) {
			if (check(r, c, 1)) 
				dfs(r + dr[1], c + dc[1], 1);
		}
		if (check(r, c, 2)) 
			dfs(r + dr[2], c + dc[2], 2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		board = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(1, 2, 0);
		System.out.println(answer);
		br.close();
	}

}
