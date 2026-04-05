public class BinarySearch {
    public boolean linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }

    // provide array is sorted
    public boolean binarySearch(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int midIdx = (s + e) / 2;
            int midVal = arr[midIdx];
            if (midVal == key) {
                return true;
            } else if (midVal < key) {
                s = midIdx + 1;
            } else {
                e = midIdx - 1;
            }
        }
        return false;
    }

    // provide array is sorted
    // find the lowest possible index of the key in the array
    public int firstOccuranceBinarySearch(int[] arr, int key) {
        // ______ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        // arr = [1, 1, 1, 1, 1, 2, 3, 3, 4, 4]
        // _______s_____m____________________e

        /*
         * m = (s + e) / 2 => (0 + 9) / 2 => 4
         * arr[m-1] == key ? => true*
         * e = m - 1
         * 
         */

        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int midIdx = (s + e) / 2;
            int midVal = arr[midIdx];

            if (midVal == key) {
                ans = midIdx; // saving for now
                if (midIdx == 0 || arr[midIdx - 1] != key) { // check if its either the starting idx or no value matches
                                                             // key before the current idx
                    return ans;
                } else {
                    e = midIdx - 1;
                }
            } else if (midVal > key) {
                e = midIdx - 1;
            } else {
                s = midIdx + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = { 5, 10, 15, 20, 25, 30 };
        int arr[] = { 1, 1, 1, 1, 1, 2, 3, 3, 4, 4 };
        BinarySearch bs = new BinarySearch();
        int key = 1;
        System.out.println("Linear Search: " + bs.linearSearch(arr, key));
        System.out.println("Binary Search: " + bs.binarySearch(arr, key));
        System.out.println("First Occurance Binary Search: " + bs.firstOccuranceBinarySearch(arr, key));
    }
}