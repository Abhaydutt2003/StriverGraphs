package StiverGraphs;

import java.util.*;

public class CheapestFlights {

    public static void main(String args[]) {
        int flights[][] = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 }
        };
        int src = 0;
        int dst = 1;
        int k = 1;
        System.out.print(util1(4, flights, src, dst, k));
    }

    public static int util1(int n, int matrix[][], int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            adj.get(matrix[i][0]).add(new int[] { matrix[i][1], matrix[i][2] });
        }
        int[] costArr = new int[n];
        for (int i = 0; i < costArr.length; i++) {
            costArr[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0, 0 });
        while (q.isEmpty() == false) {
            int[] current = q.poll();
            int currNode = current[0];
            int costTillNow = current[1];
            int steps = current[2];
            if (steps > k) {
                continue;
            }
            ArrayList<int[]> currentList = adj.get(currNode);
            for (int[] a : currentList) {
                int node = a[0];
                int cost = a[1];
                if (cost + costTillNow < costArr[node]) {
                    costArr[node] = cost + costTillNow;
                    q.add(new int[] { node, cost + costTillNow, steps + 1 });
                }
            }
        }
        if (costArr[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return costArr[dst];
    }

}
