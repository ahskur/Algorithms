// by LCP, BRAP
// 22.10.2023

public class HappyNumbers {
    public static boolean isHappy(int n) {
        // This method checks if a number is a happy number.
        // A happy number is defined as follows: Start with any positive integer,
        // replace the number by the sum of the squares of its digits, and repeat
        // the process until the number equals 1, or it loops endlessly in a cycle
        // that does not include 1. If it equals 1, it's a happy number; otherwise, it's not.

        int iterations = 0;
        int sum = 0;
        while (n > 0) {
            iterations++;
            int ziffer = n % 10;  // Get the last digit of n.
            System.out.println("Ziffer: " + ziffer);
            int quader = ziffer * ziffer;  // Square the digit.
            System.out.println("Quadriert: " + quader);
            sum = sum + quader;  // Add the squared digit to the sum.
            System.out.println("Summe: " + sum);
            if (sum == 1 && n / 1 == 1) return true;  // Check if it's a happy number.
            // For the number to be happy, the sum needs to be 1 but the last digit itself also needs to be 1
            // This catches cases where the number return sum 1 by still has values
            n = n / 10;  // Remove the last digit from n.
            if (iterations > 15) return false;  // Avoid infinite loops.
            if (n == 0) {
                n = sum;
                sum = 0;
            }
        }
        return false;
    }

    public static int nextHappyNumber(int n) {
        // This method finds the next happy number greater than the given number n.
        while (true) {
            n++;
            if (isHappy(n)) {
                return n;
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        if (isHappy(n)) {
            System.out.println(n + " ist froehlich.");
        } else {
            System.out.println(n + " ist traurig.");
            int next = nextHappyNumber(n);
            System.out.println("Die nächste froehliche Zahl nach " + n + " ist " + next);
        }
    }
}

