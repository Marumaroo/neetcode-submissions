class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), results);
        
        return results;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> results) {
        results.add(new ArrayList<>(path));

        for (int i=start; i < nums.length; i++) {
            path.add(nums[i]);

            backtrack(i + 1, nums, path, results);

            path.remove(path.size() - 1);
        }
    }
}
