import java.lang.*;
import java.util.Arrays;

public class DijkstraAlgorithm {
    int vertices;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.vertices = 9;
        int[] distance = dijkstraAlgorithm.findShortestPath(graph, 0);
        System.out.println(Arrays.toString(distance));
    }

    /**
     * A utility function to find the vertex with minimum distance value from the set of vertices not yet included in shortest path tree
     *
     * @param dist
     * @param sptSet
     * @return
     */
    int minDistance(int[] dist, Boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < vertices; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    int[] findShortestPath(int[][] graph, int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Boolean[] sptSet = new Boolean[vertices];
        Arrays.fill(sptSet, false);

        dist[src] = 0;
        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;
            for (int v = 0; v < vertices; v++)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        return dist;
    }
}
