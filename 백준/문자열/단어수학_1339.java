import java.io.*;
import java.util.*;

public class Main {
	static int[][] alphabet = new int[26][2];
	static int[] alpha = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];

		for (int i = 0; i < 26; i++)
			alphabet[i][1] = i;

		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
			for (int j = 0; j < str[i].length(); j++) {
				int tmp = str[i].charAt(j) - 'A';
				alphabet[tmp][0] += Math.pow(10, str[i].length() - j); // 자릿수 합을 저장
			}
		}
		//alphabet[tmp][0] 내림차순으로 정렬해줌
		Arrays.sort(alphabet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		//정렬된 배열에 9>8>7.....내림차순으로 값을 부여함
		int digit = 9;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i][0] == 0)
				break;
			alpha[alphabet[i][1]] = digit;
			digit--;
		}
		//덧셈
		long answer = 0;
		for (int i = 0; i < n; i++) {
			int d = 1;
			for (int j = str[i].length() - 1; j >= 0; j--) {
				answer += d * alpha[str[i].charAt(j) - 'A'];
				d *= 10;
			}
		}

		br.close();
		bw.write(answer + "\n");
		bw.close();

	}

}
