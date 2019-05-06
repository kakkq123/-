//n*m의 타일 테두리를 p*1타일로 덮을 때 가능한 p값을 모두 출력

import java.util.Scanner;

public class tile {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int i, left, max_p,p=1;;
		int n = kb.nextInt(); // 가로
		int m = kb.nextInt(); // 세로

		//만약 세로가 가로보다 길다면 바꿔줌
		if(m>n){
			int temp=n;
			n=m;
			m=temp;
		}
		max_p=m-2;
		
		while (p<=max_p) {
			// 가로 왼->오
			i = n % p;
			if (i == 0)
				left = 1;
			else if (i == 1)
				left = 0;
			else {
				p++;
				continue;
			}

			// 세로 위->아래
			i = (m - left) % p;
			if (i == 0)
				left = 1;
			else if (i == 1)
				left = 0;
			else {
				p++;
				continue;
			}
			// 가로 오->왼
			i = (n-left) % p;
			if (i == 0)
				left = 1;
			else if (i == 1)
				left = 0;
			else {
				p++;
				continue;
			}

			// 세로 아래->위
			i = (m - left - 1) % p;
			if (i == 0)
				System.out.printf("%d ", p);

			p++;

		} 

	}

}
