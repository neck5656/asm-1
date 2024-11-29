import java.util.Random;

public class AnalysisAlgorithmDemo {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    public static void bubbleSort(int n, int[] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int size = 100000;
        Random random = new Random();

        int[] baseArray = random.ints(size, 0, 10000000).toArray();

        // Copy array for fair comparisons
        int[] bubbleArray = baseArray.clone();
        int[] quickArray = baseArray.clone();
        int[] mergeArray = baseArray.clone();
        int[] insertionArray = baseArray.clone();

        long time1 = System.nanoTime();
        bubbleSort(bubbleArray.length, bubbleArray);
        long time2 = System.nanoTime();
        System.out.println("Run time Bubble: " + (time2 - time1));

        long time3 = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        long time4 = System.nanoTime();
        System.out.println("Run time Quick: " + (time4 - time3));

        long time5 = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long time6 = System.nanoTime();
        System.out.println("Run time Merge: " + (time6 - time5));

        long time7 = System.nanoTime();
        insertionSort(insertionArray);
        long time8 = System.nanoTime();
        System.out.println("Run time Insertion: " + (time8 - time7));
    }
}
