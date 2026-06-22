class Solution {
    public int findMin(int[] nums) {
        int result = nums[0];
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (nums[mid] >= result) {
                l = mid + 1;
            } else {
                result = nums[mid];
                r = mid - 1;
            }
        }
        
        return result;
    }
}
