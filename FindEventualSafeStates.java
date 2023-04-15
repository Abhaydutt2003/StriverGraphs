package StiverGraphs;

import java.util.*;

public class FindEventualSafeStates {

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 2 },
                { 2, 3 },
                { 5 },
                { 0 },
                { 5 },
                {},
                {}
        };
        List<Integer> arr = util1(matrix);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    static boolean isSafe[];

    static boolean visited[];
    static boolean visitedPath[];

    public static List<Integer> util1(int matrix[][]) {
        visited = new boolean[matrix.length];
        visitedPath = new boolean[matrix.length];
        isSafe = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == false) {
                dfs(matrix, i);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < isSafe.length; i++) {
            if (isSafe[i] == true) {
                ans.add(i);
            }
        }
        return ans;
    }

    // code to detect cycle in directed graph..
    private static boolean dfs(int matrix[][], int current) {
        visited[current] = true;
        visitedPath[current] = true;
        int currentConnections[] = matrix[current];
        for (int i : currentConnections) {
            if (visited[i] == false) {
                boolean smallAns = dfs(matrix, i);
                if (smallAns) {
                    return true;
                }
            } else if ( visited[i] == true && visitedPath[i] == true) {
                return true;
            }
        }
        isSafe[current] = true;
        visitedPath[current] = false;
        return false;
    }

}
