import java.util.*;
import java.io.*;

public class 텀프로젝트_9466_2 {
	static int n;
	static int[] a, cycle, v;
	
	/*
	 * 이 방법이 가장 간단하고 빠를 거라고 생각했는데
	 * 은근 시간 오래걸림
	 * */

	public static int bfs(int start, int number) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a[start]);
		v[start] = 1;
		cycle[start] = number; 

		while (!q.isEmpty()) {
			int cur = q.poll(); 
			// 사이클이 생기면 팀을 이룰 수 있음 -> count해주면 안 됨
			if (cur == start) {
				return 0;
			}
			// 재방문
			if (v[cur] > 0) {
				//같은 그래프에 속한다면 
				if (cycle[cur] == number) {
					return v[cur] - 1;
				}
				//다른 그래프에 접근했을 경우 팀을 이룰 수 없음
				break;
			}
			v[cur] = ++v[start]; // v[start]는 지나고 있는 NODE의 개수를 의미
			cycle[cur] = number; // 같은 그래프라는 것을 표시
			q.add(a[cur]); // 다음 NODE 추가
		}
		return v[start];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int test = 0; test < t; test++) {
			n = Integer.parseInt(br.readLine());
			a = new int[n + 1];
			cycle = new int[n + 1]; // 그래프 구분하기 위한 NUMBER
			v = new int[n + 1]; // visit 처리 + 지나온 NODE 개수를 의미 

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++)
				a[i] = Integer.parseInt(st.nextToken());

			int number = 0, cnt = 0;
			for (int i = 1; i <= n; i++)
				if (v[i] == 0) // 중복 계산 방지 
					cnt += bfs(i, ++number);

			bw.write(cnt + "\n");
			bw.flush();
		}
		br.close();
		bw.close();

	}

}
