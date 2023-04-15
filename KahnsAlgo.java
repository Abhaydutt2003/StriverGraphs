package StiverGraphs;

import java.util.*;

public class KahnsAlgo {

    public static void main(String args[]) {

    }

    static int[] indegree;
    static boolean visited[];

    public static int[] util1(int V, ArrayList<ArrayList<Integer>> adj) {
        constIndegree(adj, V);
        return bfsModified(adj, V);
    }

    private static void constIndegree(ArrayList<ArrayList<Integer>> adj, int V) {
        indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int a : adj.get(i)) {
                indegree[a]++;
            }
        }
    }

    private static int[] bfsModified(ArrayList<ArrayList<Integer>> adj, int V) {
        visited = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int k = 0;
        int ans[] = new int[V];
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ans[k++] = currentNode;
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return ans;
    }
}
