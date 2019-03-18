//백16434.java코드보다 간소화함
import java.util.Scanner;

public class 백16434_1 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int Hatk = kb.nextInt();
		double Hmax_hp=1000000000000.0;
		double Hcur_hp;
		
		for(int i=0 ;i<n; i++) {
			int t=kb.nextInt();
			int a=kb.nextInt();
			int h=kb.nextInt();
			if(t==1) {
				int q=(h-Hatk)/Hatk;
				if((h-Hatk)%Hatk!=0)
					q++;
				Hcur_hp=(double)q*a+1;
				if(Hcur_hp<Hmax_hp)
					Hmax_hp=Hcur_hp;
			}else {
				Hatk+=a;
				Hmax_hp+=h;
			}
		}
		System.out.printf("%.0f",Hmax_hp);
	}

}
