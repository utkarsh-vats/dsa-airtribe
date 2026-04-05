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

}