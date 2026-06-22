class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxLeft = height[l];
        int maxRight = height[r];

        int water = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= maxLeft) {
                    maxLeft = height[l];
                } else {
                    water += maxLeft - height[l];
                }
                l++;
            } else {
                if (height[r] >= maxRight) {
                    maxRight = height[r];
                } else {
                    water += maxRight - height[r];
                }
                r--;
            }
        }
        
        return water;
    }
}
