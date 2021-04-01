import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		br.close();

		int ans = bfs(f, s, g, u, d);
		if(ans==-1)
			bw.write("use the stairs");
		else
			bw.write(ans+"");
		bw.close();
	}

	private static int bfs(int f, int s, int g, int u, int d) {
		int cnt = 0;
		boolean[] visit = new boolean[f + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visit[s] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				//도착
				if (cur == g)
					return cnt;
				//위로 올라갈 수 있는가? 이미 방문한 곳인가?
				if (cur + u <= f && !visit[cur + u]) {
					q.add(cur + u);
					visit[cur + u] = true;
				}
				//내려 갈 수 있는가? 이미 방문한 곳인가?
				if (cur - d > 0 && !visit[cur - d]) {
					q.add(cur - d);
					visit[cur - d] = true;
				}
			}
			//이동횟수
			cnt++;
		}
		//실패
		return -1;
	}
}
