package StiverGraphs;

import java.util.*;

public class GFGNumberOfIslands2 {

    public static void main(String args[]) {
        
    }

    static int xdir[] = { 0, 0, 1, -1 };
    static int ydir[] = { 1, -1, 0, 0 };

    public static List<Integer> util1(int rows, int cols, int[][] operators) {
        int n = rows;
        int m = cols;
        boolean visited[][] = new boolean[n][m];
        DisjointSet2 ds = new DisjointSet2(n * m);
        List<Integer> ans = new ArrayList<>();
        int numberComp = 0;
        for (int i = 0; i < operators.length; i++) {
            int currRow = operators[i][0];
            int currCol = operators[i][1];

            if (visited[currRow][currCol]) {
                ans.add(numberComp);
                continue;
            }

            visited[currRow][currCol] = true;
            numberComp++;
            for (int a = 0; a < xdir.length; a++) {
                int x = currRow + xdir[a];
                int y = currCol + ydir[a];
                if (x >= 0 && y >= 0 && x < visited.length && y < visited[0].length && visited[x][y] == true) {
                    int node1 = (x * m) + y;
                    int node2 = (currRow * m) + currCol;
                    if (ds.ultimateParent(node2) != ds.ultimateParent(node1)) {
                        ds.unionBySize(node1, node2);
                        numberComp--;
                    }
                }
            }
            ans.add(numberComp);
        }
        return ans;
    }

}
