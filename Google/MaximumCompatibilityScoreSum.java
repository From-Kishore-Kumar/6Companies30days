//https://leetcode.com/problems/maximum-compatibility-score-sum/
//leetcode problem 1947
class MaximumCompatibilityScoreSum {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return dfs(students, mentors, 0, 0, new Integer[students.length][256]);
    }

    private int dfs(int[][] stu, int[][] men, int idx, int status, Integer[][] memo) {
        if (idx == stu.length) {
            return 0;
        }
        if (memo[idx][status] != null) {
            return memo[idx][status];
        }

        int res = 0;
        for (int i = 0; i < men.length; i++) {
            if ((status & (1 << i)) == 0) {
                res = Math.max(res, comp(stu[idx], men[i]) + dfs(stu, men, idx + 1, status | (1 << i), memo));
            }
        }
        memo[idx][status] = res;
        return res;
    }

    private int comp(int[] stu, int[] men) {
        int res = 0;
        for (int i = 0; i < stu.length; i++) {
            if (stu[i] == men[i]) {
                res++;
            }
        }
        return res;
    }
}