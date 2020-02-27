import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Á¦°ö¤¤¤¤¼ö_1016 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		long cnt = max - min + 1, sqrt = (long) Math.sqrt(max), len = (max - min);
		boolean[] check = new boolean[1000001];

		// °è»ê
		for (int i = 2; i <= sqrt; i++) {
			long t = (long) i * (long) i, r = min % t, a = r == 0 ? 0 : (t - r);
			for (long j = a; j <= len; j += t) {
				if ((min + j) % t == 0 && !check[(int) j]) {
					check[(int) j] = true;
					cnt--;
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
