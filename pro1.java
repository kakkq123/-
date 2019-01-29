package 백준;

import java.util.Scanner;

public class pro1 {
	public static void selection_sort(int a[], int N) {
		int i, j, min, temp;
		for (i = 0; i < N - 1; i++) {
			min = i;
			for (j = i + 1; j <N; j++)
				if (a[j] < a[min])
					min = j;

			temp = a[i];
			a[i] = a[min];
			a[min] = temp;

		}
	}

	public static void main(String[] args) {
		int N;
		int[] p;
		int i = 0,j;
		int time = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("사람 수 입력하세요");
		N = scan.nextInt();
		p = new int[N];
		System.out.println("걸리는 시간 입력하세요");
		while (i < N) {
			p[i] = scan.nextInt();
			i++;
		}

		selection_sort(p, N);
		
		for (i = 0; i < p.length; i++)
			System.out.printf("%d ",p[i]);

		for (i = 0; i < p.length; i++)
			for(j=0;j<i+1;j++)
				time += p[j];
		
		System.out.printf("\n\n\n%d",time);
		 	
	}

}
