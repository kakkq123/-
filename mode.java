import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		Scanner kb =new Scanner(System.in);
		int test=kb.nextInt(); //테스트 개수
		int score, max, res;
		int[][] mode=new int[test+1][101];

		for(int i=1; i<=test; i++) {
			kb.nextInt(); //
			for(int j=1; j<=1000; j++) { // 1000
				score=kb.nextInt();
				mode[i][score]++;
			}
			
			max=0;
			for(int j=1; j<=100; j++) {  //100
				if(mode[i][j]>=max) {
					max=mode[i][j];
					mode[i][0]=j;
				}
			}
		}//
		
		
		//
		for(int i=1; i<=test; i++)
			System.out.println("#"+i+" "+mode[i][0]);
		

	}

}
