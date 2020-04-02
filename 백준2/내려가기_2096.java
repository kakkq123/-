import java.io.*;
import java.util.*;

public class 내려가기_2096 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n + 1][4];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// MAX
		int[][] max_arr = new int[2][4];
		for (int i = 1; i <= n; i++) {
			max_arr[1][1] = Math.max(max_arr[0][1], max_arr[0][2]) + a[i][1];
			max_arr[1][2] = Math.max(max_arr[0][1], Math.max(max_arr[0][2], max_arr[0][3])) + a[i][2];
			max_arr[1][3] = Math.max(max_arr[0][2], max_arr[0][3]) + a[i][3];

			max_arr[0][1] = max_arr[1][1];
			max_arr[0][2] = max_arr[1][2];
			max_arr[0][3] = max_arr[1][3];
		}
		for (int i = 1; i <= 3; i++)
			max = Math.max(max, max_arr[0][i]);
		// MIN
		int[][] min_arr = new int[2][4];
		for (int i = 1; i <= n; i++) {
			min_arr[1][1] = Math.min(min_arr[0][1], min_arr[0][2]) + a[i][1];
			min_arr[1][2] = Math.min(min_arr[0][1], Math.min(min_arr[0][2], min_arr[0][3])) + a[i][2];
			min_arr[1][3] = Math.min(min_arr[0][2], min_arr[0][3]) + a[i][3];

			min_arr[0][1] = min_arr[1][1];
			min_arr[0][2] = min_arr[1][2];
			min_arr[0][3] = min_arr[1][3];
		}
		for (int i = 1; i <= 3; i++)
			min = Math.min(min, min_arr[0][i]);

		// PRINT
		bw.write(max + " " + min + "\n");
		bw.close();
	}

}
