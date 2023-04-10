package StiverGraphs;

import java.util.*;

class myPair {
    int x;
    int y;

    myPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FloodFill {

    static int theColor = 0;
    static boolean visitedArray[][];

    public static void util2(int matrix[][], int i, int j, int toPut) {
        matrix[i][j] = toPut;
        for (int a = 0; a < xdir.length; a++) {
            int x = xdir[a] + i;
            int y = ydir[a] + j;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == theColor
                    && visitedArray[x][y] == false) {
                visitedArray[x][y] = true;
                util2(matrix, x, y, toPut);
            }
        }
    }

    public static void main(String args[]) {
        int matrix[][] = {
                // { 1, 1, 1 },
                // { 1, 1, 0 },
                // { 1, 0, 0 }
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        // util1(matrix,1,1,2);

        visitedArray = new boolean[matrix.length][matrix[0].length];
        visitedArray[0][0] = true;
        theColor = matrix[0][0];
        util2(matrix, 0, 0, 0);
        for (int[] j : matrix) {
            for (int i : j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static int xdir[] = { 1, -1, 0, 0 };
    static int ydir[] = { 0, 0, 1, -1 };

    public static void util1(int matrix[][], int i, int j, int toPut) {
        int originalColor = matrix[i][j];
        Queue<myPair> q = new LinkedList<myPair>();
        boolean[][] visitedArray = new boolean[matrix.length][matrix[0].length];
        q.add(new myPair(i, j));
        visitedArray[i][j] = true;
        while (q.isEmpty() == false) {
            myPair currentNode = q.poll();
            matrix[currentNode.x][currentNode.y] = toPut;
            for (int a = 0; a < xdir.length; a++) {
                int x = currentNode.x + xdir[a];
                int y = currentNode.y + ydir[a];
                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && visitedArray[x][y] == false
                        && matrix[x][y] == originalColor) {
                    visitedArray[x][y] = true;
                    q.add(new myPair(x, y));
                }
            }
        }
    }

}
