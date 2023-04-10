package StiverGraphs;

import java.util.*;

public class NumberOfProvinces {

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.print(util1(matrix));
    }

    static boolean visitedArray[];

    public static int util1(int[][] adjMatrix) {
        int totalComponents = 0;
        visitedArray = new boolean[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            if (visitedArray[i] == false) {
                dfs(adjMatrix, i);
                totalComponents++;
            }
        }
        return totalComponents;
    }

    //works but this is wrong bfs, right bfs and dfs codesd below
    public static void bfsWrong(int adjMatrix[][], int i) {
        Stack<Integer> s = new Stack<Integer>();
        s.add(i);
        visitedArray[i] = true;
        while (s.isEmpty() == false) {
            int currentNode = s.pop();
            for (int j = 0; j < adjMatrix[currentNode].length; j++) {
                if (adjMatrix[currentNode][j] == 1 && visitedArray[j] == false) {
                    s.push(j);
                    visitedArray[j] = true;
                }
            }
        }
    }

    public static void bfs(int adjMatrix[][], int i){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i);
        while(q.isEmpty() == false){
            int currentNode = q.poll();
            for (int j = 0; j < adjMatrix[currentNode].length; j++) {
                if (adjMatrix[currentNode][j] == 1 && visitedArray[j] == false) {
                    q.add(j);
                    visitedArray[j] = true;
                }
            }
        }
    }

    public static void dfs(int adjMatrix[][], int i){
        visitedArray[i] = true;
        for(int j = 0;j<adjMatrix[i].length;j++){
            if (adjMatrix[i][j] == 1 && visitedArray[j] == false) {
                visitedArray[j] = true;
                dfs(adjMatrix,j);
            }
        }
    }

}
