public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        
        int left = 0, right = arr.length - 1;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum > targetSum) {
                right--;
            }
            else if(sum < targetSum) {
                left++;
            }
            else {
                return new int[]{left, right};
            }
        }
        
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] res = search(new int[]{1,2,3,4,6}, 6);
        System.out.println(res[0]+", "+res[1]);
        res = search(new int[]{2,5,9,11}, 11);
        System.out.println(res[0]+", "+res[1]);
    }
}