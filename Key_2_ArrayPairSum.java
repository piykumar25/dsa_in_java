import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Key_2_ArrayPairSum {

    public static void main(String[] args) {
        System.out.println("Array Pair Sum::");
        int[] arr = new int[]{1, 2, 3, 4, 5, 5, 6, 7};
        int k = 7;
        printArrayPairSum(arr, k);
    }

    /**
     * Prints all pairs of integers in the given array that sum up to the given target.
     *
     * @param arr The array of integers.
     * @param k   The target sum.
     */
    // Time Complexity: O(N)
    private static void printArrayPairSum(int[] arr, int k) {
        // If the array has less than 2 elements, there are no pairs to print.
        if (arr.length < 2) {
            return;
        }

        // Keep track of the numbers we've seen so far.
        Set<Integer> seen = new HashSet<>();
        // Keep track of the pairs we've found.
        Set<List<Integer>> output = new HashSet<>();

        // Iterate over each number in the array.
        for (int num : arr) {
            // Calculate the complement of the current number (i.e., the number that, when added to the current number,
            // would sum up to the target).
            int target = k - num;
            // If we've already seen the complement, we've found a pair.
            if (!seen.contains(target)) {
                seen.add(num);
            } else {
                // Create a list containing the two numbers in the pair.
                List<Integer> pair = Arrays.asList(Math.min(num, target), Math.max(num, target));
                // Add the pair to the output set.
                output.add(pair);
            }
        }

        // Print each pair we found.
        for (List<Integer> pair : output) {
            System.out.println(pair);
        }
    }


    // Time Complexity: O(N log N)
    private static void printArrayPairSumWithSort(int[] arr, int k) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] == k) {
                System.out.println(arr[left] + " " + arr[right]);
                left++;
                right--;
            } else if (arr[left] + arr[right] < k) {
                left++;
            } else {
                right--;
            }
        }
    }

}
