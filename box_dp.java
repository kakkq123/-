import java.util.Scanner;
public class box_dp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int num= kb.nextInt();
		int[] box=new int[num];
		int[] dp=new int[num];
		int max=1;
		
		for(int i=0; i<num; i++) {
			box[i]=kb.nextInt();
			dp[i]=1;
		}
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(box[i]>box[j] && dp[i]< dp[j]+1)
					dp[i]=dp[j]+1;
			}
				if(max<dp[i])
					max=dp[i];
		}
		
		System.out.printf("%d",max);
		
	}

}
