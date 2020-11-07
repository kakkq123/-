import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for (int i = 0; i < M; i++)
				br.readLine();
			/*
			 * 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행하려고 한다
			 * 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도)되므로 항상 N - 1이 된다
			 */
			bw.write(N - 1 + "\n");

		}
		br.close();
		bw.close();

	}

}
