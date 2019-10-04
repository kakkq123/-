import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15684 {

	static int c, m, r, min = Integer.MAX_VALUE;
	static boolean[][] ladder;
	static boolean possible;

	public static int go(int col) {
		int row = 1;
		while (row <= r) {
			if (ladder[row][col])
				col++;
			else if (col > 1 && ladder[row][col - 1])
				col--;
			row++;
		}
		return col;
	}

	public static boolean check() {
		for (int i = 1; i <= c; i++) {
			if (i != go(i))
				return false;
		}
		return true;
	}

	public static void dfs(int row, int col, int plus_line) {
		if (plus_line > 3)
			return;
		if (check()) {
			possible = true;//
			min = Math.min(min, plus_line);
			return;
		}
		for (int i = row; i <= r; i++) {
			int k = (r < r && i == r ? col : 1);
			for (int j = k; j < c; j++) {
				if (ladder[i][j] || (j > 1 && ladder[i][j - 1]) || (j < c - 1 && ladder[i][j + 1]))
					continue;

				ladder[i][j] = true;
				dfs(i, j, plus_line + 1);
				ladder[i][j] = false;
			} // for j
		} // for i
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		ladder = new boolean[r + 1][c + 1];
		int a, b;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true; // 연결
		}

		dfs(1, 1, 0);
		// print
		if (possible)
			System.out.println(min);
		else
			System.out.println(-1);
		br.close();
	}
}
