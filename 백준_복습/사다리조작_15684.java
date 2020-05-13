import java.io.*;
import java.util.*;

public class Main {
	static int C, R, H, min = 4;
	static boolean[][] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		line = new boolean[R + 1][C + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[a][b] = true;
		}
		br.close();
		dfs(1, 1, 0);
		min = min == 4 ? -1 : min;
		System.out.println(min);
	}

	private static void dfs(int r, int c, int cnt) {
		if (cnt >= min)
			return;
		if (check()) {
			min = cnt;
			return;
		}
		if (cnt == 3)
			return;
		for (int i = r; i <= R; i++) {
			int k = r == i ? c : 0;
			for (int j = k; j < C; j++) {
				if (!line[i][j]) {
					line[i][j] = true;
					dfs(i, j, cnt + 1);
					line[i][j] = false;
				}
			}
		}
	}

	private static boolean check() {
		for (int col = 1; col <= C; col++) {
			int c = col;
			for (int r = 1; r <= R; r++) {
				if (line[r][c])
					c++;
				else if (c > 1 && line[r][c - 1])
					c--;
			}
			if (c != col)
				return false;
		}
		return true;
	}

}
