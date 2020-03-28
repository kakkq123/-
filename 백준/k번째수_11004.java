import java.io.*;
import java.util.*;

public class k번째수_11004 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> a = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		br.close();
		Collections.sort(a);
		System.out.println(a.get(K - 1));
	}

}
