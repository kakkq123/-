import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] a = new int[15][15];
		for (int i = 1; i <= 14; i++)
			a[0][i] = i;

		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				a[i][j] = a[i][j - 1] + a[i - 1][j];
			}
		}

		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			int k = Integer.parseInt(br.readLine()); // 층
			int n = Integer.parseInt(br.readLine()); // 호
			bw.write(a[k][n]+"\n");
		}
		br.close();
		bw.close();
	}

}
