import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 제곱ㄴㄴ수_1016_2 {

	/*
	 * 우선 소수를 찾고 소수 제곱으로 나눠 떨어지는지 체크했지만 메모리측면에서 매우 뒤떨어짐 
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		long cnt = max - min + 1, sqrt = (long) Math.sqrt(max);
		int len = (int) (max - min);
		boolean[] check = new boolean[1000001];
		long[] num = new long[10000001];
		// 1은 소수 -1은 소수가 아님을 의미
		for (long i = 2; i <= sqrt; i++) {
			if (num[(int) i] == 0) {
				num[(int) i] = 1;
				for (long j = i + i; j <= sqrt; j += i) {
					num[(int) j] = -1;
				}
			}
		}
		// 계산
		for (int i = 2; i <= sqrt; i++) {
			if (num[i] > 0) {
				long t = (long) i * (long) i, r = min % t, a = r == 0 ? 0 : (t - r);
				for (long j = a; j <= len; j += t) {
					if ((min + j) % t == 0 && !check[(int) j]) {
						check[(int) j] = true;
						cnt--;
					}
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
