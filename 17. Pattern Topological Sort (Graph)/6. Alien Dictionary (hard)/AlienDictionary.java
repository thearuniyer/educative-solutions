import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * AlienDictionary
 */
public class AlienDictionary {

    public static String findOrder(String[] words) {
        // The biggest challenge is building the first graph, once done, we follow the Topo Template

        // cover the base case
        if(words.length == 0 || words == null) {
            return "";
        }

        // to initilaize the graph we have to create the usual hashmaps for indegree and parent-children 
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        // add all the Characters encountered into the graph 
        for(String word : words) {
            for(Character c : word.toCharArray()) {
                graph.put(c, new ArrayList<Character>());
                inDegree.put(c, 0);
            }
        }

        // Now we Build the graph  

        // iterate through all words but two at a time 
        for(int i = 0; i < words.length - 1; i++) {         
            String w1 = words[i], w2 = words[i+1];
            int len = Math.min(w1.length(), w2.length());
            // the idea is to look at chars at same positions (j) in w1 and w2 and build graph 
            for(int j = 0; j < len; j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                // only the first difference matters to build a graph, no more in THAT word 
                if( parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    // once we found the relation we can break the loop 
                    break;
                }
            }
        }


        Queue<Character> sources = new LinkedList<>();
        for(Map.Entry<Character, Integer> e: inDegree.entrySet()) {
            if(e.getValue() == 0) {
                // eligible to be added 
                sources.offer(e.getKey());
            }
        }

        // Now we can traverse through BFS and create our sorted Order 
        StringBuilder sortedOrder = new StringBuilder();
        while(!sources.isEmpty()) {
            Character letter = sources.poll();
            sortedOrder.append(letter);
            List<Character> children = graph.get(letter);
            for(Character child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    sources.offer(child);
                }
            }
        }

        // Check for graph cycles 
        if(sortedOrder.length() != inDegree.size()) {
            return "";
        }

        return sortedOrder.toString();
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[]{ "ba", "bc", "ac", "cab" });
        System.out.println("Order:" + result);

        result = AlienDictionary.findOrder(new String[]{ "cab", "aaa", "aab" });
        System.out.println("Order:" + result);

        result = AlienDictionary.findOrder(new String[]{ "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Order:" + result);
    }
}