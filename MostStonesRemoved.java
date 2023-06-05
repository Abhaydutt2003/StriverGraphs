package StiverGraphs;

import java.util.*;

public class MostStonesRemoved {

    public static void main(String args[]) {
        int matrix[][] = {
                // {0,0},
                // {0,1},
                // {1,0},
                // {1,2},
                // {2,1},
                // {2,2}

                // { 0, 0 },
                // { 0, 2 },
                // { 1, 1 },
                // { 2, 0 },
                // { 2, 2 }

                // {0,1},
                // {1,0},
                // {1,1}

                { 3, 2 },
                { 3, 1 },
                { 4, 4 },
                { 1, 1 },
                { 0, 2 },
                { 4, 0 }
        };
        System.out.print(util1(matrix));
    }

    // striver approach treating each row and column as an individual node...
    public static int util1(int[][] grid) {
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            maxRow = Math.max(maxRow, grid[i][0]);
            maxCol = Math.max(maxCol, grid[i][1]);
        }
        DisjointSet3 ds = new DisjointSet3(maxRow + maxCol + 1);
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            int row = grid[i][0];
            int col = grid[i][1] + maxRow + 1;
            ds.unionBySize(row, col);
            hs.add(row);
            hs.add(col);
        }
        int nonRemovable = 0;
        for (Integer node : hs) {
            if (ds.parent[node] == node) {
                nonRemovable++;
            }
        }
        return grid.length - nonRemovable;
    }

    // failed approach , did not understood the question properly.

    // public static int util1(int grid[][]) {
    // HashMap<Integer, Integer> pastRows = new HashMap<>();
    // HashMap<Integer, Integer> pastCols = new HashMap<>();
    // DisjointSet3 ds = new DisjointSet3(grid.length);
    // pastRows.put(grid[0][0], 0);
    // pastCols.put(grid[0][1], 0);

    // for (int i = 1; i < grid.length; i++) {
    // if (pastRows.containsKey(grid[i][0])) {
    // int toUnion = pastRows.get(grid[i][0]);
    // ds.unionBySize(toUnion, i);
    // } else if (pastCols.containsKey(grid[i][1])) {
    // int toUnion = pastCols.get(grid[i][1]);
    // ds.unionBySize(toUnion, i);
    // } else if (pastCols.containsKey(grid[i][0])) {
    // int toUnion = pastCols.get(grid[i][0]);
    // ds.unionBySize(toUnion, i);
    // } else if (pastRows.containsKey(grid[i][1])) {
    // int toUnion = pastRows.get(grid[i][1]);
    // ds.unionBySize(toUnion, i);
    // }
    // pastRows.put(grid[i][0], i);
    // pastCols.put(grid[i][1], i);
    // }

    // int removableNode = 0;
    // for (int i = 0; i < ds.parent.length - 1; i++) {
    // if (ds.parent[i] != i) {
    // removableNode++;
    // }
    // }
    // return removableNode;
    // }

}
