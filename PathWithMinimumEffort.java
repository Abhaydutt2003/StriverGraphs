package StiverGraphs;

import java.util.*;

class threePair {
    int first;
    int second;
    int third;

    threePair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class PathWithMinimumEffort {

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 }
        };

        System.out.print(util2(matrix));
    }

    public static int util1(int matrix[][]) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return 0;
        }
        int effort[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < effort.length; i++) {
            for (int j = 0; j < effort[0].length; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<threePair> q = new LinkedList<>();
        q.add(new threePair(0, 0, 0));
        while (q.isEmpty() == false) {
            threePair l = q.poll();
            int currX = l.first;
            int currY = l.second;
            int currDis = l.third;
            for (int i = 0; i < xdir.length; i++) {
                int x = currX + xdir[i];
                int y = currY + ydir[i];
                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length) {
                    int candidate = Math.max(Math.abs(matrix[currX][currY] - matrix[x][y]), currDis);
                    if (candidate < effort[x][y]) {
                        effort[x][y] = candidate;
                        q.add(new threePair(x, y, candidate));
                    }
                }
            }
        }
        return effort[matrix.length - 1][matrix[0].length - 1];
    }

    static int xdir[] = { 1, -1, 0, 0 };
    static int ydir[] = { 0, 0, 1, -1 };

    // optimised version

    public static int util2(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return 0;
        }
        int effort[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0,0,0});
        while(pq.isEmpty() == false){
            int [] current = pq.poll();
            int currX = current[0];
            int currY = current[1];
            int currEff = current[2];
            for(int i = 0;i<xdir.length;i++){
                int x = currX+xdir[i];
                int y = currY+ydir[i];
                if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length ){
                    int candidate = Math.max(currEff,Math.abs(matrix[currX][currY] - matrix[x][y]));
                    if(candidate < effort[x][y]){
                        effort[x][y] = candidate;
                        pq.add(new int[] {x,y,candidate});
                    }
                }
            }
        }
        return effort[effort.length-1][effort[0].length-1];
    }

}
