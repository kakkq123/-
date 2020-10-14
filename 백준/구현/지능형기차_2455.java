import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int cnt = 0, max = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 기차에서 내리는 사람의 수
			int M = Integer.parseInt(st.nextToken()); //가차 타는 사람의 수
			cnt -= N;
			cnt += M;
      //현재 승객이 
			max = Math.max(cnt, max);
		}

		br.close();

		bw.write(max + "\n");
		bw.close();
	}

}
