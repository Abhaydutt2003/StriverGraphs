package StiverGraphs;

import java.util.*;

public class BellmanFord {

    public static void main(String args[]) {

    }

    public static int[] util1(int V, ArrayList<ArrayList<Integer>> edges, int s) {
        int distance[] = new int[V];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = (int)(1e8);
        }
        distance[s] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> a : edges) {
                int currentNode = a.get(0);
                int nextNode = a.get(1);
                int weight = a.get(2);
                if (distance[currentNode] != (int)(1e8)) {
                    if (distance[nextNode] > weight + distance[currentNode]) {
                        distance[nextNode] = weight + distance[currentNode];
                    }
                }
            }
        }

        // the nth iteration to check negative cycle
        for (ArrayList<Integer> a : edges) {
            int currentNode = a.get(0);
            int nextNode = a.get(1);
            int weight = a.get(2);
            if (distance[currentNode] != (int)(1e8)) {
                if (distance[nextNode] > weight + distance[currentNode]) {
                    int temp[] = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
        }


        return distance;
    }

}
