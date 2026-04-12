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

    public static int[] mergeSort(int[] arr1, int[] arr2) {
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

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 7, 9 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] ans = SortingAlgo.mergeSort(arr1, arr2);
        System.out.println(Arrays.toString(ans));

    }

}