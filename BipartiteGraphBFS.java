package StiverGraphs;

import java.util.*;

public class BipartiteGraphBFS {

    public static void main(String agrs[]) {
        int matrix[][] = {
                // { 1, 2, 3 },
                // { 0, 2 },
                // { 0, 1, 3 },
                // { 0, 2 }
                { 1, 3 },
                { 0, 2 },
                { 1, 3 },
                { 0, 2 }
        };
        System.out.print(util1(matrix));
    }

    static int colorArray[];

    public static boolean util1(int matrix[][]) {
        colorArray = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (colorArray[i] == 0) {
                boolean smallAns = bfs(matrix, i);
                if (smallAns == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(int matrix[][], int vertex) {
        colorArray[vertex] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(vertex);
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            int currentArray[] = matrix[currentNode];
            for (int i : currentArray) {
                if (colorArray[i] == 0) {
                    if (colorArray[currentNode] == 1) {
                        colorArray[i] = 2;
                    } else {
                        colorArray[i] = 1;
                    }
                    q.add(i);
                } else if (colorArray[currentNode] == colorArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }

}
