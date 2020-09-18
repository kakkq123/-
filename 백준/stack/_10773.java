/*
0을 입력받으면 pop
0이 아닌 정수는 stack에 push한다.
입력이 끝나면 stack에 존재하는 모든 정수의 합을 더하여 출력한다.
*/
import java.util.Scanner;

public class _10773 {
	static int index = -1;
	static int[] stack = new int[100000];
	static int sum=0;
	public static void pop() {
		sum-=stack[index];
		index--;
	}

	public static void push(int n) {
		index++;
		stack[index] = n;
		sum+=stack[index];
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int k = kb.nextInt();
		int n;
		for (int i = 0; i < k; i++) {
			n = kb.nextInt();
			if (n == 0)
				pop();
			else
				push(n);
		}


		System.out.printf("%d", sum);
	}

}
