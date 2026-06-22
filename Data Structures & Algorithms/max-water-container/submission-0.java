class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        
        int max = 0;

        while (l < r) {
            int maxHeight = Math.min(heights[l], heights[r]);
            max = Math.max(max, maxHeight * (r - l));

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}
