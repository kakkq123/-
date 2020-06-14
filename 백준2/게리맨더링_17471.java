import java.io.*;
import java.util.*;

public class 게리맨더링_17471 {
	static int N, INF = 2000000, ans = INF;
	static boolean[][] a = new boolean[11][11];
	static int[] p = new int[11];
	static boolean[] t = new boolean[11];
	static ArrayList<Integer> team1 = new ArrayList<Integer>();
	static ArrayList<Integer> team2 = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, t;

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			p[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				t = Integer.parseInt(st.nextToken());
				a[t][i] = a[i][t] = true;
			}
		}
		br.close();
		divide(1);
		ans = ans == INF ? -1 : ans;
		bw.write(ans + "\n");
		bw.close();

	}

	private static void divide(int num) {
		if (num == N + 1) {
			if (team1.size() == 0 || team2.size() == 0)
				return;
			if (!check())
				return;
			int sum1 = 0, sum2 = 0;
			
			for (int next : team1) {
				sum1 += p[next];
			}
			for (int next : team2) {
				sum2 += p[next];
			}
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			return;
		}
		t[num] = true;
		team1.add(num);
		divide(num + 1);
		team1.remove(team1.size() - 1);

		t[num] = false;
		team2.add(num);
		divide(num + 1);
		team2.remove(team2.size() - 1);
	}

	private static boolean check() {
		boolean flag1 = false, flag2 = false;
		int cnt = 1;
		boolean[] v = new boolean[N + 1];
		// team1
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(team1.get(0));
		v[team1.get(0)] = true;

		while (!q.isEmpty()) {
			int next = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!v[i] && a[next][i] && t[i]) {
					cnt++;
					v[i] = true;
					q.add(i);
				}
			}
		}
		if (cnt == team1.size())
			flag1 = true;

		// team2
		q = new LinkedList<Integer>();
		q.add(team2.get(0));
		v[team2.get(0)] = true;
		cnt = 1;
		
		while (!q.isEmpty()) {
			int next = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!v[i] && a[next][i] && !t[i]) {
					cnt++;
					v[i] = true;
					q.add(i);
				}
			}
		}
		if (cnt == team2.size())
			flag2 = true;

		// check
		if (flag1 && flag2)
			return true;
		return false;
	}

}
