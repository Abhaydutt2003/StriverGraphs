package StiverGraphs;

import java.util.*;

public class TarjanForBridge {

    public static void main(String args[]) {
        int n = 9;
        List<List<Integer>> connections = new ArrayList<>();
        // connections.add(Arrays.asList(0, 1));
        // connections.add(Arrays.asList(1, 2));
        // connections.add(Arrays.asList(2, 0));
        // connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(0, 2));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 3));
        connections.add(Arrays.asList(3, 4));
        connections.add(Arrays.asList(2, 5));
        connections.add(Arrays.asList(5, 8));
        connections.add(Arrays.asList(8, 7));
        connections.add(Arrays.asList(7, 6));
        connections.add(Arrays.asList(6, 5));
        System.out.print(util1(n, connections));
    }

    static boolean visited[];

    static int inTime[];
    static int low[];

    static List<List<Integer>> bridges;

    public static List<List<Integer>> util1(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = getAdj(n, connections);
        visited = new boolean[n];
        inTime = new int[n];
        low = new int[n];
        bridges = new ArrayList<>();
        dfs(adj, 1, 0, -1);
        return bridges;
    }

    public static ArrayList<ArrayList<Integer>> getAdj(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> a : connections) {
            int node1 = a.get(0);
            int node2 = a.get(1);
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        return adj;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int timer, int node, int parent) {
        visited[node] = true;
        inTime[node] = low[node] = timer;
        ArrayList<Integer> currentList = adj.get(node);
        for (Integer i : currentList) {
            if (i == parent) {
                continue;
            } else {
                if (visited[i] == true) {
                    low[node] = Math.min(low[node], low[i]);
                } else {
                    dfs(adj, timer + 1, i, node);
                    low[node] = Math.min(low[node], low[i]);
                    if (low[i] > inTime[node]) {
                        bridges.add(Arrays.asList(node, i));
                    }
                }
            }
        }
    }

}
