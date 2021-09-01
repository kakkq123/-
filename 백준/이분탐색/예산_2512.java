import java.io.*;
import java.util.*;

public class Main {
	// 예산 2512번
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		br.close();

		Arrays.sort(a); // 오름차순으로 정렬
		int result = 0;
		int left = 0;
		int right = a[n - 1];
		while (left <= right) {
			int mid =(left+right) / 2;  			// 상한액
			int sum = 0;
			for (int i = 0; i < n; i++) {
				//상한액보다 낮으면 정해진 예산을 배정
				if (a[i] <= mid)
					sum += a[i];
				// 상한액보다 높으면 상한액만금 배정
				else
					sum += mid;
			}
			// 총예산과 같다면 stop
			if (sum == m) {
				result = mid;
				break;
			}
			// 총예산보다 많으면 상한액을 올려줌
			if (m > sum) {
				left =  mid + 1;
				result = mid;
			}
			// 총예산보다 적으면 
			else {
				right =  mid  - 1;
			}
		}

		bw.write(result + "");
		bw.close();
	}

}
