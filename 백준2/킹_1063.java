import java.util.*;
import java.io.*;

public class 킹_1063 {
	static String[] command = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
	static int[] dr = { 0, 0, -1, 1, 1, 1, -1, -1 }, dc = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int qr, qc, ar, ac;

	public static int search(String s) {
		int index = 0;
		for (int i = 0; i < 8; i++)
			if (command[i].equals(s))
				index = i;
		return index;
	}

	public static boolean range(int r, int c) {
		return r >= 1 && r <= 8 && c >= 1 && c <= 8;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();
		qc = (s.charAt(0) - 'A') + 1;
		qr = s.charAt(1) - '0';

		s = st.nextToken();
		ac = (s.charAt(0) - 'A') + 1;
		ar = s.charAt(1) - '0';

		int num = Integer.parseInt(st.nextToken());

		for (int i = 0; i < num; i++) {
			int c = search(br.readLine());
			if (qr + dr[c] == ar && qc + dc[c] == ac) {
				if (range(ar + dr[c], ac + dc[c])) {
					qr += dr[c];
					qc += dc[c];
					ar += dr[c];
					ac += dc[c];
				}
			} else {
				if (range(qr + dr[c], qc + dc[c])) {
					qr += dr[c];
					qc += dc[c];
				}
			}
		}

		br.close();
		bw.write((char) (qc + 64) + "" + qr + "\n" + (char) (ac + 64) + "" + ar);
		bw.flush();
		bw.close();
	}

}
