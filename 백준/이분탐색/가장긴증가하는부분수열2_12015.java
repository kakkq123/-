import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> a = new ArrayList<Integer>();

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			//첫 원소이거나, 마지막 숫자보다 크다면 뒤에 추가
			if (a.size() == 0 || a.get(a.size() - 1) < k)
				a.add(k);
			//그렇지 않는다면 k에 맞는 위치에 arraylist에 넣어줌
			else {
				int idx = lower_bound(k);
				a.set(idx, k);
			}
			
		}
		bw.write(a.size()+"\n");
		br.close();
		bw.close();
	}

	private static int lower_bound(int k) {
		int front = 0;
		int rear = a.size() - 1;
		while (front < rear) {
			int mid = (front + rear) / 2;
			if (a.get(mid) < k)
				front = mid + 1;
			else
				rear = mid;
		}
		return rear;
	}

}
