public class BinarySearch {
    public int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

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

    // question 1.
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

    // question 2.
    // provide array is sorted
    // find the highest possible index of the key in the array
    public int lastOccuranceBinarySearch(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int midIdx = (s + e) / 2;
            int midVal = arr[midIdx];

            if (midVal == key) {
                ans = midIdx; // saving for now
                if (midIdx == arr.length - 1 || arr[midIdx + 1] != key) { // check if its either the starting idx or no
                                                                          // value matches
                                                                          // key before the current idx
                    return ans;
                } else {
                    s = midIdx + 1;
                }
            } else if (midVal > key) {
                e = midIdx - 1;
            } else {
                s = midIdx + 1;
            }
        }
        return ans;
    }

    // question 3.
    public int countOccuranceBinarySearch(int[] arr, int key) {
        int firstIdx = firstOccuranceBinarySearch(arr, key);
        if (firstIdx < 0)
            return 0;
        int lastIdx = lastOccuranceBinarySearch(arr, key);
        return lastIdx - firstIdx + 1;
    }

    // question 4.
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = firstOccuranceBinarySearch(nums, target);
        if (firstIdx < 0)
            return new int[] { -1, -1 };
        int lastIdx = lastOccuranceBinarySearch(nums, target);
        return new int[] { firstIdx, lastIdx };
    }

    // question 5.
    // ******

    // question 6.
    public int minimumElementInRSA(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int midIdx = (s + e) / 2;
            int midVal = arr[midIdx];
            // if (midVal < arr[midIdx-1]) // to find where the rotation happened
            // ____return midVal; // minimum Element
            if (midVal > arr[e]) {
                s = midIdx + 1;
            } else { // midVal < arr[e]
                e = midIdx;
            }
        }
        return arr[s];
    }

    // question 7.
    // ******

    // question 8.
    public int numberOfRotationInRSA(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int midIdx = (s + e) / 2;
            int midVal = arr[midIdx];
            if (midVal > arr[e]) {
                s = midIdx + 1;
            } else { // midVal < arr[e]
                e = midIdx;
            }
        }
        return s;
    }

    // question 9.
    // treating the RSA as a combination of two sorted arrays
    // public boolean searchRotatedSortedArray(int[] arr, int target) {
    // int idx = numberOfRotationInRSA(arr);
    // boolean firstHalf =

    // if (firstHalf || secondHalf)
    // return true;
    // return false;
    // }

    // question 10.
    public boolean possible(int[] arr, int hr, int speed) {
        int hrUsed = 0;
        for (int x : arr) {
            hrUsed += Math.ceil((double) x / speed);
        }
        if (hrUsed > hr)
            return false;
        return true;
    }

    public int kokoEatingBananas(int[] piles, int h) {
        /*
         * int h = 6;
         * int piles[] = { 30, 11, 23, 4, 20 };
         * { 1, ... , 30 } => { s, ... , e }
         * find mid => (s + e) / 2
         * { 1, ... , 17, ... , 30 } => { s, ... , 17, ... , e }
         * 
         */
        int s = 1; // min speed
        int e = getMax(piles); // max speed
        int ans = -1;
        while (s < e) {
            int speed = (s + e) / 2; // mid speed
            if (possible(piles, h, speed)) {
                ans = speed;
                e = speed - 1;
            } else {
                s = speed + 1;
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
        System.out.println("Last Occurance Binary Search: " + bs.lastOccuranceBinarySearch(arr, key));
        System.out.println("Count Occurance Binary Search: " + bs.countOccuranceBinarySearch(arr, key));
        // System.out.println("Search Range: " + bs.searchRange(arr, key));

        int rsa[] = { 11, 15, 19, 5, 7, 9 };
        System.out.println("Minimum Element in RSA: " + bs.minimumElementInRSA(rsa));
        System.out.println("Number of Rotation in RSA: " + bs.numberOfRotationInRSA(rsa));

        // Koko Eating Bananas
        // [30,11,23,4,20]
        int piles[] = { 30, 11, 23, 4, 20 };
        int h = 5;
        System.out.println("Koko Eating Bananas: " + bs.kokoEatingBananas(piles, h));
    }
}