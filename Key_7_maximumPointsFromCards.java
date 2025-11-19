import java.util.Arrays;

public class Key_7_maximumPointsFromCards {
    int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
    int k = 4;

    public static void main(String[] args) {

        Key_7_maximumPointsFromCards obj = new Key_7_maximumPointsFromCards();
        obj.maximumPointsFromCards();

    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Technique: Two Pointers --> Sliding Window --> Fixed Size
     */

    public void maximumPointsFromCards() {
        int lSum = 0, rSum = 0, maxSum = 0;

        for(int i = 0; i < k; i++) {
            lSum += arr[i];
        }
        int j = arr.length - 1;
        for(int i = k - 1; i >= 0; i--) {
            rSum += arr[j];
            lSum -= arr[i];
            maxSum = Math.max(maxSum, lSum + rSum);
            j--;
        }
        System.out.println("The maximum sum of k consecutive elements is: " + maxSum);
//        int maxSum = 0;
//        for(int i = 0; i < k; i++) {
//            maxSum += arr[i];
//        }
//        int firstLoopSum = 0;
//        for(int i = 0; i < k; i++) {
//            int sum = 0;
//            firstLoopSum += arr[i];
//            sum += firstLoopSum;
//            int r = arr.length - 1;
//            while(r > arr.length - k + i) {
//                sum += arr[r];
//                r--;
//            }
//            maxSum = Math.max(maxSum, sum);
//        }
//        System.out.println("The maximum sum of k consecutive elements is: " + maxSum);
    }
}
