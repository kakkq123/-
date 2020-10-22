import java.io.*;
import java.util.*;

public class Main {

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];
		for (int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		br.close();
		
		
		int cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (coin[i] <= k) {
				cnt += k / coin[i];
				k %= coin[i];
			}
		}
		
		bw.write(cnt + "\n");
		bw.close();
	}

}
