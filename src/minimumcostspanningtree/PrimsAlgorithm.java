package minimumcostspanningtree;

import java.lang.*;
import java.util.Arrays;

public class PrimsAlgorithm {
    private int vertices;

    public static void main(String[] args) {
        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();
        primsAlgorithm.vertices = 5;
        int[][] graph = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};
        System.out.println(primsAlgorithm.findMST(graph));
    }

    /**
     * A utility function to find the vertex with minimum key value, from the set of vertices not yet included in MST
     *
     * @param key
     * @param mstSet
     * @return
     */
    int findMinKey(int[] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < vertices; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }

    /**
     * Function to construct and print MST for a graph represented using adjacency matrix representation
     *
     * @param graph
     */
    int findMST(int[][] graph) {

        int[] key = new int[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);

        Boolean[] mstSet = new Boolean[vertices];
        Arrays.fill(mstSet, false);

        key[0] = 0;
        int res = 0;

        for (int count = 0; count < vertices ; count++) {
            int u = findMinKey(key, mstSet);

            mstSet[u] = true;
            res = res + key[u];
            for (int v = 0; v < vertices; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
        }
        return res;
    }
}

