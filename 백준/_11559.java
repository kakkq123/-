import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class _11559 {
	static int count = 0;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static char[][] board = new char[12][6];
	static Queue<Pos> list, tmp;

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean range(int r, int c) {
		return r >= 0 && r < 12 && c >= 0 && c < 6;
	}

	public static void delete() {
		while (!list.isEmpty()) {
			Pos p = list.poll();
			board[p.r][p.c] = '.';
		}
		for (int c = 0; c < 6; c++) {
			for (int r = 11; r >= 0; r--) {
				if (board[r][c] == '.') {
					int d = 0, nr = r;
					while (range(nr, c) && board[nr][c] == '.') {
						d++;
						nr--;
					}
					if (d > 0) {
						for (int i = nr; i >= 0; i--) {
							board[i + d][c] = board[i][c];
						}
						for (int i = 0; i < d; i++) {
							board[i][c] = '.';
						}
					}
				}
			}
		}
	}

	public static int bfs(char c, Queue<Pos> q, boolean[][] visit) {
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();
				tmp.add(new Pos(p.r, p.c));
				cnt++;
				for (int j = 0; j < 4; j++) {
					int nr = p.r + dr[j], nc = p.c + dc[j];
					if (!range(nr, nc) || visit[nr][nc] || board[nr][nc] != c)
						continue;
					q.add(new Pos(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
		return cnt;
	}

	public static void solve() {
		boolean ischange;
		do {
			ischange = false;
			list = new LinkedList<Pos>(); // 제거되는 항목들
			boolean[][] visit = new boolean[12][6];
			for (int r = 11; r >= 0; r--) {
				for (int c = 0; c < 6; c++) {
					if (board[r][c] != '.' && !visit[r][c]) {
						Queue<Pos> q = new LinkedList<Pos>();
						tmp = new LinkedList<Pos>();
						q.add(new Pos(r, c));
						visit[r][c] = true;
						if (bfs(board[r][c], q, visit) >= 4) {
							ischange = true;
							list.addAll(tmp);
						}
					}
				}
			}
			if (ischange) {
				count++;
				delete();
			}
		} while (ischange);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			board[i] = br.readLine().toCharArray();
		}
		solve();
		System.out.println(count);
		br.close();

	}

}
