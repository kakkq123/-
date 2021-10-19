import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, S;
	static int[][] map;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { -1, 1, 1, -1 };
	static boolean[][] check;
	static ArrayList<Point> cloud = new ArrayList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cloud.add(new Point(N - 2, 0));
		cloud.add(new Point(N - 2, 1));
		cloud.add(new Point(N - 1, 0));
		cloud.add(new Point(N - 1, 1));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()) - 1;
			S = Integer.parseInt(st.nextToken());

			moveCloud();
			check = new boolean[N][N];
			rain();
			cloud.clear();
			magic();
			makeCloud();

		}

		long sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		bw.write(sum + "\n");
		br.close();
		bw.close();
	}


	private static void magic() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j]) {
					int chk = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || nx >= N || ny < 0 | ny >= N || map[nx][ny] == 0)
							continue;
						chk++;
					}
					map[i][j] += chk;
				}
			}
		}

	}

	private static void makeCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == false && map[i][j] >= 2) {
					cloud.add(new Point(i, j));
					map[i][j] -= 2;
				}
			}
		}
	}

	private static void rain() {
		for (Point p : cloud) {
			map[p.x][p.y]++;
			check[p.x][p.y] = true;
		}

	}

	private static void moveCloud() {
		ArrayList<Point> nextCloud = new ArrayList<Point>();
		for (Point p : cloud) {
			int nx = p.x + (dr[D] * S) % N;
			int ny = p.y + (dc[D] * S) % N;

			if (nx < 0)
				nx += N;
			if (nx >= N)
				nx -= N;
			if (ny < 0)
				ny += N;
			if (ny >= N)
				ny -= N;
			nextCloud.add(new Point(nx, ny));
		}
		cloud.clear();
		cloud = nextCloud;

	}

}
