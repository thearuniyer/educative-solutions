import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.xml.transform.Source;

/**
 * TopologicalSort
 */
public class TopologicalSort {

    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // base case - basically sorted
        if(vertices <= 0) return sortedOrder;

        // Initialize adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // keep count of indegrees
        Map<Integer, Integer> inDegree = new HashMap<>();
        // initialized the graph 
        for(int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // Build the graph
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            // we are adding child nodes and incrementing the indegrees everytime its seen
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
        }

        // find all Sources - all nodes with 0 inDegrees 
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while(!sources.isEmpty()) {
            int node = sources.poll();
            sortedOrder.add(node);
            List<Integer> children = graph.get(node);
            for(int child: children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    sources.offer(child);
                }
            }
        }

        // if there is a mismatch then there is a cycle detected
        if(sortedOrder.size() != vertices) {
            return new ArrayList<>();
        }

        return sortedOrder;
    }


    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4, new int[][]{new int[]{3,2}, new int[]{3,0}, new int[]{2,0}, new int[]{2,1}});
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][]{new int[]{4,2}, new int[]{4,3}, new int[]{2,0}, new int[]{2,1}, new int[]{3,1}});
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][]{new int[]{6,4}, new int[]{6,2}, new int[]{5,3}, new int[]{5,4}, new int[]{3,0}, new int[]{3,1}, new int[]{3,2}, new int[]{4,1}});
        System.out.println(result);

        result = TopologicalSort.sort(3, new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{2,0}});
        System.out.println(result);
    }
}



