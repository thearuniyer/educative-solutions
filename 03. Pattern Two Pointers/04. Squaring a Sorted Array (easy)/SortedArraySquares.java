public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] res = new int[arr.length];
        int left = 0, right = arr.length-1;
        int idx = right;

        while(left <= right) {
            if(arr[left]*arr[left] > arr[right]*arr[right]) {
                res[idx] = arr[left]*arr[left];
                left++;
            }
            else {
                res[idx] = arr[right]*arr[right];
                right--;
            }
            idx--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-3, -1, 0, 1, 2};
        arr = makeSquares(arr);
        for(int a : arr) {
            System.out.println(a);
        }
    }
}
