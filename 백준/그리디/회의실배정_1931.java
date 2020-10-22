import java.io.*;
import java.util.*;

public class Main {

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[][] a = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());//시작시간
			a[i][1] = Integer.parseInt(st.nextToken());//종료시간
		}
		br.close();

		//종료시간이 빠를수록, 시작 시간이 빠를수록 정렬
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}

		});
		
		int end = a[0][1], cnt = 1;
		for (int i = 1; i < n; i++) {
			//앞의 회의실의 종료시간보다 같거나 늦게 시작한다면 
			if (end <= a[i][0]) {
				end = a[i][1];
				cnt++;
			}
		}
		bw.write(cnt+"\n");
		bw.close();
	}

}
