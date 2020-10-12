import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static char[][] map = new char[8][8];
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static Queue<Point> character = new LinkedList<Point>(); // 캐릭터 위치를 저장
	static boolean[][][] visit = new boolean[8][8][65]; // 캐릭터가 방문한 곳을 체크

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++)
				map[i][j] = s.charAt(j);
		}
		br.close();
		
		character.add(new Point(7, 0));
		visit[7][0][0] = true;

		bw.write(bfs() + "\n");
		bw.close();
	}

	private static int bfs() {
		int time = 0;
		while (!character.isEmpty()) {
			time++;
			int size = character.size();
			//캐릭터 이동
			for (int s = 0; s < size; s++) {
				Point p = character.poll();
				//벽과 만난다면 out
				if (map[p.x][p.y] == '#')
					continue;
				//출구
				if (p.x == 0 && p.y == 7)
					return 1;
				//9가지 방향으로 이동
				for (int d = 0; d < 9; d++) {
					int x = p.x + dx[d], y = p.y + dy[d];
					if (x < 0 || x > 7 || y < 0 || y > 7)
						continue;
					//이미 방문한 곳이거나 빈칸이 아니라면
					if (visit[x][y][time] || map[x][y] != '.')
						continue;
					visit[x][y][time] = true;
					character.add(new Point(x, y));
				}
			}
			move_wall();
		}

		return 0;
	}

	private static void move_wall() {
		for (int r = 7; r > 0; r--)
			for (int c = 0; c < 8; c++)
				map[r][c] = map[r - 1][c];
		for (int c = 0; c < 8; c++)
			map[0][c] = '.';
	}

}
