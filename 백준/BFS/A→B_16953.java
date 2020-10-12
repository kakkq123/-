import java.io.*;
import java.util.*;

public class Main {
	static long A, B;

	static class Count {
		long num;
		int cnt;

		public Count(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

	}

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		br.close();

		bw.write(bfs() + "\n");
		bw.close();
	}

	private static int bfs() {
		Queue<Count> q = new LinkedList<Count>();
		q.add(new Count(A, 1));

		while (!q.isEmpty()) {
			Count c = q.poll();
			//목표값이면 return
			if (c.num == B)
				return c.cnt;
			//B보다 커지면 더 이상 연산할 필요가 없음
			if (c.num > B)
				continue;
			//두배 해주기
			q.add(new Count(c.num * 2, c.cnt + 1));
			//뒤에 1붙이기
			q.add(new Count(c.num * 10 + 1, c.cnt + 1));
		}
		return -1;
	}

}
