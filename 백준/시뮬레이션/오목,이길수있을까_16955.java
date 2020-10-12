import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static char[][] board = new char[10][10];
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static Queue<Point> q = new LinkedList<Point>();

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 10; i++) {
			String s = br.readLine();
			for (int j = 0; j < 10; j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'X')
					q.add(new Point(i, j));
			}
		}
		br.close();

		bw.write(solve() + "\n");
		bw.close();
	}

	private static int solve() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 8; d++) {
				int cnt = 0, empty = 0;
				int x = p.x, y = p.y;
				for (int i = 0; i < 5; i++) {
					if (x < 0 || x >= 10 || y < 0 || y >= 10)
						break;
					if (board[x][y] == 'X')
						cnt++;
					if (board[x][y] == '.')
						empty++;
					x += dx[d];
					y += dy[d];
				}
				if (cnt == 4 && empty == 1)
					return 1;
			}
		}
		return 0;
	}

}
