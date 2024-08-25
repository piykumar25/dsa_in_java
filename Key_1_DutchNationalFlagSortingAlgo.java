import java.util.Arrays;

public class Key_1_DutchNationalFlagSortingAlgo {

    public static void main(String[] args) {
        System.out.println("Dutch National Flag Sorting Algorithm");
        int[] arr = new int[] { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        System.out.println("Original array: " + Arrays.toString(arr));
        segregateArray(arr);
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }

    /**
     * Sorts an array of three distinct elements (0s, 1s, and 2s) in-place using the "Dutch National Flag" algorithm.
     *
     * @param arr The array to be sorted.
     */
    public static void segregateArray(int[] arr) {
        // Initialize pointers for the start, middle, and end of the array
        int start = 0, mid = 0, end = arr.length - 1;

        // Loop through the array until the middle pointer reaches the end
        while (mid <= end) {
            // If the element at the middle pointer is 0
            if (arr[mid] == 0) {
                // Swap the element at the start pointer with the element at the middle pointer
                arr[start] += arr[mid];
                arr[mid] = arr[start] - arr[mid];
                arr[start] -= arr[mid];

                // Move the start and middle pointers forward
                start++;
                mid++;
            }
            // If the element at the middle pointer is 1
            else if (arr[mid] == 1) {
                // Move the middle pointer forward
                mid++;
            }
            // If the element at the middle pointer is 2
            else {
                // Swap the element at the end pointer with the element at the middle pointer
                arr[end] += arr[mid];
                arr[mid] = arr[end] - arr[mid];
                arr[end] -= arr[mid];

                // Move the end pointer backward
                end--;
            }
        }
    }
}
