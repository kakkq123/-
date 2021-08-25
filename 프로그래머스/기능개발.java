import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       	int len = progresses.length;
        // 남은 기능 진도
        int[] time = new int[len];
        for (int i = 0; i < len; i++) {
          time[i] = 100 - progresses[i];
        }
            // 개발 완료까지 걸리는 시간
        int[] m = new int[len];
        for (int i = 0; i < len; i++) {
          int tmp = time[i] % speeds[i];
          m[i] = time[i] / speeds[i];
          if (tmp > 0) {
            m[i] += 1;
          }
        }
        // 배포 
        int idx = 0;
        List<Integer> answer = new ArrayList<Integer>();
        while (idx < len) {
          int comp = m[idx];
          int cnt = 1;
          int i = idx + 1;
          for (i = idx + 1; i < len && comp >= m[i]; i++) {
            cnt++;
          }
          idx += i - idx;
          answer.add(cnt);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
