package StiverGraphs;

import java.util.*;

public class NumberOfDistinctIslands {

    public static void main(String agrs[]) {
        int matrix[][] = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 }
        };
        System.out.print(util1(matrix));
    }

    static boolean visited[][];

    public static int util1(int[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        HashSet<ArrayList<String>> hs = new HashSet<ArrayList<String>>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == false && matrix[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<String>();
                    dfs(i, j, matrix, i, j, vec);
                    hs.add(vec);
                }
            }
        }
        return hs.size();
    }

    private static void dfs(int i, int j, int matrix[][], int basei, int basej, ArrayList<String> vec) {
        if (visited[i][j] == true) {
            return;
        }
        vec.add(util2(i, j, basei, basej));
        visited[i][j] = true;
        for (int a = 0; a < xdir.length; a++) {
            int x = i + xdir[a];
            int y = ydir[a] + j;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 1) {
                dfs(x, y, matrix, basei, basej, vec);
            }
        }
    }

    private static String util2(int i, int j, int basei, int basej) {
        int a = i - basei;
        int b = j - basej;
        String as = Integer.toString(a);
        String bs = Integer.toString(b);
        String toReturn = as + " " + bs;
        return toReturn;
    }

    static int[] xdir = { 0, 0, -1, 1 };
    static int[] ydir = { 1, -1, 0, 0 };

}
