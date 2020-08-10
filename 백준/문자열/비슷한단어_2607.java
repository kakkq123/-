import java.util.*;
import java.io.*;

public class Main {

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] alphabet = new int[26], alphabet_2;
		String cmp = br.readLine();
		for (int i = 0; i < cmp.length(); i++) {
			alphabet[cmp.charAt(i) - 'A']++;
		}
		
		int answer = 0;
		for (int i = 1; i < n; i++) {
			String str = br.readLine();
			// 문자를 하나 삽입해서 같은 단어를 만들 수 없다면 continue
			if (str.length() < cmp.length() - 1 || str.length() > cmp.length() + 1)
				continue;

			alphabet_2 = new int[26];
			for (int j = 0; j < str.length(); j++) {
				alphabet_2[str.charAt(j) - 'A']++;
			}
			boolean flag = true;
			int cnt = 0;

			for (int j = 0; j < 26; j++) {
				if (alphabet[j] == alphabet_2[j])
					continue;
				else {
					if (Math.abs(alphabet[j] - alphabet_2[j]) == 1) {
						if (cnt > 1) {
							flag = false;
							break;
						}
						cnt++;
					} else {
						flag = false;
						break;
					}
				}
			}

			if (cmp.length() == str.length()) {
				if (flag && cnt <= 2)
					answer++;
			} else {
				if (flag && cnt < 2)
					answer++;
			}
		}
		bw.write(answer + "\n");
		br.close();
		bw.close();

	}

}
