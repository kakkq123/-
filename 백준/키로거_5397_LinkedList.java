import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

//LinkedList를 사용하면 데이터 삭제, 이동, 추가가 편하다
//또한, 배열을 가지고 알고리즘을 설계하는 것보다 메모리도 절약되고 속도도 빠르다

public class 키로거_5397_LinkedList {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			LinkedList<Character> list = new LinkedList<Character>();
			ListIterator iter = list.listIterator();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (c == '<') {
					// 삭커서를 왼쪽으로 이동시킬 수 있으면 이동한다
					if (iter.hasPrevious()) {
						iter.previous();
					}
				} else if (c == '>') {
					// 커서를 오른쪽으로 움직일 수 있으면 오른쪽으로 이동한다
					if (iter.hasNext()) {
						iter.next();
					}
				} else if (c == '-') {
					// 삭제할 데이타가 있다면 커서를 왼쪽으로 이동시키고 해당 데이터를 삭제한다
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				} else {
					iter.add(c);
				}
			}
			for (Character word : list) {
				bw.write(word);
			}
			bw.write('\n');
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
