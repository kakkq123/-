import java.util.*;
import java.io.*;

public class 해킹_10282 {
	/*
	 * 지역변수로 사용하는 것보다 전역변수로 사용하는 것이 메모리,시간 효율성 측면에서 더 좋다
	 * TEST를 여러번 실행할수록 지역변수를 생성하는 빈도가 늘어나 시간이 더 오래걸리는 것 같다.
	 * */
	static int n, d, c;
	static ArrayList<Conn>[] computer;

	static class Conn implements Comparable<Conn> {
		int next, time;

		public Conn(int next, int time) {
			this.next = next;
			this.time = time;
		}

		@Override
		public int compareTo(Conn c) {
			return this.time < c.time ? -1 : 1;
		}
	}

	public static int[] solve() {
		/*
		 * 다익스트라알고리즘을 사용하여 최단시간을 모두 구함
		 * */
		int INF = 1000000000; //INF값이 충분히 커야한다. 10000으로 했다가 50%에서 틀림

		int[] t = new int[n + 1];
		Arrays.fill(t, INF);
		t[c] = 0;

		PriorityQueue<Conn> q = new PriorityQueue<Conn>();
		q.add(new Conn(c, 0));

		while (!q.isEmpty()) {
			int cur = q.peek().next, time = q.peek().time;
			q.poll();
			if (t[cur] > time)
				continue;
			for (Conn c : computer[cur]) {
				int next = c.next, next_time = time + c.time;
				if (t[next] > next_time) {
					t[next] = next_time;
					q.add(new Conn(next, next_time));
				}
			}
		}
		
		/*
		 * c에서부터 시작하여 가장 마지막 컴퓨터에 도착한 시간을 구하기 위해서는
		 * 가장 큰 값을 가지는 최단시간을 구해야한다.
		 * t[i]의 값이 INF가 아니면 count해준다.
		 * */

		int min_time = 0, cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (t[i] == INF)
				continue;
			cnt++;
			min_time = Math.max(min_time, t[i]);
		}

		return new int[] { cnt, min_time };
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(br.readLine());
		for (int t = 0; t < test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			d = Integer.parseInt(st.nextToken()); // 의존성 개수
			c = Integer.parseInt(st.nextToken()); // 해킹당한 번호

			computer = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				computer[i] = new ArrayList<Conn>();
			}
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
						c = Integer.parseInt(st.nextToken());
				computer[b].add(new Conn(a, c));
			}
			int[] res = solve();
			bw.write(res[0] + " " + res[1] + "\n"); //여러번 출려할 때는 BufferedWriter를 상용하는 것이 훨 빠르다
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
