import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak_3190 {
	static int[][] board;

	static class Condition {
		int time;
		char direction;

		public Condition(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}

	static class Snake {
		int row, col;

		public Snake(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void solve(int n, Queue<Condition> q) {
		Queue<Snake> s = new LinkedList<Snake>();
		s.offer(new Snake(1, 1));
		board[1][1] = 2;
		int row = 1, col = 1, curtime = 0, d = 0;
		int time = q.peek().time;
		char dir = q.peek().direction;
		q.poll();
		while (true) {
			curtime++;
			switch (d) {
			case 0:
				col++;
				break; // 오른쪽
			case 1:
				row++;
				break; // 아래
			case 2:
				col--;
				break; // 왼쪽
			case 3:
				row--;
				break; // 위
			}

			if (row == 0 || col == 0 || col == n + 1 || row == n + 1 || board[row][col] == 2) {
				break;
			}
			// 사과
			if (board[row][col] == 1) {
				board[row][col] = 2; //
				s.offer(new Snake(row, col));
			} else if (board[row][col] == 0) {
				int r = s.peek().row;
				int c = s.peek().col;
				board[r][c] = 0; //
				s.poll();
				board[row][col]=2;
				s.offer(new Snake(row, col));
			}

			if (curtime == time) {
				if (dir == 'L')
					d = (d + 3) % 4;
				else if (dir == 'D')
					d = (d + 5) % 4;
				//
				if (!q.isEmpty()) {
					time = q.peek().time;
					dir = q.peek().direction;
					q.poll();
				}
			}
			
		}//while
		System.out.println(curtime);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		board = new int[n + 2][n + 2];

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1; // apple
		}
		int l = Integer.parseInt(br.readLine());
		Queue<Condition> q = new LinkedList<Condition>();
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			q.offer(new Condition(x, c));
		}
		solve(n, q);
		br.close();
	}

}
