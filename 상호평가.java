class Solution {
    private String getGrade(int score) {
		if(score >= 90)
			return "A";
		if(score >= 80)
			return "B";
		if(score >= 70)
			return "C";
		if(score >= 50)
			return "D";
		return "F";
	}
    
    public String solution(int[][] scores) {
        		StringBuilder sb = new StringBuilder();
		int num = scores.length;
		for (int student = 0; student < num; student++) {
			boolean maxCheck = false, minCheck = false;
			int max = -1, min = 101, sum = 0;
			for (int friends = 0; friends < num; friends++) {
				if (max < scores[friends][student])
					max = scores[friends][student];
				else if (max == scores[friends][student])
					maxCheck = true;

				if (min > scores[friends][student])
					min = scores[friends][student];
				else if (min == scores[friends][student])
					minCheck = true;
				
				sum += scores[friends][student];
				
			}
			int score = 0;
			// 스스로에게 준 점수가 유일하게 최댓값 또는 최솟값일 경우
			if((max == scores[student][student] && maxCheck == false) 
					|| (min == scores[student][student] && minCheck == false)) {
				score = (sum - scores[student][student]) / (num - 1);
				
			}else {
				score = sum / num;
			}
			System.out.println(score);
			sb.append(getGrade(score));
		}

		return sb.toString();
    }
}
