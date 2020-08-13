
import java.io.*;

public class Main {

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n], b = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, a[i]);
		}
		// ***계수정렬*** //
		// 각 원소 개수를 계산
		int[] num = new int[max + 1];
		for (int i = 0; i < n; i++)
			num[a[i]]++;

		// 누적합 계산
		for (int i = 1; i <= max; i++)
			num[i] += num[i - 1];

		for (int i = n - 1; i >= 0; i--)
			b[--num[a[i]]] = a[i];

		for (int i = 0; i < n; i++)
			bw.write(b[i] + "\n");
		br.close();
		bw.close();

	}

}
