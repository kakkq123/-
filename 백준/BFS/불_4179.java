import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static Queue<Point> fire = new LinkedList<Point>(); // 불의 위치를 저장
	static Queue<Point> human = new LinkedList<Point>(); // 지훈의 위치를 저장
	static boolean[][] visit; //지훈이가 방문한 곳을 체크

	static public void main(String args[]) throws Exception {
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
				if (map[i][j] == 'J') {
					visit[i][j] = true;
					map[i][j] = '.';
					human.add(new Point(i, j));
				}
				if (map[i][j] == 'F') {
					fire.add(new Point(i, j));
				}
			}
		}
		br.close();
		int answer = bfs();
		if (answer == -1)
			bw.write("IMPOSSIBLE");
		else
			bw.write(answer + "\n");
		bw.close();
	}

	private static int bfs() {
		int time = 0;
		while (!human.isEmpty()) {
			time++;
			// 불 이동
			int fire_size = fire.size();
			for (int s = 0; s < fire_size; s++) {
				Point p = fire.poll();
				for (int d = 0; d < 4; d++) {
					int x = p.x + dx[d], y = p.y + dy[d];
					if (x < 0 || x >= R || y < 0 || y >= C)
						continue;
					if (map[x][y] == '#' || map[x][y] == 'F')
						continue;
					map[x][y] = 'F';
					fire.add(new Point(x, y));
				}
			}
			// 사람 이동
			int human_size = human.size();
			for (int s = 0; s < human_size; s++) {
				Point p = human.poll();
				for (int d = 0; d < 4; d++) {
					int x = p.x + dx[d], y = p.y + dy[d];
					//밖으로 나올 수 있으면 return
					if (x < 0 || x >= R || y < 0 || y >= C)
						return time;
					//벽이거나 불이 있거나 이미 방문했다면 out
					if (map[x][y] == '#' || map[x][y] == 'F' || visit[x][y])
						continue;
					visit[x][y] = true;
					human.add(new Point(x, y));
				}
			}
		}
		return -1;
	}

}
