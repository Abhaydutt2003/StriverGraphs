package StiverGraphs;

import java.util.*;

public class TopologicalSort {

    public static void main(String args[]) {

    }

    static boolean visited[];
    static Stack<Integer> sorted;

    public static int[] util1(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        sorted = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(adj, i);
            }
        }
        int arr[] = new int[sorted.size()];
        int k = 0;
        while (sorted.isEmpty() == false) {
            arr[k++] = sorted.pop();
        }
        return arr;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int vertex) {
        visited[vertex] = true;
        ArrayList<Integer> currentList = adj.get(vertex);
        for (int i : currentList) {
            if (visited[i] == false) {
                dfs(adj, i);
            }
        }
        sorted.push(vertex);
    }
}
