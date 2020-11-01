import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long answer = 0;
		PriorityQueue<Integer> q1 = new PriorityQueue<Integer>(); // 음수
		PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(Collections.reverseOrder()); // 양수
		Deque<Integer> q0 = new ArrayDeque<Integer>(); //0

		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(br.readLine());
			if (v < 0)
				q1.add(v);
			else if (v > 0)
				q2.add(v);
			else
				q0.add(0);
		}

		// 음수
		int p1 = 0, p2 = 0;
		while (!q1.isEmpty()) {
			p1 = q1.poll();
			//음수 두개를 곱해줄 수 있다면 곱해줌
			if (!q1.isEmpty()) {
				p2 = q1.poll();
				answer += p1 * p2;
				continue;
			}
			//음수 두개를 곱해줄 수 없을 때
			//0이 있으면 0과 곱해줌
			if (!q0.isEmpty())
				q0.poll();
			else
				answer += p1;
		}

		// 양수
		while (!q2.isEmpty()) {
			p1 = q2.poll();
			
			//곱해줄 수 있는 양수가 없다면 
			if (q2.isEmpty()) {
				answer += p1;
				continue;
			}
			//1과 곱하기 보다는 따로 계산해주는 것이 더 이득
			p2 = q2.poll();
			if (p2 == 1) {
				answer += p1 + p2;
				continue;
			}
			//1 이상의 양수들의 곱
			answer += p1 * p2;

		}

		bw.write(answer + "\n");
		br.close();
		bw.close();
	}
}
