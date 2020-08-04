import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long answer = 0;
		if (!(n == 1 || n == 2 || n == 4)) {
			int k = n % 2 == 0 ? n / 2 - 1 : n / 2;
			int t = n % 3 == 0 ? n / 3 : n / 3 + 1;

			while (k >= t) {
				int tmp = n - k;
				answer += tmp / 2 - (tmp - k) + 1;
				k--;
			}

		}
		bw.write(answer + "\n");
		br.close();
		bw.close();

	}

}
