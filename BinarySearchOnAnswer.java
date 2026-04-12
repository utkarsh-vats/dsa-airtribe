public class BinarySearchOnAnswer {
    // question 11.
    public boolean canAchieve(int m, int[] weights) {
        /*
         * Pseudo Code for canAchieve (Capacity Check):
         * 1. Initialize 'daysNeeded' to 1 (starting with the first day).
         * 2. Initialize 'currentLoad' to 0.
         * 3. Iterate through each 'weight' in the 'weights' array:
         * a. If adding the current weight exceeds the capacity 'm':
         * - Increment 'daysNeeded' (move to the next day).
         * - Reset 'currentLoad' to the current weight.
         * b. Else:
         * - Add the current weight to 'currentLoad'.
         * 4. Return true if 'daysNeeded' is less than or equal to the required 'days',
         * else false.
         * 
         * Logic: This function determines if a ship with capacity 'm' can transport all
         * packages within the given 'days' by greedily filling the ship each day.
         */
        int d = 1;
        int load = 0;
        for (int weight : weights) {
            if (load + weight > m) {
                d++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return d <= weights.length;
    }

    public int shipWithDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            right = Math.max(right, w);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (canAchieve(mid, weights)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int input[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int key = 5;
        BinarySearchOnAnswer bs = new BinarySearchOnAnswer();
        System.out.println(bs.shipWithDays(input, key));
    }
}
