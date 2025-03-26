
import java.util.Arrays;

class CountingSort {
    public static void countingSort(int[] arr) {
        // Find the maximum value in the array to determine the range
        int max = Arrays.stream(arr).max().orElse(0);
        
        // Step 1: Compute Key Frequencies
        int[] freq = new int[max + 1]; // Frequency array
        for (int num : arr) {
            freq[num]++;
        }
        System.out.println("Key Frequencies: " + Arrays.toString(freq));

        // Step 2: Compute Starting Indices
        int[] startIndex = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            startIndex[i] = startIndex[i - 1] + freq[i - 1];
        }
        System.out.println("Starting Indices: " + Arrays.toString(startIndex));

        // Step 3: Compute Ending Indices
        int[] endIndex = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            endIndex[i] = startIndex[i] + freq[i];
        }
        System.out.println("Ending Indices: " + Arrays.toString(endIndex));

        // Step 4: Build the sorted array
        int[] sortedArr = new int[arr.length];
        int[] position = Arrays.copyOf(startIndex, startIndex.length); // Copy to track positions

        for (int num : arr) {
            sortedArr[position[num]] = num;
            position[num]++; // Move index forward
        }
        
        System.out.println("Sorted Array: " + Arrays.toString(sortedArr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 2, 1, 0, 2, 2, 0};
        countingSort(arr);
    }
}

