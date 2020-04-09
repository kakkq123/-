import java.util.*;
import java.io.*;

public class 균형잡힌세상_4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			Stack<Character> stack = new Stack<Character>();
			String s = br.readLine();
			boolean flag = true;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (i == 0 && c == '.') {
					br.close();
					bw.close();
					return;
				}
				if (c == '[' || c == '(')
					stack.add(c);
				else if (c == ']' || c == ')') {
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					char comp = stack.pop();
					if (c == ']') {
						if (comp != '[') {
							flag = false;
							break;
						}
					} else {
						if (comp != '(') {
							flag = false;
							break;
						}
					}
				}
			}
			if (flag && stack.isEmpty())
				bw.write("yes\n");
			else
				bw.write("no\n");
		}
	}

}
