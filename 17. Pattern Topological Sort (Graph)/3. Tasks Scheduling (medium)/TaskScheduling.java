import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.management.Query;

public class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        // base case 
        if(tasks <= 0) return false;

        // Build an adjacency list 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Build an indegree map counter 
        Map<Integer, Integer> inDegree = new HashMap<>();
        
        // Initialize the graph 
        for(int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }

        // Build the graph
        for(int[] p: prerequisites) {
            graph.get(p[0]).add(p[1]);
            inDegree.put(p[1], inDegree.get(p[1]) + 1);
        }

        // find all sources 
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        // Run the BFS now 
        while(!sources.isEmpty()) {
            // get task 
            int task = sources.poll();
            // add task to result 
            sortedOrder.add(task);
            // get the prerequisites of this task 
            List<Integer> children = graph.get(task);
            for(int child: children) {
                // decrease indegree count as parent task has been processed
                inDegree.put(child, inDegree.get(child) - 1);
                // check if inDegree value is 0, if yes then add to new source 
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        return sortedOrder.size() == tasks;
    }

    public static void main(String[] args) {
        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][]{new int[]{0,1}, new int[]{1,2}});
        System.out.println("Is it possible:" + result);

        result = TaskScheduling.isSchedulingPossible(3, new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{2,0}});
        System.out.println("Is it possible:" + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][]{new int[]{2,5}, new int[]{0,5}, new int[]{0,4}, new int[]{1,4}, new int[]{3,2}, new int[]{1,3}});
        System.out.println("Is it possible:" + result);
    }
}
