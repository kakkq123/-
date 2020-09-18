import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			if (s[0].equals("push")) {
				stack.push(Integer.parseInt(s[1]));
			} else if (s[0].equals("pop")) {
				if (stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
			} else if (s[0].equals("size")) {
				System.out.println(stack.size());
			} else if (s[0].equals("empty")) {
				if (stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (s[0].equals("top")) {
				if (stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
			}
		}
	}

}
