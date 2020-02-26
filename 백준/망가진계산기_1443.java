import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class 망가진계산기_1443 {
	static long max = 1;
	static int d, p;

	public static void bfs() {
		Queue<Long> q = new LinkedList<Long>();
		q.add((long) 1); 
		int n = 0; // 계산 횟수
		while (!q.isEmpty()) {
			int size = q.size();
			//HashSet에는 n번째 연산했을 때 나오는 값들을 저장함
			// 2*4,4*2 또는 4*4 또는 2*8과 같이 같은 값이 저장되는 것을 방지하기 위함
			HashSet<Long> h = new HashSet<Long>();
			for (int i = 0; i < size; i++) {
				long v = q.poll();
				//p만큼 연산을 하였다면 MAX의 값을 구함
				if (n == p) {
					max = Math.max(v, max);
					continue;
				}
				for (int j = 9; j >= 2; j--) {
					long value = v * j;
					//계산기가 나타낼 수 있는 길이보다 길거나 이미 저장된 값이면 Continue
					if ((long) (Math.log10(value) + 1) > d || h.contains(value))
						continue;
					h.add(value);
					q.add(value);
				}
			}
			n++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//D가 P보다 크거나 같다면 결과값은 Math.pow(9,p)이다
		if (d >= p) {
			for (int i = 1; i <= p; i++)
				max *= 9;
		} 
		// D보다 P가 큰 경우 bfs()함수를 호출하여 최댓값을 구한다.
		else {
			bfs();
			max = max == 1 ? -1 : max;
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
