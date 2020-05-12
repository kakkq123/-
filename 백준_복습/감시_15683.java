import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M, min = 64;
	static int[][] office;
	static int[] dir;
	static ArrayList<Point> a = new ArrayList<Point>();
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 }, r = { 0, 4, 2, 4, 4, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] >= 1 && office[i][j] <= 5)
					a.add(new Point(i, j));
			}
		}
		br.close();
		dir = new int[a.size()];
		dfs(0);
		System.out.println(min);

	}

	private static void fill(int r, int c, int d, int[][] copy) {
		while (r >= 0 && r < N && c >= 0 && c < M && copy[r][c] != 6) {
			copy[r][c] = 9;
			r += dr[d];
			c += dc[d];
		}
	}

	private static void check() {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++)
			System.arraycopy(office[i], 0, copy[i], 0, office[i].length);

		for (int i = 0; i < a.size(); i++) {
			int x = a.get(i).x, y = a.get(i).y;
			int cctv = office[x][y];
			if (cctv == 1) {
				fill(x, y, dir[i], copy);
			} else if (cctv == 2) {
				fill(x, y, dir[i], copy);
				fill(x, y, dir[i] + 2, copy);
			} else if (cctv == 3) {
				fill(x, y, dir[i], copy);
				fill(x, y, (dir[i] + 1) % 4, copy);
			} else if (cctv == 4) {
				fill(x, y, dir[i], copy);
				fill(x, y, (dir[i] + 1) % 4, copy);
				fill(x, y, (dir[i] + 2) % 4, copy);
			} else {
				for (int j = 0; j < 4; j++)
					fill(x, y, j, copy);
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0)
					cnt++;
				if (cnt > min)
					return;
			}
		}
		min = Math.min(min, cnt);
	}

	private static void dfs(int num) {
		if (num == a.size()) {
			check();
			return;
		}
		int cctv = office[a.get(num).x][a.get(num).y];
		for (int i = 0; i < r[cctv]; i++) {
			dir[num] = i;
			dfs(num + 1);
		}
	}

}
