import java.util.Scanner;

public class BubbleSort {
    
    // Method to perform bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Flag to detect any swap
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare and swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Set the flag to true if swap occurs
                }
            }
            // If no two elements were swapped in the inner loop, break
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
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

        System.out.println("Unsorted array:");
        printArray(arr);

        // Perform bubble sort
        bubbleSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
