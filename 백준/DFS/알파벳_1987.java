import java.util.*;
import java.io.*;

public class Main {
	static int R, C, max = 1;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static boolean[] a = new boolean[26];
	static char[][] board = new char[20][20];

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++)
				board[i][j] = s.charAt(j);
		}
		a[board[0][0]-'A'] = true;
		dfs(0, 0, 1);

		bw.write(max + "\n");
		br.close();
		bw.close();

	}

	private static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C ||a[board[nr][nc] - 'A'])
				continue;
			a[board[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			a[board[nr][nc] - 'A'] = false;
		}
	}

}
