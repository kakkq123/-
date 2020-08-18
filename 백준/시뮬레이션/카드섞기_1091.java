import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] p = new int[48], s = new int[48], init = new int[48], card = new int[48], copy = new int[48];

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			card[i] = init[i] = i % 3;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			s[i] = Integer.parseInt(st.nextToken());

		bw.write(solve() + "\n");
		br.close();
		bw.close();

	}

	private static int solve() {
		int count = 0;
		while (!check()) {
			count++;
			shuffle();	
			//셔플한 결과가 초기값과 같다면 cycle이 발생한다는 것!
			if (isCycle())
				return -1;
		}
		return count;
	}

	//초기 카드 값과 같은지 확인
	private static boolean isCycle() {
		for (int i = 0; i < n; i++)
			if (init[i] != card[i])
				return false;
		return true;
	}

	//카드섞기
	private static void shuffle() {
		for (int i = 0; i < n; i++)
			copy[i] = card[s[i]];
		for (int i = 0; i < n; i++)
			card[i] = copy[i];
	}

	//현재 카드가 p와 같은 상태인지 확인
	private static boolean check() {
		for (int i = 0; i < n; i++)
			if (p[i] != card[i])
				return false;
		return true;
	}

}
