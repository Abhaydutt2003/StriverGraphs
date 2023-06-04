package StiverGraphs;

import java.util.*;

public class MakingALargeIsland {

    public static void main(String args[]) {
        int matrix[][] = {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 0, 0 },
                { 1, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 1, 1, 0, 0 },
                // { 1, 1, 0, 1, 1, 0 },
                // { 1, 1, 0, 1, 1, 0 },
                // { 1, 1, 0, 1, 1, 0 },
                // { 0, 0, 1, 0, 0, 0 },
                // { 0, 0, 1, 1, 1, 0 },
                // { 0, 0, 1, 1, 1, 0 }
                // {1,1},
                // {1,1}
        };
        System.out.print(util3(matrix));
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

    public static int util3(int grid[][]) {
        DisjointSet3 ds = new DisjointSet3(grid.length * grid.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else {
                    for (int a = 0; a < xdir.length; a++) {
                        int x = xdir[a] + i;
                        int y = ydir[a] + j;
                        if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && grid[x][y] == 1) {
                            int node1 = (i * grid.length) + j;
                            int node2 = (x * grid.length) + y;
                            if (ds.ultimateParent(node1) != ds.ultimateParent(node2)) {
                                ds.unionBySize(node1, node2);
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                } else {
                    int smallAns = 0;
                    HashSet<Integer> hs = new HashSet<>();
                    for (int a = 0; a < xdir.length; a++) {
                        int x = xdir[a] + i;
                        int y = ydir[a] + j;
                        if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && grid[x][y] == 1) {
                            int node = (x * grid.length) + y;
                            hs.add(ds.ultimateParent(node));
                        }
                    }
                    for (Integer parent : hs) {
                        smallAns += (ds.size[parent]);
                    }
                    ans = Math.max(ans, smallAns + 1);
                }
            }
        }
        ans = Math.max(ans, ds.size[0]);
        return ans;
    }

}
