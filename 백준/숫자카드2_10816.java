import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] k = new int[20000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			k[num+10000000]++; //음수를 저장하기 위해서 +10000000을 해줌 & 입력과 동시에 개수 
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			bw.write(k[target+10000000]+" ")
		}

		br.close();
		bw.close();
	}


}
