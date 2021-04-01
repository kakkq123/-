import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		//다리를 건너기 위해 기다리는 트럭들
		Deque<Integer> waiting = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			waiting.add(Integer.parseInt(st.nextToken()));
		br.close();

		//다리
		Deque<Integer> bridge = new LinkedList<Integer>();
		//첫번째 트럭이 다리를 건너고 있음 (초기화)
		int time = 1, sum = waiting.peekFirst();
		for (int i = 1; i < w; i++)
			bridge.add(0);
		bridge.add(waiting.pollFirst());
		
		//시간을 하나씩 증가시키면서, 다리를 건널 수 있는 트럭을 찾음
		while (!waiting.isEmpty()) {
			//맨 앞에 있는 트럭은 다리를 다 건넘
			sum -= bridge.pollFirst();
			
			//다음 트럭이 다리에 올라올 수 있는가?
			if (sum + waiting.peekFirst() <= l) {
				sum += waiting.peekFirst();
				bridge.add(waiting.pollFirst());
			}
			//다음 트럭이 다리에 못올라온다면 0(트럭이 없음을 의미)을 deque에 넣어줌
			else {
				bridge.add(0);
			}
			time++;
		}
		bw.write((time + w) + "");
		bw.close();
	}
}
