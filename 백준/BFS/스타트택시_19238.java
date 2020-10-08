import java.io.*;
import java.util.*;

public class Main {
	static int n, m, fuel, x, y;
	static int[][] road, start, dest;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	static class Cab implements Comparable<Cab> {
		int dis, r, c;

		public Cab(int dis, int r, int c) {
			this.dis = dis;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Cab cab) {
			if (this.dis == cab.dis) {
				if (this.r == cab.r)
					return this.c - cab.c;
				return this.r - cab.r;
			}
			return this.dis - cab.dis;
		}
	}

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		// 길
		road = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				road[i][j] = Integer.parseInt(st.nextToken());
		}
		// 백준이의 시작점
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()) - 1;
		y = Integer.parseInt(st.nextToken()) - 1;

		// 손님 출발지와 목적지
		start = new int[n][n];
		dest = new int[m + 1][2]; // 목적지가 겹치는 경우가 존재해서 이렇게 저장
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			start[x1][y1] = i;
			dest[i][0] = x2;
			dest[i][1] = y2;
		}
		br.close();
		bw.write(solve() + "\n");
		bw.close();

	}

	private static int solve() {
		while (m > 0) {
			Cab cab = find();
			//가장 가까운 손님에게 갈 수 없는 상황
			if (cab == null) 
				return -1;
			//현재 연료로 손님에게 갈 수 있는가
			if (cab.dis <= fuel) {
				fuel -= cab.dis;
				x = cab.r;
				y = cab.c;
				
				cab = go(start[x][y]);
				start[x][y] = 0;
				//손님을 목적지로 데려다 줄 수 있는가
				if (cab == null) 
					return -1;
				//현재 연료로 목적지에 갈 수 있는가
				if (cab.dis <= fuel) {
					fuel += cab.dis;
					x = cab.r;
					y = cab.c;
					m--;
				} else
					return -1;
			} else 
				return -1;
		}
		return fuel;
	}


	private static Cab go(int guest) {
		PriorityQueue<Cab> q = new PriorityQueue<Cab>();
		q.add(new Cab(0, x, y));
		boolean[][] visit = new boolean[n][n];
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Cab cab = q.poll();
			//목적지에 도달
			if (cab.r == dest[guest][0] && cab.c == dest[guest][1])
				return cab;
			for (int d = 0; d < 4; d++) {
				int nx = cab.r + dx[d], ny = cab.c + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (road[nx][ny] == 1 || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				q.add(new Cab(cab.dis + 1, nx, ny));
			}
		}
		return null;
	}

	private static Cab find() {
		PriorityQueue<Cab> q = new PriorityQueue<Cab>();
		q.add(new Cab(0, x, y));
		boolean[][] visit = new boolean[n][n];
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Cab cab = q.poll();
			//손님 찾음
			if (start[cab.r][cab.c] > 0)
				return cab;
			for (int d = 0; d < 4; d++) {
				int nx = cab.r + dx[d], ny = cab.c + dy[d];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (road[nx][ny] == 1 || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				q.add(new Cab(cab.dis + 1, nx, ny));
			}
		}
		return null;
	}

}
