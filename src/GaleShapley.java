import java.util.Arrays;

public class GaleShapley {

    // fix these errors:
//    java: constructor GaleShapley in class GaleShapley cannot be applied to given types;
//    required: int[][],int[][]




    private int N;
    private int[][] menPreferences;
    private int[][] womenPreferences;
    private int[] womenPartners;
    private boolean[] menEngaged;

    public GaleShapley(int[][] menPreferences, int[][] womenPreferences) {
        N = menPreferences.length;
        this.menPreferences = menPreferences;
        this.womenPreferences = womenPreferences;
        womenPartners = new int[N];
        menEngaged = new boolean[N];
        Arrays.fill(womenPartners, -1);
        match();
    }

    private void match() {
        while (true) {
            int freeMan = -1;
            for (int i = 0; i < N; i++) {
                if (!menEngaged[i]) {
                    freeMan = i;
                    break;
                }
            }
            if (freeMan == -1) break; // All men are engaged

            for (int i = 0; i < N && !menEngaged[freeMan]; i++) {
                int woman = menPreferences[freeMan][i];
                if (womenPartners[woman] == -1) {
                    womenPartners[woman] = freeMan;
                    menEngaged[freeMan] = true;
                } else {
                    int currentMan = womenPartners[woman];
                    if (prefersNewMan(woman, currentMan, freeMan)) {
                        womenPartners[woman] = freeMan;
                        menEngaged[freeMan] = true;
                        menEngaged[currentMan] = false;
                    }
                }
            }
        }
    }

    private boolean prefersNewMan(int woman, int currentMan, int newMan) {
        for (int i = 0; i < N; i++) {
            if (womenPreferences[woman][i] == newMan) return true;
            if (womenPreferences[woman][i] == currentMan) return false;
        }
        return false;
    }

    public void printMatches() {
        for (int i = 0; i < N; i++) {
            System.out.println("Woman " + i + " is engaged to Man " + womenPartners[i]);
        }
    }


    public static void run() {
        int[][] menPreferences = {
                {0, 1, 2},
                {1, 0, 2},
                {0, 2, 1}
        };

        int[][] womenPreferences = {
                {1, 0, 2},
                {0, 1, 2},
                {1, 2, 0}
        };

        GaleShapley gs = new GaleShapley(menPreferences, womenPreferences);
        gs.printMatches();
    }


}
