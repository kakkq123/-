import java.io.*;
import java.util.*;

public class 수열의합_1024 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		boolean flag = false;
		int mid = 0, low = 0, high = 0;
		for (int l = L; l <= 100; l++) {
			if (N + 1 < l)
				break;
			// L 짝수
			if (l % 2 == 0) {
				int q = N / l, r = N % l;
				if (r == l / 2) {
					low = q - r + 1;
					if (low < 0)
						break;
					high = q + r;
					flag = true;
					break;
				}
			}
			// L 홀수
			else {
				if (N % l == 0) {
					mid = N / l;
					low = mid - l / 2;
					if (low < 0)
						break;
					high = mid + l / 2;
					flag = true;
					break;
				}
			}

		}
		if (flag)
			for (int i = low; i <= high; i++)
				bw.write(i + " ");
		else
			bw.write(-1 + "\n");

		br.close();
		bw.close();
	}

}
