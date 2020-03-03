import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 키로거_5397 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			char[] res = new char[s.length()];
			int b = 0;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (c == '<') {
					if (b > 0)
						stack.push(res[--b]);
				} else if (c == '>') {
					if (!stack.isEmpty())
						res[b++] = stack.pop();
				} else if (c == '-') {
					if (j > 0 && b > 0) {
						b--;
					}
				} else {
					res[b++] = c;
				}
			}
			while (!stack.isEmpty()) {
				res[b++] = stack.pop();
			}
			for (int j = 0; j < b; j++)
				bw.write(res[j] + "");
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}

}
