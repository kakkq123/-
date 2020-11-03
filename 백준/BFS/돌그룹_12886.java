import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int sum = A + B + C;
		if (sum % 3 == 0) {
			//a <= b <= c순으로 정렬
			int a = Math.min(Math.min(A, B), C);
			int c = Math.max(Math.max(A, B), C);
			int b = sum - a - c;
			bfs(a, b, c, sum);
		} else
			System.out.println(0);

	}

	private static void bfs(int a, int b, int c, int sum) {
		boolean[][] visit = new boolean[501][1501];
		visit[a][c] = true;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(a, c));

		while (!q.isEmpty()) {
			int A = q.peek().x, C = q.peek().y, B = sum - A - C;
			q.poll();
			//같은 개수 만들 수 있다면
			if (A == B & B == C) {
				System.out.println(1);
				return;
			}
			int[] _A = { A, A, B }, _C = { B, C, C };
			for (int i = 0; i < 3; i++) {
				int _a = _C[i] - _A[i], _b = _A[i] * 2, _c = sum - _a - _b;
				int min = Math.min(Math.min(_a, _b), _c);
				int max = Math.max(Math.max(_a, _b), _c);
				if (!visit[min][max]) {
					visit[min][max] = true;
					q.add(new Point(min, max));
				}
			}
		}
		System.out.println(0);
	}
}
