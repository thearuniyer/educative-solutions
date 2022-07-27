public class PartitionSet {
    

    public boolean canPartition(int[] num) {
        
        int N = num.length;
        // check if sum is even or not 
        int S = 0;
        for(int n: num) {
            S += n;
        } 

        if(S%2 != 0) return false;

        return subsetProblem(num, S/2);

    }

    public boolean subsetProblem(int[] num, int sum) {
        int N = num.length;
        boolean[][] dp = new boolean[N][sum + 1];

        // Initialization

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }

        // Main Code 
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(num[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - num[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[N-1][sum];
    }


    public static void main(String[] args) {
        
        PartitionSet ps = new PartitionSet();

        int[] num = {1, 2, 3, 4};
        System.out.print(ps.canPartition(num));

        num = new int[]{6, 2, 3, 4};
        System.out.print(ps.canPartition(num));

        num = new int[]{1, 1, 3, 7, 4};
        System.out.print(ps.canPartition(num));
    }
}
