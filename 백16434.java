//입력과 출력이 맞는데 틀렸다고 나왔다...

import java.util.*;

public class 백16434 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int Hatk = kb.nextInt();

		int[] t = new int[n];
		int[] a = new int[n];
		int[] h = new int[n];

		for (int i = 0; i < n; i++) {
			t[i] = kb.nextInt(); // 1 또는 2
			a[i] = kb.nextInt();
			h[i] = kb.nextInt();
			if (t[i] == 2)
				Hatk += a[i];
		}

		h[n - 1] -= Hatk;
		int q = h[n - 1] / Hatk;

		if (h[n - 1] % Hatk != 0)
			q++;
		double Hmax_hp = (double) q * a[n - 1] + 1;

		double Hcur_hp = Hmax_hp;

		for (int i = n - 2; i >= 0; i--) {
			if (t[i] == 2) {
				Hatk -= a[i];
				Hcur_hp -= (double) h[i];
			} else {
				h[i] -= Hatk;
				int q_temp = h[i] / Hatk;
				if (h[i] % Hatk != 0)
					q_temp++;
				Hcur_hp = (double) q_temp * a[i] + 1;
				if (Hmax_hp < Hcur_hp)
					Hmax_hp = Hcur_hp;
			}
		}

		System.out.printf("%.0f", Hmax_hp);

	}

}
