import java.io.*;
import java.util.*;

public class K진트리_11812 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
			long dis = 0;
			if (K == 1) {
				dis = Math.abs(a - b);
			} else {
				long a_parent = a, b_parent = b;
				while (a_parent != b_parent) {
					if (a_parent > b_parent)
						a_parent = (a_parent + K - 2) / K;
					else
						b_parent = (b_parent + K - 2) / K;
					dis++;
				}
			}
			bw.write(dis + "\n");
		}
		bw.close();
	}

}
