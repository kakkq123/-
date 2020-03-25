import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class 통나무옮기기_1938 {
	static char[][] board;
	static int n;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static Queue<Pos> q = new LinkedList<Pos>();

	static class Pos {
		int x1, y1, x2, y2, x3, y3, d;

		public Pos(int x1, int y1, int x2, int y2, int x3, int y3, int d) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
			this.d = d;
		}
	}

	public static boolean range(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static boolean up_check(int x, int y, int d) {
		if (d == 0) {
			// 블록이 가로인 경우
			for (int i = 0; i <3; i++) {
				if (!range(x - 1, y + i) || board[x - 1][y + i] == '1')
					return false;
			}
		} else {
			// 세로인 경우
			if (!range(x - 1, y) || board[x - 1][y] == '1')
				return false;
		}
		return true;
	}

	public static boolean down_check(int x, int y, int d) {
		if (d == 0) {
			// 블록이 가로인 경우
			for (int i = 0; i < 3; i++) {
				if (!range(x + 1, y + i) || board[x + 1][y + i] == '1')
					return false;
			}
		} else {
			// 블록이 세로인 경우
			if (!range(x + 3, y) || board[x + 3][y] == '1')
				return false;
		}
		return true;
	}

	public static boolean left_check(int x, int y, int d) {
		if (d == 0) {
			// 블록이 가로인 경우
			if (!range(x, y - 1) || board[x][y - 1] == '1')
				return false;
		} else {
			// 블록 세로인 경우
			for (int i = 0; i < 3; i++) {
				if (!range(x + i, y - 1) || board[x + i][y - 1] == '1')
					return false;
			}
		}
		return true;
	}

	public static boolean right_check(int x, int y, int d) {
		if (d == 0) {
			// 블록이 가로인 경우
			if (!range(x, y + 3) || board[x][y + 3] == '1')
				return false;
		} else {
			// 블록 세로인 경우
			for (int i = 0; i < 3; i++) {
				if (!range(x + i, y + 1) || board[x + i][y + 1] == '1')
					return false;
			}
		}
		return true;
	}

	public static boolean check(int x1, int y1, int x2, int y2, int x3, int y3) {
		return board[x1][y1] != '1' && board[x2][y2] != '1' && board[x3][y3] != '1';
	}

	public static void bfs() {
		boolean[][][] visit = new boolean[n][n][2];
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Pos p = q.poll();
				if (visit[p.x1][p.y1][p.d])
					continue;
				visit[p.x1][p.y1][p.d] = true;
				if (board[p.x1][p.y1] == 'E' && board[p.x2][p.y2] == 'E' && board[p.x3][p.y3] == 'E') {
					System.out.println(cnt);
					return;
				}
				for (int i = 0; i < 4; i++) {
					if (i == 0 && !up_check(p.x1, p.y1, p.d))
						continue;
					if (i == 1 && !down_check(p.x1, p.y1, p.d))
						continue;
					if (i == 2 && !left_check(p.x1, p.y1, p.d))
						continue;
					if (i == 3 && !right_check(p.x1, p.y1, p.d))
						continue;
					int x1 = p.x1 + dx[i], y1 = p.y1 + dy[i], x2 = p.x2 + dx[i], y2 = p.y2 + dy[i], x3 = p.x3 + dx[i],
							y3 = p.y3 + dy[i];
					q.add(new Pos(x1, y1, x2, y2, x3, y3, p.d));
				}
				// TURN
				if (p.d == 0 && up_check(p.x1, p.y1, 0) && down_check(p.x1, p.y1, 0)) {
					p.x1--;
					p.y1++;
					p.x3++;
					p.y3--;
					q.add(new Pos(p.x1, p.y1, p.x2, p.y2, p.x3, p.y3, 1));
				}
				if (p.d == 1 && left_check(p.x1, p.y1, 1) && right_check(p.x1, p.y1, 1)) {
					p.x1++;
					p.y1--;
					p.x3--;
					p.y3++;
					q.add(new Pos(p.x1, p.y1, p.x2, p.y2, p.x3, p.y3, 0));
				}

			}
			cnt++;
		}
		System.out.println(0);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		int[][] tmp = new int[3][2];
		int k = 0;
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'B') {
					board[i][j] = 0;
					tmp[k][0] = i;
					tmp[k][1] = j;
					k++;
				}
			}
		}
		int d; // 0은 통나무가 가로로, 1은 세로로 있는 상태
		if (tmp[0][0] == tmp[1][0])
			d = 0;
		else
			d = 1;
		q.add(new Pos(tmp[0][0], tmp[0][1], tmp[1][0], tmp[1][1], tmp[2][0], tmp[2][1], d));

		bfs();
		br.close();
	}

}
