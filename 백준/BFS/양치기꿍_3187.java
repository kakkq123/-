import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int R, C, sheep = 0, wolf = 0;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'v')
					wolf++;
				if (map[i][j] == 'k')
					sheep++;
			}
		}
		br.close();

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (!visit[i][j] && map[i][j] != '#')
					bfs(i, j);

		bw.write(sheep + " " + wolf);
		bw.close();
	}

	private static void bfs(int r, int c) {
		int tmp_s = 0, tmp_w = 0;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		visit[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			// 늑대
			if (map[p.x][p.y] == 'v')
				tmp_w++;
			// 양
			if (map[p.x][p.y] == 'k')
				tmp_s++;
			// 칸을 이동하면서 확인
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d], nc = p.y + dc[d];
				// 테두리 벗어나면
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				// 벽이거나 이미 방문했다면
				if (map[nr][nc] == '#' || visit[nr][nc])
					continue;
				visit[nr][nc] = true;
				q.add(new Point(nr, nc));
			}
		}
		// 양의 수가 늑대의 수가 많다면 늑대는 잡아먹힘
		if (tmp_s > tmp_w)
			wolf -= tmp_w;
		// 반대인 경우엔 양이 잡아먹힘
		else
			sheep -= tmp_s;
	}

}
