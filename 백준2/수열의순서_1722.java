import java.io.*;
import java.util.*;

public class 수열의순서_1722 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cmd = Integer.parseInt(st.nextToken());

		long cnt = 1;
		for (int i = 1; i < N; i++)
			cnt *= i;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i <= N; i++)
			list.add(i);

		if (cmd == 1) {
			long k = Long.parseLong(st.nextToken());
			int len = N - 1;
			while (len >= 0) {
				if (k == 0 || len == 0) {
					for (int i = list.size() - 1; i > 0; i--)
						bw.write(list.get(i) + " ");
					break;
				}
				int f = (int) ((k - 1) / cnt) + 1;
				bw.write(list.get(f) + " ");
				list.remove(f);
				k = k % cnt;
				cnt /= len;
				len--;
			}
		} else {
			long k = 1, r = N - 1;
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (r == 0)
					break;
				int index = -1;
				for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
					int tmp = iter.next();
					if (tmp == num) {
						iter.remove();
						break;
					}
					index++;
				}
				k += cnt * index;
				cnt /= r;
				r--;
			}
			bw.write(k + "\n");
		}
		br.close();
		bw.close();
	}

}
