import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M, total = 0, INF = 2501, MIN = INF;
	static int[][] lab;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static ArrayList<Point> a = new ArrayList<Point>(), v = new ArrayList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2)
					a.add(new Point(i, j));
				if (lab[i][j] == 0) // 빈공간
					total++;
			}
		}
		if (total == 0) {
			MIN = 0;
		} else {
			solve(0, 0);
			MIN = MIN == INF ? -1 : MIN;
		}
		bw.write(MIN + "\n");
		bw.close();
	}

	private static void solve(int idx, int cnt) {
		if (cnt == M) {
			spread();
			return;
		}
		if (cnt >= M)
			return;
		for (int i = idx; i < a.size(); i++) {
			v.add(new Point(a.get(i).x, a.get(i).y));
			solve(i + 1, cnt + 1);
			v.remove(cnt);
		}

	}

	private static void spread() {
		int[][] move = new int[N][N];
		Queue<Point> q = new LinkedList<Point>();
		for (int i = 0; i < N; i++)
			Arrays.fill(move[i], -1);
		for (Point p : v) {
			q.add(new Point(p.x, p.y));
			move[p.x][p.y] = 0;
		}

		int time = 0, cnt = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int r = p.x + dr[d], c = p.y + dc[d];
				if (r < 0 || r >= N || c < 0 || c >= N || move[r][c] != -1 || lab[r][c] == 1)
					continue;
				move[r][c] = move[p.x][p.y] + 1;
				if (lab[r][c] == 0) {
					cnt++;
					time = Math.max(move[r][c], time);
				}
				q.add(new Point(r, c));
			}
		}

		if (cnt == total)
			MIN = Math.min(MIN, time);

	}
}
