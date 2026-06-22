class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, result = nums[0];

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                result = Math.min(result, nums[l]);
                break;
            }

            int mid = l + ((r - l) / 2);

            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                result = nums[mid];
                r = mid - 1;
            }
        }
        
        return result;
    }
}
