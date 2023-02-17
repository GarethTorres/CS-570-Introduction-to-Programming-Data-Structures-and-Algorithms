//Guizhi Xu
//CWID: 20008770

public class Complexity {

    // Method 1: Complexity with O(n^2)
    public static void method1(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Pleas input an legal argument");
        }
        int counter = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                System.out.println("Time complexity O(n^2) is : " + counter);
                counter++;
            }
    }

    // a method that has time complexity O(n*n*n).
    public static void method2(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Pleas input an legal argument");
        }
        int counter = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) {
                    System.out.println("Time complexity O(n^3) is: " + counter);
                    counter++;
                }

    }

    // a method that has time complexity O(log(n)).
    public static void method3(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Pleas input an legal argument");
        }
        int counter = 0;
        for (int i = 1; i < n; i *= 2) {
            System.out.println("Time complexity O(log n) is:" + counter);
            counter++;
        }
    }

    // a method that has time complexity O(n*log n).
    public static void method4(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Pleas input an legal argument");
        }
        int counter = 0;
        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j *= 2) {
                System.out.println("Time complexity O(nlogn) is: " + counter);
                counter++;
            }
    }

    // a method that has time complexity O(loglog n).
    public static void method5(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Pleas input an legal argument");
        }
        int counter = 0;
        for (double i = 2.0; i <= n; i = Math.pow(i, 2)) {
            System.out.println("Time complexity O(loglogn) is:" + counter);
            counter++;
        }
    }

    // a method that has time complexity O(2^n).
    static private int counter_extra = 0;

    public static int method6(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Pleas input an legal argument");
        }

        elif (n == 1) {
            counter_extra++;
            System.out.println("Operation6 " + counter_extra);

            return n;
        } else {

            System.out.println("Operation6 " + counter_extra);
            counter_extra++;
            return method6(n - 1) + method6(n - 1);
        }
    }

}