public class Key_4_LargestContinuousSum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("The largest continuous sum is: " + largestContinuousSum(arr));
    }

    // Time Complexity: O(n)
    public static int largestContinuousSum(int[] arr) {
        // If the array is empty, return 0 or handle the case as needed
        if (arr.length == 0) {
            return 0; // Assuming we return 0 for an empty array
        }

        int maxSum = arr[0];  // Initialize maxSum with the first element
        int currentSum = arr[0];  // Initialize currentSum with the first element

        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update currentSum by either adding the current element or starting fresh from the current element
            currentSum = Math.max(currentSum + arr[i], arr[i]);

            // Update maxSum if the currentSum is greater than the maxSum
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;  // Return the maximum sum found
    }
}
