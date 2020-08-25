import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		boolean[] visit = new boolean[4000001]; // 만들 수 있는 숫자면 true
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		br.close();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// a[i]이전의 값들로 a[i]를 만들 수 있으면 break;
				if (visit[a[i] - a[j] + 200000]) {
					answer++;
					break;
				}
			}
			// i번 째 숫자로 만들 수 있는 값들 계산해놓음
			for (int j = 0; j <= i; j++)
				visit[a[i] + a[j] + 200000] = true;
		}
		bw.write(answer + "\n");
		bw.close();
	}

}
