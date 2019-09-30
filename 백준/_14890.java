import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14890 {
	static int n, l, count = 0, d;
	static int[][] map;
	static boolean[][] slope;
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };

	public static boolean check(int t, int val) {
		return t == val || t - 1 == val || t + 1 == val;
	}

	public static boolean isrange(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}

	public static boolean left_slope(int r, int c, int t) {
		// left
		for (int i = 0; i < l; i++) {
			r -= dr[d];
			c -= dc[d];
			if (!isrange(r, c) || t != map[r][c] || slope[r][c])
				return false;

			slope[r][c] = true; 

		}
		return true;
	}

	public static boolean right_slope(int r, int c, int t) {
		// right
		for (int i = 0; i < l; i++) {
			if (!isrange(r, c) || t != map[r][c] || slope[r][c])
				return false;

			slope[r][c] = true; 
			r += dr[d];
			c += dc[d];
		}
		return true;
	}

	public static void solve(int r, int c) {
		int t = map[r][c];
		for (int i = 1; i < n; i++) {
			r += dr[d];
			c += dc[d];
			if (!check(t, map[r][c]))
				return;

			if (t - 1 == map[r][c]) {
				if (right_slope(r, c, t - 1))
					t--;
				else
					return;

			} else if (t + 1 == map[r][c]) {
				if (left_slope(r, c, t))
					t++;
				else
					return;

			}
		}

		count++;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		//
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// row check
		d = 1;
		slope = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			solve(i, 0);
		}
		// column check
		d = 0;
		slope = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			solve(0, i);
		}
		System.out.println(count);
		br.close();
	}

}
