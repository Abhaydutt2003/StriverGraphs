package StiverGraphs;

import java.util.*;

class lc1091Helper {
    int x;
    int y;
    int distance;

    lc1091Helper(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class ShortestPathInBinaryMatrix {

    // leetcode 1091
    public static void main(String aegs[]) {
        int matrix[][] = {
                // { 0, 0, 0 },
                // { 1, 1, 0 },
                // { 1, 1, 0 }
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
                // {0,0},
                // {0,0}
        };
        System.out.print(util1(matrix));
    }

    // using normal bfs
    public static int util1(int[][] matrix) {
        int n = matrix.length;
        if (matrix[0][0] != 0 || matrix[n - 1][n - 1] != 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        int distance[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<lc1091Helper> q = new LinkedList<>();
        q.add(new lc1091Helper(0, 0, 0));
        distance[0][0] = 0;
        while (q.isEmpty() == false) {
            lc1091Helper lc = q.poll();
            int currX = lc.x;
            int currY = lc.y;
            int currDis = lc.distance;
            for (int i = 0; i < xdir.length; i++) {
                int x = xdir[i] + currX;
                int y = ydir[i] + currY;
                if (x == n - 1 && y == n - 1) {
                    return currDis + 2;
                }
                if (x >= 0 && x < n && y >= 0 && y < n && matrix[x][y] == 0 && currDis + 1 < distance[x][y]) {
                    distance[x][y] = currDis + 1;
                    q.add(new lc1091Helper(x, y, currDis + 1));
                }
            }
        }
        return -1;
    }

    static int[] xdir = { 1, -1, 0, 0, 1, -1, 1, -1 };
    static int[] ydir = { 0, 0, 1, -1, 1, 1, -1, -1 };

}
