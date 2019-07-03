import java.util.Scanner;
public class ant {

	public static int[] check(int[][] array, int num) {
		//사용자는 1번 위치에 있다는 가정
		int i,j;
		int[] ans =new int[2];
		for(i=0;i<5;i++) {
			for(j=0;j<5;j++) {
				if(num==array[i][j]) {
					ans[0]=j+1; //가로 칸수
					ans[1]=5-i; //세로 칸수
					return ans; 
				}
			}
		}
		return ans; //없으면 0
	}
	public static void main(String[] args) {
		Scanner kb =new Scanner(System.in);
		int a;
		int[][] chess = {{25,24,23,22,21},
						{10,11,12,13,20},
						{9,8,7,14,19},
						{2,3,6,15,18},
						{1,4,5,16,17}};
		
		System.out.println("입력 받을 개수");
		int k =kb.nextInt();
		int[][] res=new int[k][2]; //가로,세로 칸수 출력할 배열
		
		System.out.printf("체스 번호 %d개 입력하세요\n",k);
		for(int i=0; i<k; i++) {
			a=kb.nextInt(); //체스판 번호 입력
			res[i]=check(chess,a); // 체스판 번호에 도달하기 위한 가로, 세로 칸수
			
		}

		//출력
		System.out.println("\n***결과***");
		for(int i=0; i<k; i++) 
			System.out.printf("%d %d \n", res[i][0],res[i][1]);
		
	}

}
