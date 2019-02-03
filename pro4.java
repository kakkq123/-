import java.util.Scanner;

public class pro4 {
	public static void main(String[] args) {
		int N,num;
		int i, j, min, temp;
		int[] array;
		Scanner kb =new Scanner(System.in);
		do {
			N=kb.nextInt();
		}while(N<1||N>1000);
		
		array = new int[N];
		
		for(i=0;i<N;i++) {
			num=kb.nextInt();
			if(Math.abs(num)>1000)
				continue;
			array[i]=num;
		}
		
		for (i = 0; i < N - 1; i++) {
			min = i;
			for (j = i + 1; j < N; j++)
				if (array[j] < array[min])
					min = j;

			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		
		for(i=0;i<N;i++) {
			System.out.printf("%d\n", array[i]);
		}
		
	}

}
