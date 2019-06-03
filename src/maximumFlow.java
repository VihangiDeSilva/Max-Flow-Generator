// w1701073_2017405_Vihangi_Dharmawickrama Java program for implementation of the returns the maximum flow network

import java.lang.*;
import java.util.LinkedList;

public class maximumFlow
{

    static final int V = 6;

    // Returns true if there is a path from source 's' to sink 't' in residual graph. Also fills parent[] to store the path
    boolean bfs(int residualGraph[][], int s, int t, int parent[])
    {
        // Create a visited array and mark all vertices as not visited
        boolean array[] = new boolean[V];
        for(int i=0; i<V; ++i)
            array[i]=false;

        // Create a queue, enqueue source vertex and mark source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        array[s] = true;
        parent[s]=-1;

        // Standard Breadth First Search(BFS) Loop
        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<V; v++)
            {
                if (array[v]==false && residualGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    array[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then return true, else false
        return (array[t] == true);
    }

    // Returns tne maximum flow from s to t in the given graph
    public int fordFulkerson(int myArray2[][], int s, int t)
    {
        int u, v;

        // Create a residual graph and fill the residual graph with given capacities in the original graph as residual capacities in residual graph

        // Residual graph where residualGraph[i][j] indicates residual capacity of edge from i to j
        // (if there is an edge. If residualGraph[i][j] is 0, then there is not)
        int residualGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                residualGraph[u][v] = myArray2[u][v];

        // This array is filled by BFS and to store path
        int parent[] = new int[V];

        int maxFlow = 0;  // There is no flow initially

        // Augment the flow while tere is path from source to sink
        while (bfs(residualGraph, s, t, parent))
        {
            // Find minimum residual capacity of the edges along the path filled by BFS. Or we can say find the maximum flow through the path found.
            int pathFlow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // update residual capacities of the edges and reverse edges along the path
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            // Add path flow to overall flow
            maxFlow += pathFlow;
        }

        // Return the overall flow
        return maxFlow;
    }


}
