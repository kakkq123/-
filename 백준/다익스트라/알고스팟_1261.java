import java.io.*;
import java.util.*;

public class Main {
	static int n, m, INF = 20000;
	static int[][] a = new int[100][100], d = new int[100][100];
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	static class Pos implements Comparable<Pos> {
		int x, y, cnt;

		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos p) {
			return this.cnt - p.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j)-'0';
			}
		}
		dijkstra();

		bw.write(d[n - 1][m - 1] + "\n");
		br.close();
		bw.close();
	}

	public static void dijkstra() {
		
		for (int i = 0; i < n; i++)
			Arrays.fill(d[i], INF);
		
		d[0][0] = 0;
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		q.add(new Pos(0, 0, 0));
		
		while (!q.isEmpty()) {
			int x = q.peek().x, y = q.peek().y, cnt = q.peek().cnt;
			q.poll();
			if(x==n-1 && y==m-1)
				return;
			if (d[x][y] > cnt)
				continue;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k], ny = y + dy[k];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (d[nx][ny] > cnt + a[nx][ny]) {
					d[nx][ny] = cnt + a[nx][ny];
					q.add(new Pos(nx, ny, d[nx][ny]));
				}
			}
		}
	}

}
