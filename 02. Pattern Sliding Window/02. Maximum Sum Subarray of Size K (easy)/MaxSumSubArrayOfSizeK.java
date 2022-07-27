public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = 0, cur = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            cur += arr[windowEnd];

            if(windowEnd >= k-1) {
                max = Math.max(cur, max);
                cur -= arr[windowStart];
                windowStart++;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        int k = 3;
        System.out.println(findMaxSumSubArray(k, arr));
    }
    
}