import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
		    int number = 0, num = 0;
		    String s1 = "";
		    ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
		    HashSet<String> hs = new HashSet<String>();
		    for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			    String s = iter.next();
			    number = (number) % n + 1;
			    num = number == 1 ? num + 1 : num;
			  if (s1.equals("")) {
				  s1 = s.substring(s.length() - 1);
				  hs.add(s);
				  continue;
			  }
			  if (hs.contains(s) || !s1.equals(s.substring(0,1))) {
				  answer[0] = number;
				  answer[1] = num;
				  return answer;
			  }
			  s1 = s.substring(s.length() - 1);
			  hs.add(s);
		  }
		  return answer;
    }
}
