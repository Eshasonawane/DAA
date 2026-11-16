package DAA;

import java.util.Scanner;

public class fabonacci {

    static int count = 0;

    static int fibonacci(int n) {
        count++;

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Program 1.1: Recursive Fibonacci Series");

        System.out.print("Enter the number of Fibonacci numbers: ");
        int num = sc.nextInt();

        System.out.print("Fibonacci Series: ");

        for (int i = 0; i < num; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println("\nStep Count: " + count);

        System.out.println("Time Complexity: O(2^n)");
        System.out.println("Space Complexity: O(n)");

        sc.close();
    }
}