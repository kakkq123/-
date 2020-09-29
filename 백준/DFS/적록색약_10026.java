import java.io.*;

public class Main {
	static int n;
	static char[][] b;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		b = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++)
				b[i][j] = s.charAt(j);
		}
		int[] cnt = new int[2];
		//i == 1은 적록색약 사람이 보는 것
		for (int i = 0; i < 2; i++) {
			visit = new boolean[n][n];
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (!visit[row][col]) {
						visit[row][col] = true;
						dfs(row, col, b[row][col], i);
						cnt[i]++;
					}
				}
			}
		}
		bw.write(cnt[0] + " " + cnt[1]);
		br.close();
		bw.close();

	}

	private static void dfs(int row, int col, char c, int idx) {
		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d], nc = col + dc[d];
			if (nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;
			if (idx == 1 && (c == 'R' || c == 'G')) {
				if (!visit[nr][nc] && (b[nr][nc] == 'R' || b[nr][nc] == 'G')) {
					visit[nr][nc] = true;
					dfs(nr, nc, c, idx);
				}
			} else {
				if (!visit[nr][nc] && b[nr][nc] == c) {
					visit[nr][nc] = true;
					dfs(nr, nc, c, idx);
				}
			}
		}
	}

}
