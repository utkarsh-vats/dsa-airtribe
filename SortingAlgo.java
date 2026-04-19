import java.util.Arrays;

class SortingAlgo {
    public static void BubbleSort() {
        int arr[] = { 5, 9, 8, 2, 1 };
        int noOfElements = arr.length;
        boolean swapped;
        for (int i = 1; i <= noOfElements; i++) {
            swapped = false;
            for (int j = 0; j < noOfElements - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    public static int[] merge2Sorted(int[] arr1, int[] arr2, int count) {
        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] > arr2[j]) {
                ans[k] = arr2[j];
                j++;
                count++;
            } else {
                ans[k] = arr1[i];
                i++;
            }
            k++;
        }
        while (i < n) {
            ans[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m) {
            ans[k] = arr2[j];
            j++;
            k++;
        }
        return ans;
    }

    public static int[] mergeSortHelper(int[] arr, int s, int e, int count) {
        if (s == e) {
            int[] baseCase = new int[1];
            baseCase[0] = arr[s];
            return baseCase;
        }
        int mid = (s + e) / 2;
        int[] leftSorted = mergeSortHelper(arr, s, mid, count);
        int[] rightSorted = mergeSortHelper(arr, mid + 1, e, count);
        return merge2Sorted(leftSorted, rightSorted, count);
    }

    public static int[] mergeSort(int[] arr) {
        return mergeSortHelper(arr, 0, arr.length - 1, 0);
    }

    // ************* MERGE SORT END *****************

    // ************* QUICK SORT START *****************
    /*
     * [0, 1, 0, 1, 0, 0, 1, 1, 0]
     * i = 0
     * j = 0
     * 
     * Pseudo Code for Quick Sort:
     * if (arr[i] == 0) {
     * * swap(i, j)
     * * i++
     * * j++
     * } else {
     * * i++
     * }
     */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int s, int e, int pivot) {
        int i = s;
        int j = s;
        while (i <= e) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j - 1;
    }

    public void quickSortHelper(int[] arr, int s, int e) {
        if (s > e) {
            return;
        }
        int partitionIdx = partition(arr, s, e, arr[e]);
        quickSortHelper(arr, s, partitionIdx - 1);
        quickSortHelper(arr, partitionIdx + 1, e);
    }

    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    // ************* QUICK SORT END *****************

    // ************* INSERTION SORT START ***************
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // ************* INSERTION SORT END *****************

    public static int inversionCount(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                count++;
            }
            arr[j + 1] = key;
        }
        return count;
    }

    public static int inversionCountUsingMergeSort(int[] arr, int s, int e) {
        int count = 0;
        mergeSortHelper(arr, s, e, count);
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 7, 9 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr = { 5, 9, 8, 2, 1 };
        int[] arr3 = { 2, 4, 1, 3, 5 };

        int[] ans = SortingAlgo.merge2Sorted(arr1, arr2, 0);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(SortingAlgo.mergeSort(arr)));
        SortingAlgo.insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(SortingAlgo.inversionCount(arr3));
        System.out.println(SortingAlgo.inversionCountUsingMergeSort(arr3, 0, arr3.length - 1));
    }
}