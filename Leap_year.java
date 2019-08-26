import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Leap_year {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("연도를 양의 정수로 입력하시오 : ");
		int year=Integer.parseInt(br.readLine());
		
		boolean isLeapYear=false;
		
		if(year%4==0 && (year%100!=0 ||year%400==0 ))
			isLeapYear=true;
		
		if(isLeapYear)
			System.out.printf("%d년은 윤년입니다.",year);
		else
			System.out.printf("%d년은 윤년이 아닙니다.",year);
		
		br.close();
	}

}
