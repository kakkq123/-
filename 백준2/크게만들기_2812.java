import java.io.*;
import java.util.*;

public class 크게만들기_2812 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		Deque<Character> q = new LinkedList<Character>();
		for (int index = 0; index < N; index++) {
			char c = s.charAt(index);
			//Deque 마지막 값보다 c가 크다면
			//Deque의 값이 c보다 큰 값이 나올 때까지 pollLast()해준다.
			while (!q.isEmpty() && q.peekLast() < c && K > 0) {
				q.pollLast();
				K--;
			}
			q.addLast(c);
		}
		int size = q.size() - K;
		for (int i = 0; i < size; i++) {
			char c = q.pollFirst();
			bw.write(c + "");
		}

		br.close();
		bw.close();

	}

}
