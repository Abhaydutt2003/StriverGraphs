package StiverGraphs;

import java.util.*;

public class KosarajuAlgorithm {

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(4);

        System.out.print(util1(5, adj));
    }

    static Stack<Integer> s;
    static boolean visited[];
    static boolean visited2[];
    static ArrayList<ArrayList<Integer>> reverseAdj;

    public static int util1(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        s = new Stack<>();

        //making the reverse adjList
        reverseAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseAdj.add(new ArrayList<>());
        }

        //filling the reverseAdj,while putting the elements in stack
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                reverseEdges(adj, i);
            }
        }

        //now simply checking the number of scc
        visited2 = new boolean[V];
        int ans = 0;
        while (s.isEmpty() == false) {
            int node = s.pop();
            if (visited2[node] == false) {
                ans++;
                dfs(node);
            }
        }
        return ans;
    }

    public static void reverseEdges(ArrayList<ArrayList<Integer>> adj, int source) {
        if (visited[source] == true) {
            return;
        }
        visited[source] = true;
        ArrayList<Integer> currentList = adj.get(source);
        for (Integer node : currentList) {
            reverseAdj.get(node).add(source);
            reverseEdges(adj, node);
        }
        s.add(source);
    }

    public static void dfs(int source) {
        if (visited2[source] == true) {
            return;
        }
        visited2[source] = true;
        ArrayList<Integer> currentList = reverseAdj.get(source);
        for (Integer node : currentList) {
            dfs(node);
        }
    }

}
