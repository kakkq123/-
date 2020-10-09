import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static LinkedList<Integer>[][] a;
	static int[][] map = new int[13][13];
	static int[] dr = { 0, 0, 0, -1, 1 }, dc = { 0, 1, -1, 0, 0 };
	static Chess[] chess = new Chess[11];

	static class Chess {
		int r, c, dir;

		public Chess(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		a = new LinkedList[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				a[i][j] = new LinkedList<Integer>();
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			chess[i] = new Chess(r, c, dir);
			a[r][c].add(i);
		}
		br.close();

		int t = solve();
		t = t == 1001 ? -1 : t;
		bw.write(t + "\n");
		bw.close();
	}

	private static int solve() {
		for (int t = 1; t <= 1000; t++) {
			for (int i = 1; i <= k; i++) {
				int r = chess[i].r, c = chess[i].c;
				int nr = r + dr[chess[i].dir], nc = c + dc[chess[i].dir];

				// 벽? 파랑칸?
				if (check(nr, nc)) {
					// 방향 바꿔줌
					chess[i].dir = change_dir(chess[i].dir);
					nr = r + dr[chess[i].dir];
					nc = c + dc[chess[i].dir];
				}
				// 말 이동이 가능하다
				if (!check(nr, nc)) {
					int idx = get_idx(r, c, i);
					move(nr, nc, r, c, idx);
					if (a[nr][nc].size() >= 4)
						return t;
				}
			}
		}
		return -1;
	}

	private static void move(int nr, int nc, int r, int c, int idx) {
		// 벽이 화이트
		if (map[nr][nc] == 0) {
			for (int i = idx; i < a[r][c].size(); i++) {
				a[nr][nc].add(a[r][c].get(i));
				chess[a[r][c].get(i)].r = nr;
				chess[a[r][c].get(i)].c = nc;
			}

		}
		// 벽이 레드
		else {
			for (int i = a[r][c].size() - 1; i >= idx; i--) {
				a[nr][nc].add(a[r][c].get(i));
				chess[a[r][c].get(i)].r = nr;
				chess[a[r][c].get(i)].c = nc;
			}
		}
		// 기존 말은 삭제
		remove(r, c, idx);
	}

	private static void remove(int r, int c, int idx) {
		for (int i = a[r][c].size() - 1; i >= idx; i--)
			a[r][c].remove(i);
	}

	private static boolean check(int nr, int nc) {
		if (nr <= 0 || nr > n || nc <= 0 || nc > n || map[nr][nc] == 2)
			return true;
		return false;
	}

	private static int change_dir(int d) {
		if (d == 1)
			return 2;
		if (d == 2)
			return 1;
		if (d == 3)
			return 4;
		return 3;
	}

	private static int get_idx(int r, int c, int num) {
		for (int i = 0; i < a[r][c].size(); i++)
			if (a[r][c].get(i) == num)
				return i;

		return -1;
	}

}
