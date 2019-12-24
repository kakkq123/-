import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Solution {
    public int[] solution(int n, String[] words) {
      int[] answer = { 0, 0 };
        int number = 0, num = 1;
        String s1 = "";
        System.out.println(s1);
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        ArrayList<String> before = new ArrayList<String>();
        for (String s : list) {
            number++;
            if (number == n + 1) {
                number = 1;
                num++;
            }
            if(s1.equals("")) {
                s1 = s.substring(s.length() - 1);
                before.add(s);
                continue;
            }
            if (!s1.equals(s.substring(0, 1))) {
                answer[0] = number;
                answer[1] = num;
                return answer;
            }
            s1 = s.substring(s.length() - 1);
            for (Iterator<String> iter = before.iterator(); iter.hasNext();) {
                String t = iter.next();
                if (t.equals(s)) {
                    answer[0] = number;
                    answer[1] = num;
                    return answer;
                }
            }
            before.add(s);
        }
        return answer;
    }
}
