public class Key_4_slidingWindow {

    int[] arr = {-1, 2, 3, 3, 4, 5, -1};
    int k = 4;

    public static void main(String[] args) {

        Key_4_slidingWindow obj = new Key_4_slidingWindow();
        obj.largestSumOfKConsecutiveElements();
        obj.subarrayWithSumLessThanK();

    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Technique: Sliding Window --> Fixed Size --> Window Sum
     */
    public void largestSumOfKConsecutiveElements() {

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            windowSum = Math.max(windowSum, windowSum + arr[i] - arr[i - k]);
        }

        System.out.println("The largest sum of k consecutive elements is: " + windowSum);

    }

    /**
     * Time Complexity: o(n)
     * Space Complexity: O(1)
     * Technique: Sliding Window --> Variable Size --> in case sum is less than K subarray
     */
    public void subarrayWithSumLessThanK() {

        int l = 0, r = 0, n = arr.length;
        int sum = 0, maxLen = 0;
        while(r < n) {
            sum += arr[r];
            if(sum >= k) {
                sum -= arr[l];
                l++;
            }
            r++;
            maxLen = Math.max(maxLen, r - l + 1);
        }

        System.out.println("The maximum length of subarray with sum less than k is: " + maxLen);

    }
}
