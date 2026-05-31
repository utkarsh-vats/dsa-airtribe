import java.util.*;

public class LeanHashMap {
    // 1. you are given an array, state true or false,
    // if any subarray with sum zero is present.
    // testcase: [3, 4, 3, -3, -7] -> [3, -3]; [3, 4, 3, -3, -7]
    int sumSubArray(int[] nums, int start, int end) {
        int ans = 0;
        for (int i = start; i <= end; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public boolean checkZeroSubArray(int[] nums) {
        // brute force, check for every subarray
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sumSubArray(nums, i, j) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // hashmap approach
    public boolean checkZeroSubArrayWithHashmap(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        int sum = 0;
        hm.put(sum, true);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum)) {
                return true;
            }
            hm.put(sum, true);
        }
        return false;
    }

    // 5. check if subarray with sum k is present
    public boolean ifKSumSubArray(int[] nums, int k) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        int sum = 0;
        hm.put(sum, true);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) {
                return true;
            }
            hm.put(sum, true);
        }
        return false;
    }

    // 2. Count of zero sum subarrays
    public int countZeroSumSubArray(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        hm.put(sum, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum)) {
                count = count + hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            } else {
                hm.put(sum, 1);
            }
        }

        for (int key : hm.keySet()) {
            System.out.println("{ " + key + " " + hm.get(key) + " }");
        }
        // return hm.get(0);
        return count;
    }

    // 3. longest subarray with sum zero
    // we are checking when the sum appears again in the map
    // []
    public int longestSubarrayWithSumZero(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // <sum, index>

        int sum = 0;
        hm.put(sum, -1);

        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum)) {
                len = Math.max(len, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        return len;
    }

    // 4. longest subarray with sum zero with start and end index
    public Pair getLongestSubarrayWithSumZero(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // <sum, index>

        int sum = 0;
        hm.put(sum, -1);

        int len = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum)) {
                int prevIndex = hm.get(sum);
                if (i - prevIndex > len) {
                    len = i - prevIndex;
                    start = prevIndex + 1;
                    end = i;
                }
            } else {
                hm.put(sum, i);
            }
        }

        Pair p = new Pair();
        p.start = start;
        p.end = end;
        return p;
    }

    public static class Pair {
        public int start;
        public int end;
    }

    void hashmaptest() {
        TreeMap<String, Integer> hm = new TreeMap<>();
        // hm.put("ABC", 10);
        hm.put("BCD", 10);
        hm.put("CDE", 10);
        hm.put("DEF", 10);

        System.out.println("BEFORE" + hm);
        // hm.put("ABC", 10);
        hm.putIfAbsent("ABC", 100);
        System.out.println("AFTER" + hm);
        System.out.println(hm.size());
        System.out.println(hm.get("DEF"));
        // int ans = hm.get("XYZ");
        // System.out.println(ans); // NullPointerException

        if (hm.containsKey("BCD")) {
            int ans = hm.get("BCD");
            System.out.println(ans);
        } else {
            System.out.println("Key is Absent");
        }

        // alternatively
        int ans = hm.getOrDefault("BCD", 0);
        System.out.println("Value is ---" + ans);

        for (String key : hm.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hm.get(key));
        }

        for (int value : hm.values()) {
            System.out.println("Value: " + value);
        }
    }

    class KeyFrequencyObject {
        int element;
        int frequency;

        KeyFrequencyObject(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
    }

    class Solution {
        // see top or most -> always priority queue
        //

        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            PriorityQueue<KeyFrequencyObject> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
            for (int i = 0; i < nums.length; i++) {
                int oldVal = hm.getOrDefault(nums[i], 0);
                hm.put(nums[i], oldVal);
            }
            for (int key : hm.keySet()) {
                KeyFrequencyObject obj = new KeyFrequencyObject(key, hm.get(key));
                pq.add(obj);
            }
            ArrayList<Integer> al = new ArrayList<>();
            while (k > 0) {
                KeyFrequencyObject removedObject = pq.remove();
                al.add(removedObject.element);
                k--;
            }
            int[] ans = new int[al.size()];
            for (int i = 0; i < al.size(); i++)
                ans[i] = al.get(i);
            return ans;
        }
    }

    public static void main(String[] args) {
        LeanHashMap lh = new LeanHashMap();
        // HashMap<String, Integer> hm = new HashMap<>();
        // lh.hashmaptest();

        // int[] nums = { 3, 4, 3, -3, -7 };

        // int[] nums = { 3, -3, 0, 2, 4, -4, 6, -8 };
        // Possible subarrays with sum zero:
        // {3, -3}, {0}, {4, -4}, {2, 4, -4, 6, -8}, {3, -3, 0},
        // {3, -3, 0, 2, 4, -4, 6, -8}, {0, 2, 4, -4, 6, -8}

        // -> [3, -3]; [0]; [4, -4]; [2, 4, -4, 6, -8]; [3, -3, 0];
        // [3, -3, 0 , 2, 4, -4, 6, -8]
        // -> count: 0

        // int[] nums = { 3, 5, 2, -4, -6, 8, 1, 4, -3 };

        int[] nums = { 4, -4, 2, 7, -7, -2, 10, -10 };

        // System.out.println(lh.checkZeroSubArray(nums));
        // System.out.println(lh.checkZeroSubArrayWithHashmap(nums));

        System.out.println("Count: " + lh.countZeroSumSubArray(nums));

        System.out.println("Longest Subarray: " + lh.longestSubarrayWithSumZero(nums));
    }
}