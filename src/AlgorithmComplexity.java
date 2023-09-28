import java.util.Arrays;
import java.util.ArrayList;

public class AlgorithmComplexity {

    // Sample data
    private static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int[][] matrixData = {
            {1, 2},
            {3, 4}
    };

    // O(1) - Constant time complexity
    public static void constantTime() {
        System.out.println("Constant time complexity O(1):");
        System.out.println(data[0]);
    }

    // O(log n) - Logarithmic time complexity
    public static void logarithmicTime() {
        System.out.println("Logarithmic time complexity O(log n):");
        int n = data.length;
        while (n > 1) {
            System.out.println(n);
            n /= 2;
        }
    }

    // O(√n) - Square root time complexity
    public static void squareRootTime() {
        System.out.println("Square root time complexity O(√n):");
        for (int i = 1; i*i <= data.length; i++) {
            System.out.println(data[i]);
        }
    }

    // O(n) - Linear time complexity
    public static void linearTime() {
        System.out.println("Linear time complexity O(n):");
        for (int num : data) {
            System.out.println(num);
        }
    }

    // O(n log n) - Loglinear time complexity
    public static void logLinearTime() {
        System.out.println("Loglinear time complexity O(n log n):");
        // Using Arrays.sort as an example, though the actual operation is hidden
        int[] sortedData = Arrays.copyOf(data, data.length);
        Arrays.sort(sortedData);
        for (int num : sortedData) {
            System.out.println(num);
        }
    }

    // O(n√n) - n * Square root of n time complexity
    public static int countSquareFactors(int[] arr) {
        int count = 0;
        for (int num : arr) {
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (i * i == num) count++;
            }
        }
        return count;
    }


    // O(n^c) - Polynomial time complexity (Matrix Multiplication as an example)
    public static void polynomialTime() {
        System.out.println("Polynomial time complexity O(n^c):");
        int n = matrixData.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrixData[i][k] * matrixData[k][j];
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // The other complexities (O(c^n), O(n!), and O(n^n)) require more involved examples or are impractical for
    // actual demonstration due to their high computational requirements.


    // O(c^n) - Exponential time complexity
    public static int exponentialTime(int n) {
        if (n <= 1) return n;
        return exponentialTime(n - 1) + exponentialTime(n - 2);
    }

    // O(n!) - Factorial time complexity
    public static void factorialTime(int n) {
        System.out.println("Factorial time complexity O(n!):");
        permute(data, 0, n - 1);
    }

    private static void permute(int[] arr, int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, r);
                swap(arr, l, i); // backtrack
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // O(n^n) - Exponential of exponential time complexity
    public static void exponentialExponentialTime(int n) {
        System.out.println("Exponential of exponential time complexity O(n^n):");
        if (n <= 0) return;
        for (int i = 0; i < n; i++) {
            exponentialExponentialTime(n - 1);
        }
    }



    // Demo function to run all the complexities
    public static void run() {

        /*
        *
            | Complexity     | Description                                    |
            |----------------|------------------------------------------------|
         1  | O(1)           | Constant time complexity                       |
         2  | O(log n)       | Logarithmic time complexity                    |
         3  | O(√n)          | Square root time complexity                    |
         4  | O(n)           | Linear time complexity                         |
         5  | O(n log n)     | LogLinear time complexity                      |
         6  | O(√n)          | n * Square root of n time complexity           |
         7  | O(n^c)         | Polynomial time complexity                     |
         8  | O(c^n)         | Exponential time complexity                    |
         9  | O(n!)          | Factorial time complexity                      |
        10  | O(n^n)         | Exponential of exponential time complexity     |

        *
        * */


        // 1. O(1) - Constant time complexity
        constantTime();

        // 2. O(log n) - Logarithmic time complexity
        logarithmicTime();

        // 3. O(√n) - Square root time complexity
        squareRootTime();

        // 4. O(n) - Linear time complexity
        linearTime();

        // 5. O(n log n) - Loglinear time complexity
        logLinearTime();

        // 6. O(n√n) - n * Square root of n time complexity
        countSquareFactors(data);

        // 7. O(n^c) - Polynomial time complexity (Matrix Multiplication as an example)
        polynomialTime();

        // 8. O(c^n) - Exponential time complexity
        exponentialTime(10);

        // 9. O(n!) - Factorial time complexity
        factorialTime(3);

        // 10. O(n^n) - Exponential of exponential time complexity
        exponentialExponentialTime(2);


    }
}
