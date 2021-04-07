// Java program for implementation of Ford Fulkerson algorithm
import java.lang.*;
import java.util.LinkedList;

class FordFulkersonMaxFlow {
    static int numOfVertices; // Number of vertices in graph

    /* Returns true if there is a path from source to
    sink in residual graph. */
    boolean bfs(int[][] residualGraph, int source, int sink, int[] graph) {
        // Create a visited array and mark all vertices as not visited
        boolean[] visitedArray = new boolean[numOfVertices];
        for (int i = 0; i < numOfVertices; ++i)
            visitedArray[i] = false;

        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visitedArray[source] = true;
        graph[source] = -1;

        // Standard BFS Loop
        while (queue.size() != 0) {
            //the head of this list, or null if this list is empty
            int headElement = queue.poll();

            for (int vert = 0; vert < numOfVertices; vert++) {
                if (!visitedArray[vert] && residualGraph[headElement][vert] > 0) {
                    // If we find a connection to the sink
                    // node, then there is no point in BFS
                    // anymore We just have to set its parent
                    // and can return true
                    if (vert == sink) {
                        graph[vert] = headElement;
                        return true;
                    }
                    queue.add(vert);
                    graph[vert] = headElement;
                    visitedArray[vert] = true;
                }
            }
        }

        // We didn't reach sink in BFS starting from source,
        // so return false
        return false;
    }

    // Returns tne maximum flow from sink to source in the given graph
    int fordFulkerson(int[][] graph, int sourse, int sink) {
        int u, v;

        // Create a residual graph and fill the residual
        // graph with given weights as in the original graph.
        // Basically making a copy of the original graph

        int[][] resGraph = new int[numOfVertices][numOfVertices];

        for (u = 0; u < numOfVertices; u++)
            for (v = 0; v < numOfVertices; v++)
                resGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        int[] parentArray = new int[numOfVertices];

        int max_flow = 0; // There is no flow initially

        // Augment the flow while there is path from source to sink
        while (bfs(resGraph, sourse, sink, parentArray)) {
            // Find MINIMUM residual capacity of the edges
            // along the path filled by BFS. Or we can say
            // find the MAX FLOW through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v = sink; v != sourse; v = parentArray[v]) {
                u = parentArray[v];
                path_flow = Math.min(path_flow, resGraph[u][v]);
            }

            // update residual capacities of the edges and reverse edges along the path
            for (v = sink; v != sourse; v = parentArray[v]) {
                u = parentArray[v];
                resGraph[u][v] -= path_flow;
                resGraph[v][u] += path_flow;
            }
            // Add path flow to overall flow
            max_flow += path_flow;
        }
        // Return the overall flow
        return max_flow;
    }
}
