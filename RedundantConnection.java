package StiverGraphs;

import java.util.*;

public class RedundantConnection {

    public static void main(String args[]) {
        int matrix[][] = {
                // { 1, 2 },
                // { 2, 3 },
                // { 3, 4 },
                // { 1, 4 },
                // { 1, 5 }
                {1,2},
                {1,3},
                {2,3}
        };
        int ans[] = util1(matrix);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] util1(int matrix[][]) {
        if (matrix.length == 0) {
            return new int[0];
        }
        List<ArrayList<Integer>> adj = new ArrayList<>(matrix.length+1);
        for (int i = 0; i <= matrix.length; i++) {
            adj.add(new ArrayList<Integer>());
        }
        boolean visited[] = new boolean[matrix.length+1];
        for (int current[] : matrix) {
            Arrays.fill(visited, false);
            adj.get(current[0]).add(current[1]);
            adj.get(current[1]).add(current[0]);
            boolean smallAns = dfs(adj, visited, current[0], -1);
            if (smallAns == true) {
                return current;
            }
        }
        return new int[2];
    }

    // normal detection of cycle in undirected graph
    private static boolean dfs(List<ArrayList<Integer>> adj, boolean visited[], int src, int parent) {
        if (visited[src] == true) {
            return true;
        }
        visited[src] = true;
        ArrayList<Integer> currentList = adj.get(src);
        for (int i : currentList) {
            if (visited[i] == false) {
                boolean smallAns = dfs(adj, visited, i, src);
                if (smallAns) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }
}
