import java.util.Scanner;
public class trafficar {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String day=kb.next();
		day=day.substring(day.length()-1);
		int n=kb.nextInt();

		int numcar=0;
		String car;
		
		for(int i=0; i<n; i++) {
			car=kb.next();
			car=car.substring(car.length()-1);

			if(car.equals(day))
				numcar++;
			
		}
		
		System.out.printf("%d", numcar);
	}

}
