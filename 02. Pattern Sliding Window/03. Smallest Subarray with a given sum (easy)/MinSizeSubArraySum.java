public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int currentLength = 0, minLength = Integer.MAX_VALUE, sum = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];

            while(sum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,1,5,2,3,2};
        int S = 7;
        System.out.println(findMinSubArray(S, arr));
    }
}





















/*
 * public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0;
        int curLength = 0, minLength = Integer.MAX_VALUE, sum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];

            while(sum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,1,5,2,3,2};
        int S = 7;
        System.out.println(findMinSubArray(S, arr));
    }
 */