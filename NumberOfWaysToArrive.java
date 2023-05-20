package StiverGraphs;

import java.util.*;

public class NumberOfWaysToArrive {

    public static void main(String args[]) {
        int n = 7;
        int arr[][] = {
                // {0,4,4},
                // {0,1,1},
                // {1,2,1},
                // {2,1,1},
                // {3,1,1}
                { 0, 6, 7 },
                { 0, 1, 2 },
                { 1, 2, 3 },
                { 1, 3, 3 },
                { 6, 3, 3 },
                { 3, 5, 1 },
                { 6, 5, 1 },
                { 2, 5, 1 },
                { 0, 4, 5 },
                { 4, 6, 2 }
        };
        System.out.print(util1(n, arr));

    }

    // public static int util1(int n, int[][] roads) {
    // int start = 0, end = n - 1;
    // ArrayList<ArrayList<int[]>> adj = getAdj(roads, n);
    // int distance[] = new int[n];
    // for (int i = 0; i < distance.length; i++) {
    // distance[i] = Integer.MAX_VALUE;
    // }
    // int ans = 0;
    // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    // //wQueue<int[]> pq = new LinkedList<>();
    // pq.add(new int[] { start, 0 });
    // while (pq.isEmpty() == false) {
    // int[] current = pq.poll();
    // int currentNode = current[0];
    // int currWt = current[1];
    // ArrayList<int[]> currentList = adj.get(currentNode);
    // for (int[] a : currentList) {
    // int node = a[0];
    // int wt = a[1];
    // if (node == end) {
    // if (currWt + wt < distance[node]) {
    // ans = 1;
    // distance[node] = currWt + wt;
    // } else if (currWt + wt == distance[node]) {
    // ans++;
    // }
    // } else {
    // if (currWt + wt < distance[node]) {
    // distance[node] = currWt + wt;
    // pq.add(new int[] { node, currWt + wt });
    // } else if (currWt + wt == distance[node]) {
    // pq.add(new int[] { node, currWt + wt });
    // }
    // }
    // }
    // }
    // return ans;
    // }

    public static ArrayList<ArrayList<int[]>> getAdj(int roads[][], int n) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new int[] { roads[i][1], roads[i][2] });
            adj.get(roads[i][1]).add(new int[] { roads[i][0], roads[i][2] });
        }
        return adj;
    }

    static int mod = (int) (1e9 + 7);

    public static int util1(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = getAdj(roads, n);
        int distance[] = new int[n];
        int ways[] = new int[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { 0, 0 });
        distance[0] = 0;
        ways[0] = 1;
        while (pq.isEmpty() == false) {
            int currWt = pq.peek()[1];
            int currNode = pq.poll()[0];
            ArrayList<int[]> currList = adj.get(currNode);
            for (int[] a : currList) {
                int node = a[0];
                int wt = a[1];

                if (distance[node] > currWt + wt) {
                    distance[node] = currWt + wt;
                    ways[node] = ways[currNode];
                    pq.add(new int[] { node, currWt + wt });
                } else if (distance[node] == currWt + wt) {
                    ways[node] = (ways[node] + ways[currNode])%mod;
                }

            }
        }
        return ways[n - 1] % mod;
    }

}
