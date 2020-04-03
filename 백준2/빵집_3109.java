import java.io.*;
import java.util.*;
public class 빵집_3109 {
	static int R, C, cnt = 0;
	static char[][] a;
	static int[] dr = { -1, 0, 1 };
	static boolean[][] v;
	static boolean flag;

	public static void dfs(int r, int c) {
		if (c == C - 1) {
			flag = true;
			cnt++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (flag)
				return;
			int nr = r + dr[i], nc = c + 1;
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || v[nr][nc] || a[nr][nc] == 'x')
				continue;
			v[nr][nc] = true;
			dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		a = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++)
				a[i][j] = s.charAt(j);
		}
		br.close();

		v = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}

}
