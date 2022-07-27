public class CountSubsetSum {
    
    public int CountSubsets(int[] num, int sum) {
        int N = num.length;
        int[][] dp = new int[N+1][sum+1];

        

        for(int i = 1; i < N+1; i++) {
            for(int j = 0; j < sum+1; j++) {

                if(num[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - num[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        CountSubsetSum css = new CountSubsetSum();

        int[] num = new int[]{1,1,2,3};
        System.out.println(css.CountSubsets(num, 4));

        num = new int[]{1,2,7,1,5};
        System.out.println(css.CountSubsets(num, 9));
    }
}
