public class SubsetSum {
    
    public boolean isSubsetSum(int[] num, int sum) {

        int N = num.length;
        boolean[][] dp = new boolean[N][sum+1];

        // Initialization
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < sum+1; j++) {
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] =  true;
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
        
        SubsetSum ss = new SubsetSum();

        int[] num = new int[]{1, 2, 3, 7};
        System.out.println(ss.isSubsetSum(num, 6));

        num = new int[]{1, 2, 1, 7, 5};
        System.out.println(ss.isSubsetSum(num, 10));

        num = new int[]{1, 4, 3, 8};
        System.out.println(ss.isSubsetSum(num, 6));
    }
}
