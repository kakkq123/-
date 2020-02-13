import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양팔저울_2629 {
	static int n;
	static int[] a;
	static boolean[][] visit;

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int index = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int value = q.poll();
				if (visit[index][value])
					continue;
				visit[index][value] = true;
				if (index == n)
					continue;
				q.add(value + a[index]);
				q.add(value);
				q.add(Math.abs(value - a[index]));
			}
			index++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		visit = new boolean[n + 1][40001];
		for (int i = 0; i < m; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			bfs();
			if (visit[n][tmp])
				System.out.printf("Y ");
			else
				System.out.printf("N ");
		}
		br.close();
	}

}
