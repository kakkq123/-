import java.util.*;
import java.io.*;
import java.awt.Point;

public class 뱀_3190 {
	static class Command {
		int time;
		char dir;

		public Command(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}

	public static int revolve(int d, char c) {
		// 오른쪽
		if (c == 'D') {
			if (d == 0)
				return 3;
			if (d == 1)
				return 2;
			if (d == 2)
				return 0;
			else
				return 1;
		} // 왼쪽
		else {
			if (d == 0)
				return 2;
			if (d == 1)
				return 3;
			if (d == 2)
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[N + 1][N + 1];
		Deque<Point> snake = new LinkedList<Point>();
		Queue<Command> list = new LinkedList<Command>();
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x][y] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			list.add(new Command(x, c));
		}
		int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
		int time = 1, d = 3;
		snake.add(new Point(1, 1));
		a[1][1] = 2;
		while (true) {
			Point p = snake.peek();
			int nx = p.x + dr[d], ny = p.y + dc[d];
			//System.out.printf("(%d,%d) + %d\n" , nx, ny, a[nx][ny]);
			if (nx < 1 || nx > N || ny < 1 || ny > N || a[nx][ny] == 2) {
				break;
			}
			if (a[nx][ny] == 1)
				a[nx][ny] = 0;
			else {
				a[snake.peekLast().x][snake.peekLast().y] = 0;
				snake.pollLast();
			}
			snake.addFirst(new Point(nx, ny));
			a[nx][ny] = 2;
			if (!list.isEmpty()) {
				int t = list.peek().time;
				if (t == time) {
					Command c = list.poll();
					d = revolve(d, c.dir);
				}
			}
			time++;

		}
		System.out.println(time);
	}

}
