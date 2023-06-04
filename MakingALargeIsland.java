package StiverGraphs;

import java.util.*;

public class MakingALargeIsland {

    public static void main(String args[]) {
        int matrix[][] = {
                // { 0, 0, 0, 0, 0, 0, 0 },
                // { 0, 1, 1, 1, 1, 0, 0 },
                // { 0, 1, 0, 0, 1, 0, 0 },
                // { 1, 0, 1, 0, 1, 0, 0 },
                // { 0, 1, 0, 0, 1, 0, 0 },
                // { 0, 1, 0, 0, 1, 0, 0 },
                // { 0, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0 },
                { 0, 0, 1, 1, 1, 0 }
                // {1,1},
                // {1,1}
        };
        System.out.print(util2(matrix));
    }

    static int xdir[] = { 0, 0, 1, -1 };
    static int ydir[] = { 1, -1, 0, 0 };

    static DisjointSet2 d;
    static boolean visited[][];

    public static int util2(int[][] grid) {
        constD(grid);
        int ans = getAns(grid);
        return ans;
    }

    public static void constD(int[][] grid) {
        d = new DisjointSet2(grid.length * grid.length);
        visited = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else {
                    visited[i][j] = true;
                    dfs(grid, i, j);
                }
            }
        }
    }

    public static void dfs(int grid[][], int i, int j) {
        for (int a = 0; a < xdir.length; a++) {
            int x = i + xdir[a];
            int y = j + ydir[a];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && grid[x][y] == 1 && visited[x][y] == false) {
                int node1 = i * grid.length + j;
                int node2 = x * grid.length + y;
                d.unionBySize(node2, node1);
                visited[x][y] = true;
                dfs(grid, x, y);
            }
        }
    }

    public static int getAns(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                HashSet<Integer> hs = new HashSet<>();
                int smallAns = 0;
                for (int a = 0; a < xdir.length; a++) {
                    int x = i + xdir[a];
                    int y = j + ydir[a];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && grid[x][y] == 1) {
                        int node = x * grid.length + y;
                        hs.add(d.ultimateParent(node));
                    }
                }
                for (Integer parent : hs) {
                    smallAns += (d.size[parent] + 1);
                }
                ans = Math.max(ans, (smallAns + 1));
            }
        }
        ans = Math.max(ans, (d.size[0] + 1));
        return ans;
    }

}
