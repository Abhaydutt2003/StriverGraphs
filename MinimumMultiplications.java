package StiverGraphs;

import java.lang.reflect.Array;
import java.util.*;

public class MinimumMultiplications {

    public static void main(String args[]) {
        int arr[] = { 3, 4, 65 };
        int start = 7;
        int end = 66175;
        System.out.print(util1(arr, start, end));
    }

    public static int util1(int arr[], int start, int end) {
        int distance[] = new int[100000];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<int[]>();
        distance[start] = 0;
        q.add(new int[] { start, 0 });
        while (q.isEmpty() == false) {
            int currentNode = q.peek()[0];
            int currentWt = q.poll()[1];
            for (int i : arr) {
                int node = (currentNode * i) % 100000;
                int wt = currentWt + 1;
                if (node == end) {
                    return wt;
                }
                if (distance[node] > wt) {
                    distance[node] = wt;
                    q.add(new int[] { node, wt });
                }
            }
        }
        return -1;
    }

}
