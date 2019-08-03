import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class baek2164 {

	public static void main(String[] args) {
		Scanner kb =new Scanner(System.in);
		Queue<Integer> q= new LinkedList<>();
		
		int n=kb.nextInt();
				
		for(int i=1; i<=n; i++)
			q.offer(i);
		
		int k=1,tmp;
		
		while(true) {
			if(q.size()==1)
				break;
			if(k%2==1)
				q.poll();
			else {
				tmp=q.poll();
				q.offer(tmp);
			}
			k++;
		}
		
		System.out.println(q.poll());

	}

}
