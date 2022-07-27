import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * TaskSchedulingOrder
 */
public class TaskSchedulingOrder {

    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();

        if(tasks <= 0) return sortedOrder;
        // initialize the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        // build the graph
        for(int[] p: prerequisites) {
            graph.get(p[0]).add(p[1]);
            inDegree.put(p[1], inDegree.get(p[1]) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // start BFS
        while(!sources.isEmpty()) {
            int task = sources.poll();
            sortedOrder.add(task);
            List<Integer> pre = graph.get(task);
            for(int p: pre) {
                inDegree.put(p, inDegree.get(p) - 1);
                if(inDegree.get(p) == 0) {
                    sources.add(p);
                }
            }
        }
        // check for cycle 
        if(sortedOrder.size() != tasks) return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][]{new int[]{0,1}, new int[]{1,2}});
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3, new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{2,0}});
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][]{new int[]{2,5}, new int[]{0,5}, new int[]{0,4}, new int[]{1,4}, new int[]{3,2}, new int[]{1,3}});
        System.out.println(result);
    }
}