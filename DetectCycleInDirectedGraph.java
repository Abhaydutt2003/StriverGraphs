package StiverGraphs;

import java.util.*;

public class DetectCycleInDirectedGraph {

    public static void main(String args[]) {

    }

    static boolean pathVisited[];
    static boolean visited[];

    public static boolean util1(int V, ArrayList<ArrayList<Integer>> adj) {
        pathVisited = new boolean[V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                boolean smallAns = dfs(adj, i);
                if (smallAns) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int current) {
        visited[current] = true;
        pathVisited[current] = true;
        ArrayList<Integer> currList = adj.get(current);
        for (int i : currList) {
            if (visited[i] == false) {
                boolean smallAns = dfs(adj, i);
                if (smallAns) {
                    return true;
                }
            } else if (visited[i] == true && pathVisited[i] == true) {
                return true;
            }
        }
        pathVisited[current] = false;//backtracking
        return false;
    }

}
