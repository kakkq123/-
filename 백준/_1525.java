import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1525 {

	public static void bfs(int a) {
		int cnt = 0;
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
		HashSet<Integer> hs = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int p = q.poll();
				if (p == 123456789) {
					System.out.println(cnt);
					return;
				}
				char[] ca = Integer.toString(p).toCharArray();
				int index = 0;
				for (int i = 0; i < 9; i++) {
					if (ca[i] == '9') {
						index = i;
						break;
					}
				}
				int r = index / 3, c = index % 3;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i], nc = c + dc[i];
					if (nr < 0 || nr >= 3 || nc < 0 || nc >= 3)
						continue;
					int t = nr * 3 + nc;
					int b = 0;
					for (int j = 0; j < 9; j++) {
						if (j == index)
							b = b*10 + (ca[t]-'0');
						else if (j == t)
							b = b*10 + 9;
						else
							b = b*10 + (ca[j]-'0');
					}
					if (hs.contains(b))
						continue;
					hs.add(b);
					q.add(b);
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int b = 0;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 0)
					a = 9;
				b = b * 10 + a;
			}
		}
		bfs(b);
		br.close();
	}

}
