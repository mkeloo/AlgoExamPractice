
public class Main {

    // Add space between demos for readability function
    public static void printSpace() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Gale-Shapely Demo
        System.out.println("Gale-Shapely Demo:");
        GaleShapley.run();
        printSpace();

        // Algorithm Runtime Complexity Analysis Demo
        System.out.println("Algorithm Runtime Complexity Analysis Demo:");
        AlgorithmComplexity.run();
        printSpace();

  }
}