class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        boolean[] computed = new boolean[cost.length];
        memo[0] = cost[0];
        memo[1] = cost[1];

        return Math.min(dp(cost, cost.length-1, memo, computed) , dp(cost,cost.length-2, memo, computed));
    }

    private int dp(int[] cost, int i, int[] memo, boolean[] computed) {
        if (i <= 1 || computed[i]) return memo[i];

        memo[i] = cost[i] + Math.min(dp(cost, i - 1, memo, computed), dp(cost, i - 2, memo, computed));
        computed[i] = true;

        return memo[i];
    }
}
