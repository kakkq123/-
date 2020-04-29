import java.io.*;
import java.util.*;

public class 피자굽기_1756_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] _d = new int[D + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= D; i++)
			_d[i] = Integer.parseInt(st.nextToken());

		for (int i = 2; i <= D; i++) {
			_d[i] = Math.min(_d[i - 1], _d[i]);
		}

		int bottom = D + 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			while (bottom != 0) {
				if(_d[--bottom] >= t) {
					break;
				}
			}
		}
		System.out.println(bottom);

	}

}
