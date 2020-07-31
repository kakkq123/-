import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
	static int R, C;
	static int[][] a;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static Queue<Point> delete;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		a = new int[R + 2][C + 2];
		// input
		int total_cnt = 0;
		for (int r = 1; r <= R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= C; c++) {
				a[r][c] = Integer.parseInt(st.nextToken());
				if (a[r][c] == 1)
					total_cnt++;
			}
		}

		int time = 0, tmp =0;
		while (total_cnt > 0) {
			tmp = total_cnt;
			time++;
			delete = new LinkedList<Point>();
			bfs();
			while (!delete.isEmpty()) {
				Point p = delete.poll();
				a[p.x][p.y] = 0;
				total_cnt--;
			}


		}
		bw.write(time + "\n" + tmp + "\n");
		br.close();
		bw.close();
	}

	private static void bfs() {
		boolean[][] visit = new boolean[R + 2][C + 2];
		visit[0][0] = true;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0));
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.x + dr[d], nc = p.y + dc[d];
				if (nr < 0 || nr >= R + 1 || nc < 0 || nc >= C + 1 || visit[nr][nc])
					continue;
				visit[nr][nc] = true;
				if (a[nr][nc] == 0)
					q.add(new Point(nr, nc));
				else
					delete.add(new Point(nr, nc));
			}
		}
	}

}
