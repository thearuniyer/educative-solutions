public class MinimumSubset {
    
    public int canPartition(int[] num) {
        
        return 0;
    }

    public static void main(String[] args) {
        MinimumSubset ms = new MinimumSubset();

        int[] num = new int[]{1, 2, 3, 9};
        System.out.println(ms.canPartition(num));

        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ms.canPartition(num));

        num = new int[]{1, 100, 3, 4    };
        System.out.println(ms.canPartition(num));
    }
}
