import java.util.*;
import java.io.*;

public class Main {

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

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j)-'0';
			}
		}
		bw.write(bfs(n,m,board) + "\n");
		br.close();
		bw.close();

	}

	private static int bfs(int n , int m, int[][] board) {
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		q.add(new Pos(0, 0, 1));
		boolean[][] visit = new boolean[n][m];
		visit[0][0] = true;
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			if (p.x == n - 1 && p.y == m - 1)
				return p.cnt;
			for (int d = 0; d < 4; d++) {
				int x = p.x + dx[d], y = p.y + dy[d];
				if (x < 0 || x >= n || y < 0 || y >= m || visit[x][y])
					continue;
				visit[x][y] = true;
				if (board[x][y] == 1) 
					q.add(new Pos(x, y, p.cnt + 1));
			}
		}
		return 0;
	}

}
