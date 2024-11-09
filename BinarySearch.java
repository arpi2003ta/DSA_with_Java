import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    
    // Method to perform binary search
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the key is at mid
            if (arr[mid] == key) {
                return mid; // Key found at mid index
            }

            // If the key is greater, ignore the left half
            if (arr[mid] < key) {
                left = mid + 1;
            } 
            // If the key is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        
        // If we reach here, the element was not present
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sort the array before performing binary search
        Arrays.sort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Enter the element to search for: ");
        int key = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(arr, key);

        // Display the result
        if (result == -1) {
            System.out.println("Element " + key + " not found in the array.");
        } else {
            System.out.println("Element " + key + " found at index: " + result);
        }

        scanner.close();
    }
}
