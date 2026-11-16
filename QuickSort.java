package DAA;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort{

    static int deterministicCount = 0;
    static int randomizedCount = 0;

    static Random random = new Random();

    // Deterministic Quick Sort
    static int deterministicPartition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            deterministicCount++;

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

    static void deterministicQuickSort(int arr[], int low, int high) {

        if (low < high) {

            int pi = deterministicPartition(arr, low, high);

            deterministicQuickSort(arr, low, pi - 1);
            deterministicQuickSort(arr, pi + 1, high);
        }
    }

    // Randomized Partition
    static int randomizedPartition(int arr[], int low, int high) {

        int randomIndex = random.nextInt(high - low + 1) + low;

        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            randomizedCount++;

            if (arr[j] <= pivot) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void randomizedQuickSort(int arr[], int low, int high) {

        if (low < high) {

            int pi = randomizedPartition(arr, low, high);

            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Quick Sort Analysis");

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int arr1[] = Arrays.copyOf(arr, n);
        int arr2[] = Arrays.copyOf(arr, n);

        // Deterministic Quick Sort
        deterministicQuickSort(arr1, 0, n - 1);

        System.out.println("\nDeterministic Quick Sort:");
        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("Comparisons: " + deterministicCount);

        // Randomized Quick Sort
        randomizedQuickSort(arr2, 0, n - 1);

        System.out.println("\nRandomized Quick Sort:");
        System.out.println("Sorted Array: " + Arrays.toString(arr2));
        System.out.println("Comparisons: " + randomizedCount);

        System.out.println("\nTime Complexity:");
        System.out.println("Best Case: O(n log n)");
        System.out.println("Average Case: O(n log n)");
        System.out.println("Worst Case: O(n^2)");

        sc.close();
    }
}
