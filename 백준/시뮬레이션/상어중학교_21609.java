import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int CNT, RAINBOW, R, C;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] block;
	static boolean[][] visited, check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		block = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int score = solve();
		bw.write(score + "\n");
		br.close();
		bw.close();
	}

	private static int solve() {
		int score = 0;
		while (true) {
			init();
			check = new boolean[N][N];
			for (int r = 0; r < N; r++)
				for (int c = 0; c < N; c++) {
					if (block[r][c] > 0 && check[r][c] == false) {
						visited = new boolean[N][N];
						searchBlock(r, c);
					}
				}

			if (CNT == 0)
				break;

			score += CNT * CNT;
			removeBlock(R, C, block[R][C]);
			DownBlock();
			rotateBlock90();
			DownBlock();
		}
		return score;
	}

	private static void init() {
		CNT = 0;
		RAINBOW = 0;
		R = N;
		C = N;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				System.out.printf("%d ", block[i][j]);
			}
		}
		System.out.println();
	}

	private static void removeBlock(int r, int c, int num) {
		block[r][c] = -2;

		for (int d = 0; d < 4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || block[nr][nc] == -2 || block[nr][nc] == -1)
				continue;
			if (block[nr][nc] > 0 && block[nr][nc] != num)
				continue;
			removeBlock(nr, nc, num);
		}

	}

	private static void rotateBlock90() {
		int len = N, r = 0, c = 0;
		for (int k = len; k > 0; k -= 2, r += 1, c += 1) {
			rotate(r, c, k);
		}
	}

	private static void rotate(int r, int c, int k) {
		int[][] tmp = new int[4][k];
		for (int i = 0; i < k; i++)
			tmp[0][i] = block[r][c + i];
		for (int i = 0; i < k; i++)
			tmp[1][i] = block[r + i][c + k - 1];
		for (int i = 0; i < k; i++)
			tmp[2][i] = block[r + k - 1][c + i];
		for (int i = 0; i < k; i++)
			tmp[3][i] = block[r + i][c];

		for (int i = 0; i < k; i++)
			block[r][c + i] = tmp[1][i];
		for (int i = 0; i < k; i++)
			block[r + i][c + k - 1] = tmp[2][k - 1 - i];
		for (int i = 0; i < k; i++)
			block[r + k - 1][c + i] = tmp[3][i];
		for (int i = 0; i < k; i++)
			block[r + i][c] = tmp[0][k - 1 - i];

	}

	private static void DownBlock() {
		for (int c = 0; c < N; c++) {
			for (int r = N - 2; r >= 0; r--) {
				if (block[r][c] > -1) {
					int tr = r;
					while (tr + 1 < N && block[tr + 1][c] != -1 && block[tr + 1][c] == -2) {
						block[tr + 1][c] = block[tr][c];
						block[tr][c] = -2;
						tr++;
					}

				} // end of if
			}
		}
	}

	private static void searchBlock(int r, int c) {
		int cnt = 0, num = block[r][c], rainbow = 0, _R = r, _C = c;
		visited[r][c] = true;
		check[r][c] = true;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));

		while (!q.isEmpty()) {
			int x = q.peek().x, y = q.peek().y;
			cnt++;
			q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				// 범위 밖
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				// 이미 방문, 블록이 아닌 것, 검정블록인 것
				if (visited[nx][ny] || block[nx][ny] == -2 || block[nx][ny] == -1)
					continue;
				// 다른 일반블록이면
				if (block[nx][ny] > 0 && block[nx][ny] != num)
					continue;
				// 무지개
				if (block[nx][ny] == 0)
					rainbow++;
				//
				if (block[nx][ny] > 0) {
					if (nx < r) {
						_R = nx;
						_C = ny;
					} else if (nx == r && ny < c) {
						_R = nx;
						_C = ny;
					}
					check[nx][ny] = true;
				}
				visited[nx][ny] = true;
				q.add(new Point(nx, ny));

			}
		}
		//
		if (cnt >= 2) {
			if(cnt > CNT) {
				CNT = cnt;
				RAINBOW = rainbow;
				R = _R;
				C = _C;
			}else if(CNT == cnt && RAINBOW < rainbow) {
				CNT = cnt;
				RAINBOW = rainbow;
				R = _R;
				C = _C;
			}else if(CNT == cnt && RAINBOW == rainbow  && R < _R) {
				CNT = cnt;
				RAINBOW = rainbow;
				R = _R;
				C = _C;
			}else if(CNT == cnt && RAINBOW == rainbow  && R == _R) {
				CNT = cnt;
				RAINBOW = rainbow;
				R = _R;
				C = _C;
			}
		}
	}
}
