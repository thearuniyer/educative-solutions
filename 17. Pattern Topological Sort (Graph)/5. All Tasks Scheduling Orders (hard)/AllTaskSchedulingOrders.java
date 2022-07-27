import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * AllTaskSchedulingOrders
 */
public class AllTaskSchedulingOrders {

    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        // base case
        if(tasks <= 0) return;

        // intialize a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }

        // build a graph 
        for(int[] p: prerequisites) {
            graph.get(p[0]).add(p[1]);
            inDegree.put(p[1], inDegree.get(p[1]) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> e: inDegree.entrySet()) {
            if(e.getValue() == 0) {
                sources.offer(e.getKey());
            }
        }

        printAllOrders(graph, inDegree, sources, sortedOrder);
    }

    public static void printAllOrders(Map<Integer, List<Integer>> graph, Map<Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedOrder) {
        
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][]{new int[]{0,1}, new int[]{1,2}});
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4, new int[][]{new int[]{3,2}, new int[]{3,0}, new int[]{2,0}, new int[]{2,1}});
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][]{new int[]{2,5}, new int[]{0,5}, new int[]{0,4}, new int[]{1,4}, new int[]{3,2}, new int[]{1,3}});
        System.out.println();
    }
}