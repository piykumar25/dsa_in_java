import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Key_5_FindMissingNumberIn2Array {

    public static void main(String[] args) {

        int[] arr1 = {7, 2, 4, 3, 5, 6, 0, 1};
        int[] arr2 = {2, 4, 7, 1, 6, 0, 3};

        System.out.println("Missing number in array1 and array2: ");
        Arrays.stream(arr1).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Arrays.stream(arr2).forEach(n -> System.out.print(n + " "));
        System.out.println("\nMissing number: " + findMissingNumber(arr1, arr2));
    }

    // Time Complexity: O(n)
    public static int findMissingNumber(int[] array1, int[] array2) {
        int result = 0;

        // XOR all elements from array1
        for (int num : array1) {
            result ^= num;
        }

        // XOR all elements from array2
        for (int num : array2) {
            result ^= num;
        }

        return result;
    }

    // Problem with this approach is that it will take extra space O(n)
    public static int findMissingNumber1(int[] array1, int[] array2) {
        // Create a HashMap to store the frequency of elements in array2
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the HashMap with elements from array2
        for (int num : array2) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Compare elements in array1 against the frequency map
        for (int num : array1) {
            int count = frequencyMap.getOrDefault(num, 0);
            if (count == 0) {
                return num;  // Return the missing number
            }
            frequencyMap.put(num, count - 1);  // Decrement the count in the map
        }

        // Return -1 if no missing number is found (this line should theoretically never be reached)
        return -1;
    }

}
