class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), 0, target, results);

        return results;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, int sum, int target, List<List<Integer>> results) {
        if (sum == target) {
            results.add(new ArrayList<>(path));
            return;
        } 
        
        if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i, nums, path, sum + nums[i], target, results);
            path.remove(path.size() - 1);
        }
    }
}