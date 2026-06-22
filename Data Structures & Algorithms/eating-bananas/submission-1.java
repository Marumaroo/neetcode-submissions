class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;

        for (int p : piles) {
            r = Math.max(r, p);
        }

        int result = r;

        while (l <= r) {
            int speed = (l + r) / 2;

            int hours = 0;
            for (int p : piles) {
                hours += Math.ceil((double) p / speed);
            }

            
            if (hours <= h) {
                result = Math.min(result, speed);
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }

        return result;
    }
}
