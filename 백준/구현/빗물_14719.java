import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer.parseInt(st.nextToken()); // H
		int W = Integer.parseInt(st.nextToken());

		int[] b = new int[W];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++)
			b[i] = Integer.parseInt(st.nextToken());
		br.close();

		int answer = 0;
		for (int i = 0; i < W; i++) {
			boolean flag = false;
			int l = i - 1, r = i + 1;
			
			//***** 왼쪽 확인
			for (; l >= 0; l--) {
				//현재보다 벽의 높이가 같거나 크면 break
				if (b[l] >= b[i]) {
					flag = true;
					break;
				}
			}
			//빗물을 채워줌
			for (int j = l + 1; j < i && flag; j++) {
				answer += b[i] - b[j];
				b[j] = b[i];
			}
			
			//***** 오른쪽 확인
			flag = false;
			for (; r < W; r++) {
				//현재보다 벽의 높이가 같거나 크면 break
				if (b[r] >= b[i]) {
					flag = true;
					break;
				}
			}
			//빗물을 채워줌
			for (int j = i + 1; j < r && flag; j++) {
				answer += b[i] - b[j];
				b[j] = b[i];
			}
		}

		bw.write(answer + "\n");
		bw.close();
	}

}
