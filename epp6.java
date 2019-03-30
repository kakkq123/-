/*
<문자메세지 암호화>
키값(키는 1-7로 구성) 기반으로 문자메세지를 재배열하여 만든다.
문자열의 길이가 7의 배수가 되지 않으면 abcdef순으로 문자열의 길이 7의 배수가 되도록 채운다.
*/

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		String str, k;
		int n = 0;
		
		str = kb.nextLine(); //문자
		k =kb.nextLine();//key
		String[] key =k.split("");
	
		if (str.length() % 7 != 0) {
			n = str.length() % 7;
			n = 7 - n;
		}
		
		switch (n) {
		case 1:
			str += "a";
			break;
		case 2:
			str += "ab";
			break;
		case 3:
			str += "abc";
			break;
		case 4:
			str += "abcd";
			break;
		case 5:
			str += "abcde";
			break;
		case 6:
			str += "abcdef";
			break;
		default:
			break;
		}

		String[] s= str.split("");

		String[] sentence = new String[s.length];
		int si=0;
		
		for(int i=0; i<s.length; i+=7) {
			for(int j=0; j<key.length; j++) {
				int index=Integer.parseInt(key[j]);
				sentence[si]=s[i+index-1];
				si++;
			}			
		}
		
		for(int i=0; i<sentence.length;i++)
			System.out.printf("%s",sentence[i]);
		

	}

}
