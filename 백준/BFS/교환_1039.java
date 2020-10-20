import java.io.*;
import java.util.*;

public class Main {
	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();
		int n = Integer.parseInt(s);
		int k = Integer.parseInt(st.nextToken());

		br.close();

		bw.write((bfs(n, k, s.length())) + "\n");
		bw.close();
	}

	private static int bfs(int n, int k, int len) {
		boolean[][] visit = new boolean[1000001][k + 1];
		visit[n][0] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		int move_cnt = 0;

		while (!q.isEmpty()) {
			if (move_cnt == k)
				break;
			move_cnt++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int num = q.poll();
				
				for (int i = 0; i < len; i++) {
					for (int j = i + 1; j < len; j++) {
						int tmp = swap(num, i, j);
						if (tmp == -1)
							continue;
						if (visit[tmp][move_cnt])
							continue;
						visit[tmp][move_cnt] = true;
						q.add(tmp);
					}
				}
				
			}
		}

		if (move_cnt == k && !q.isEmpty()) {
			int max = 0;
			while (!q.isEmpty())
				max = Math.max(max, q.poll());
			return max;
		}
		return -1;
	}

	private static int swap(int num, int i, int j) {

		StringBuilder s = new StringBuilder(Integer.toString(num));
		char c1 = s.charAt(i), c2 = s.charAt(j);
		s.setCharAt(i, c2);
		s.setCharAt(j, c1);

		if (s.charAt(0) == '0')
			return -1;
		return Integer.parseInt(s.toString());
	}
}
