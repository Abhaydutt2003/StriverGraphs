package StiverGraphs;

import java.util.*;

public class HowWeStore {

    public static void main(String args[]) {
        util1();
    }

    static Scanner s = new Scanner(System.in);

    // adj matrix to store graph, not good because it takes a lot of space .
    public static void util1() {
        System.out.println("Enter the number of vertices ");
        int n = s.nextInt();
        System.out.println("Enter the number of edges ");
        int m = s.nextInt();
        int adjMatrix[][] = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int vertice1 = s.nextInt();
            int vertice2 = s.nextInt();
            adjMatrix[vertice1][vertice2] = 1;
        }

        // printing the adj matrix
        for (int[] a : adjMatrix) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // public static void util2(){
    // System.out.println("Enter the number of vertices ");
    // int n = s.nextInt();
    // System.out.println("Enter the number of edges ");
    // int m = s.nextInt();

    // }

}
