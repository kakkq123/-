import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16197 {
	static char[][] board;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int row, col, answer = 11;

	public static boolean range(int r, int c) {
		return r >= 0 && r < row && c >= 0 && c < col;
	}

	public static void dfs(int num, int x1, int y1, int x2, int y2) {
		// num check or 모든 동전이 떨어질 경우
		if (num > 10 || (!range(x1, y1) && !range(x2, y2)))
			return;
		// 동전이 하나만 떨어지는 경우
		if (!range(x1, y1)) {
			answer = Math.min(answer, num);
			return;
		}
		if (!range(x2, y2)) {
			answer = Math.min(answer, num);
			return;
		}
		// 코인 이동
		for (int i = 0; i < 4; i++) {
			int nx1 = x1 + dx[i], ny1 = y1 + dy[i], nx2 = x2 + dx[i], ny2 = y2 + dy[i];
			if (range(nx1, ny1) && board[nx1][ny1] == '#') {
				nx1 = x1;
				ny1 = y1;
			}
			if (range(nx2, ny2) && board[nx2][ny2] == '#') {
				nx2 = x2;
				ny2 = y2;
			}
			dfs(num + 1, nx1, ny1, nx2, ny2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		board = new char[row][col];
		int t = 0, x1 = -1, x2 = -1, y1 = -1, y2 = -1;
		for (int i = 0; i < row; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'o') {
					if (t == 0) {
						x1 = i;
						y1 = j;
						t++;
					} else {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
		dfs(0, x1, y1, x2, y2);
		answer = answer == 11 ? -1 : answer; // answer이 변하지 않았다면 -1출력
		System.out.println(answer);
		br.readLine();
	}

}
