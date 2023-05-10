package StiverGraphs;

import java.util.*;

class nodeWeightPair {
    int node;
    int weight;

    nodeWeightPair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class ShortestPathInUndirectedWeightedGraph {

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 2, 2 },
                { 2, 5, 5 },
                { 2, 3, 4 },
                { 1, 4, 1 },
                { 4, 3, 3 },
                { 3, 5, 1 }
        };
        List<Integer> ans = util1(5, 6, matrix);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> util1(int n, int m, int edges[][]) {
        ArrayList<ArrayList<nodeWeightPair>> adj = getAdj(n, edges);
        int parent[] = new int[n + 1];
        int distance[] = new int[n + 1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        Queue<nodeWeightPair> q = new LinkedList<>();
        distance[1] = 0;
        q.add(new nodeWeightPair(1, 0));
        while (q.isEmpty() == false) {
            nodeWeightPair polled = q.poll();
            int currentNode = polled.node;
            int currentWeight = polled.weight;
            ArrayList<nodeWeightPair> currentList = adj.get(currentNode);
            for (nodeWeightPair nwp : currentList) {
                int adjNode = nwp.node;
                int adjWeight = nwp.weight;
                if (currentWeight + adjWeight < distance[adjNode]) {
                    distance[adjNode] = currentWeight + adjWeight;
                    q.add(new nodeWeightPair(adjNode, currentWeight + adjWeight));
                    parent[adjNode] = currentNode;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (distance[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }
        int node = n;
        while (node != parent[node]) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }

    public static ArrayList<ArrayList<nodeWeightPair>> getAdj(int n, int matrix[][]) {
        ArrayList<ArrayList<nodeWeightPair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            adj.get(matrix[i][0]).add(new nodeWeightPair(matrix[i][1], matrix[i][2]));
            adj.get(matrix[i][1]).add(new nodeWeightPair(matrix[i][0], matrix[i][2]));
        }
        return adj;
    }
}
