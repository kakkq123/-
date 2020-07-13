import java.util.*;
class Solution {
    static ArrayList<String> list = new ArrayList<String>();
	static boolean[] visit;
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
		for (int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0], dest = tickets[i][1];
			if (start.equals("ICN")) {
				String route = start + "," + dest;
				visit[i] = true;
				dfs(route, dest, 1, tickets);
				visit[i] = false;
			}
		}
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		return answer;
    }
    public void dfs(String route, String start, int cnt, String[][] tickets) {
		if (cnt == tickets.length) {
			list.add(route);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (visit[i] || !tickets[i][0].equals(start))
				continue;
			visit[i] = true;
			dfs(route + "," + tickets[i][1], tickets[i][1], cnt + 1, tickets);
			visit[i] = false;
		}

	}

}
