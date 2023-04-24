package StiverGraphs;

import java.util.*;

public class ShortestPathInUnDirectedUnit {

    public static void main(String args[]) {
        int matrix[][] = {
                { 0, 1 },
                { 0, 3 },
                { 3, 4 },
                { 4, 5 },
                { 5, 6 },
                { 1, 2 },
                { 2, 6 },
                { 6, 7 },
                { 7, 8 },
                { 6, 8 }
        };

        int ans[] = util1(matrix, 9, 0);
        for (int i : ans) {
            System.out.println(i + " ");
        }
    }

    public static int[] util1(int edges[][], int n, int source) {
        ArrayList<ArrayList<Integer>> adj = getAdj(edges, n);

        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        q.add(source);
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                if (distance[currentNode] + 1 < distance[i]) {
                    distance[i] = distance[currentNode] + 1;
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    public static ArrayList<ArrayList<Integer>> getAdj(int edges[][], int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        return adj;
    }

}
