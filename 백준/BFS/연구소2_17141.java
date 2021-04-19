import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int CNT = 0, Time = 10000;
	static int[][] lab, actVirus;
	static int N, M;
	static ArrayList<Point> virus = new ArrayList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lab = new int[N][N];
		actVirus = new int[M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2)
					virus.add(new Point(i, j));
				if (lab[i][j] == 0)
					CNT++;
			}
		}
		br.close();

		dfs(0, 0);
		if (Time == 10000)
			Time = -1;
		bw.write(Time + "");
		bw.close();
	}

	private static void dfs(int idx, int cnt) {
		if (cnt == M) {
			spreadVirus();
			return;
		}
		if (idx == virus.size())
			return;
		// 바이러스 활성화
		actVirus[cnt][0] = virus.get(idx).x;
		actVirus[cnt][1] = virus.get(idx).y;
		dfs(idx + 1, cnt + 1);
		// 바이러스 비활성화
		dfs(idx + 1, cnt);
	}

	private static void spreadVirus() {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			q.add(new Point(actVirus[i][0], actVirus[i][1]));
			visit[actVirus[i][0]][actVirus[i][1]] = true;
		}

		int time = -1, cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			time++;
			for (int s = 0; s < size; s++) {
				int x = q.peek().x, y = q.peek().y;
				q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (visit[nx][ny] || lab[nx][ny] == 1)
						continue;
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
					if (lab[nx][ny] == 0)
						cnt++;
				}
			}
		}
		if (cnt == CNT)
			Time = Math.min(Time, time);
	}

}
