package DAA;

import java.util.Scanner;

public class fabonacci2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Program 1.2: Non-Recursive Fibonacci Series");

        System.out.print("Enter the number of Fibonacci numbers: ");
        int n = sc.nextInt();

        int count = 0;

        int[] series = new int[n];

        if (n >= 1) {
            series[0] = 0;
            count++;
        }

        if (n >= 2) {
            series[1] = 1;
            count++;
        }

        int a = 0;
        count++;

        int b = 1;
        count++;

        for (int i = 2; i < n; i++) {

            int c = a + b;
            count++;

            series[i] = c;
            count++;

            a = b;
            count++;

            b = c;
            count++;
        }

        System.out.print("Fibonacci Series: ");

        for (int i = 0; i < n; i++) {
            System.out.print(series[i] + " ");
        }

        System.out.println("\nActual Step Count: " + count);

        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(n)");

        sc.close();
    }
}

