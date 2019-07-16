import java.util.Scanner;
public class baek10828 {

	static int index=-1;
	static int[] stack=new int[10000];
	
	public static void push(int n) {
		index++;
		stack[index]=n;
	}
	
	public static int pop() {
		if(index<0) {
			System.out.println("-1");
			return 0;
		}
		System.out.printf("%d\n", stack[index]);
		index--;
		return 1;
	}
	
	public static void isEmpty() {
		if(index>=0)
			System.out.println("0");
		else
			System.out.println("-1");
	}
	
	public static void top() {
		if(index<0)
			System.out.println("-1");
		else
			System.out.printf("%d\n", stack[index]);

	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String[] s;

		
		for(int i=0; i<=n; i++) {
			s=kb.nextLine().split(" ");
			if(s[0].equals("push"))
				push(Integer.parseInt(s[1]));
			else if(s[0].equals("top"))
				top();
			else if(s[0].equals("size"))
				System.out.printf("%d\n", index+1);
			else if(s[0].equals("empty"))
				isEmpty();
			else if(s[0].equals("pop"))
				pop();

		}
		
	}

}
