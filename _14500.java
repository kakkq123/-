import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14500 {
	static int[][] board;
	static int n, m, max = 0;

	public static void shape1(int row, int col) {
		int sum = 0;
		if (row + 4 <= n) {
			sum = board[row][col] + board[row + 1][col] + board[row + 2][col] + board[row + 3][col];
			max = Math.max(sum, max);
		}
		if (col + 4 <= m) {
			sum = board[row][col] + board[row][col + 1] + board[row][col + 2] + board[row][col + 3];
			max = Math.max(sum, max);
		}
	}

	public static void shape2(int row, int col) {
		int sum = 0;
		if (row + 2 <= n && col + 2 <= m) {
			sum = board[row][col] + board[row][col + 1] + board[row + 1][col] + board[row + 1][col + 1];
			max = Math.max(sum, max);
		}
	}

	public static void shape3(int row, int col) {
		int sum = 0;
		if (row + 2 <= n && col + 3 <= m) {
			sum = board[row][col + 1] + board[row + 1][col + 1]
					+ Math.max(board[row + 1][col] + board[row + 1][col + 2], board[row][col] + board[row][col + 2]);
			max = Math.max(sum, max);
		}
		if (row + 3 <= n && col + 2 <= m) {
			sum = board[row + 1][col] + board[row + 1][col + 1]
					+ Math.max(board[row][col] + board[row + 2][col], board[row][col + 1] + board[row + 2][col + 1]);
			max = Math.max(sum, max);
		}
	}

	public static void shape4(int row, int col) {
		int sum = 0;
		if (row + 3 <= n && col + 2 <= m) {
			sum = board[row + 2][col] + board[row + 2][col + 1]
					+ Math.max(board[row][col] + board[row + 1][col], board[row][col + 1] + board[row + 1][col + 1]);
			max = Math.max(sum, max);

			sum = board[row][col] + board[row][col + 1] + Math.max(board[row + 1][col] + board[row + 2][col],
					board[row + 1][col + 1] + board[row + 2][col + 1]);
			max = Math.max(sum, max);

		}
		if (row + 2 <= n && col + 3 <= m) {
			sum = board[row][col] + board[row][col + 1] + board[row][col + 2]
					+ Math.max(board[row + 1][col], board[row + 1][col + 2]);
			max = Math.max(sum, max);

			sum = board[row + 1][col] + board[row + 1][col + 1] + board[row + 1][col + 2]
					+ Math.max(board[row][col], board[row][col + 2]);
			max = Math.max(sum, max);

		}
	}

	public static void shape5(int row, int col) {
		int sum = 0;
		if (row + 3 <= n && col + 2 <= m) {
			sum = board[row + 1][col] + board[row + 1][col + 1]
					+ Math.max(board[row][col] + board[row + 2][col + 1], board[row][col + 1] + board[row + 2][col]);
			max = Math.max(sum, max);
		}
		if (row + 2 <= n && col + 3 <= m) {
			sum = board[row][col + 1] + board[row + 1][col + 1]
					+ Math.max(board[row][col + 2] + board[row + 1][col], board[row][col] + board[row + 1][col + 2]);
			max = Math.max(sum, max);
		}
	}

	public static void solution() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				shape1(i, j);
				shape2(i, j);
				shape3(i, j);
				shape4(i, j);
				shape5(i, j);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s;
		s = new StringTokenizer(br.readLine());
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(s.nextToken());
			}
		}
		solution();
		System.out.println(max);

		br.close();
	}

}
