import java.util.Arrays;

public class Greedy {
    // leetcode meeting rooms I
    public boolean meeting_rooms_1(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < meetings.length; i++) {
            int start_current = meetings[i][0];
            int end_prev = meetings[i - 1][1];

            if (start_current < end_prev)
                return false;
        }

        return true;
    }

    // leetcode meeting rooms II
    public int meeting_rooms_2(int[] st, int[] et) {

        Arrays.sort(st);
        Arrays.sort(et);

        int max_rooms_used = 0;
        int curr_rooms_used = 0;

        int i = 0;
        int j = 0;

        while (i < st.length) {
            if (st[i] < et[j]) {
                curr_rooms_used++;
                i++;
            } else {
                curr_rooms_used--;
                j++;
            }
            max_rooms_used = Math.max(max_rooms_used, curr_rooms_used);
        }

        return max_rooms_used;
    }

    public boolean canJump(int[] arr) {
        int maxReach = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxReach < i) {
                return false;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            if (maxReach == arr.length - 1) {
                return true;
            }
        }
        return true;
    }

    // leetcode

    public static void main(String[] args) {
        Greedy greedy = new Greedy();

        // Test case 1: No overlapping meetings
        int[][] meetings1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("Test 1 (no overlap): " + greedy.meeting_rooms_1(meetings1)); // Expected: false

        // Test case 2: Overlapping meetings
        int[][] meetings2 = { { 0, 30 }, { 5, 10 }, { 15, 20 }, { 10, 25 } };
        System.out.println("Test 2 (overlap): " + greedy.meeting_rooms_1(meetings2)); // Expected: false

        // Test case 3: Single meeting
        int[][] meetings3 = { { 0, 30 } };
        System.out.println("Test 3 (single): " + greedy.meeting_rooms_1(meetings3)); // Expected: true

        // Test case 4: Empty meetings
        int[][] meetings4 = {};
        System.out.println("Test 4 (empty): " + greedy.meeting_rooms_1(meetings4)); // Expected: true

        // Test case 5: Adjacent meetings (no overlap)
        int[][] meetings5 = { { 0, 5 }, { 5, 10 }, { 10, 15 } };
        System.out.println("Test 5 (adjacent): " + greedy.meeting_rooms_1(meetings5)); // Expected: true
    }
}