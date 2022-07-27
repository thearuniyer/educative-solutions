import java.util.HashMap;

/**
 * MaxFruitCountOf2Types
 */
public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0) + 1);
            while(map.size() > 2) {
                map.put(arr[windowStart], map.get(arr[windowStart]) - 1);
                if(map.get(arr[windowStart]) == 0) {
                    map.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findLength(arr));
    }
}