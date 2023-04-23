package StiverGraphs;

import java.util.*;

public class ShortestPathInDAG {

    public static void main(String args[]) {
        int n = 7;
        int matrix[][] = {
                { 0, 1, 2 },
                { 0, 4, 1 },
                { 4, 5, 4 },
                { 4, 2, 2 },
                { 1, 2, 3 },
                { 2, 3, 6 },
                { 5, 3, 1 }
        };

        int arr[] = util1(n, matrix);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static Stack<Integer> s = new Stack<>();
    static boolean visited[];

    public static int[] util1(int N, int edges[][]) {
        ArrayList<ArrayList<myPair>> adj = constAdj(edges, N);

        visited = new boolean[N];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                dfs(adj, i);
            }
        }

        int distance[] = getAns(adj, N);
        return distance;
    }

    private static ArrayList<ArrayList<myPair>> constAdj(int edges[][], int n) {
        ArrayList<ArrayList<myPair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new myPair(edges[i][1], edges[i][2]));
        }

        return adj;
    }

    private static void dfs(ArrayList<ArrayList<myPair>> adj, int vertex) {
        visited[vertex] = true;
        ArrayList<myPair> currentList = adj.get(vertex);
        for (myPair a : currentList) {
            if (visited[a.x] == false) {
                dfs(adj, a.x);
            }
        }
        s.add(vertex);
    }

    private static int[] getAns(ArrayList<ArrayList<myPair>> adj, int N) {
        int[] distance = new int[N];

        for (int i = 0; i < distance.length; i++) {
            distance[i] = (int) (1e9);
        }

        distance[0] = 0;

        while (s.isEmpty() == false) {
            int currentNode = s.pop();
            ArrayList<myPair> currentList = adj.get(currentNode);
            for (myPair a : currentList) {
                if (distance[currentNode] + a.y < distance[a.x]) {
                    distance[a.x] = distance[currentNode] + a.y;
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == 1e9) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}
