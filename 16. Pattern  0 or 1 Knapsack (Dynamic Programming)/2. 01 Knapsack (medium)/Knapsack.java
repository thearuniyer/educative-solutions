/**
 * Knapsack
 */
public class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int N = weights.length;
        Integer[][] dp = new Integer[N][capacity + 1];

        // Initialization 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < capacity+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Main Code

        for(int i = 1; i < N; i++) {
            for(int j = 1; j < capacity + 1; j++) {
                if(weights[i-1] <= j) {
                    dp[i][j] = Math.max(profits[i-1] + dp[i-1][j - weights[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        
        return dp[N-1][capacity];
    }

    
    

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();

        int[] profits = {1,6,10,16};
        int[] weights = {1,2,3,5};

        int maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Max profit is = "+maxProfit);

        // maxProfit = ks.solveKnapsack(profits, weights, 6);
        // System.out.println("Max profit is = "+maxProfit);
    }
}



/* Top Down


public int solveKnapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int index) {
        // base case
        if(capacity <= 0 || index < 0) {
            return 0;
        }

        if(dp[index][capacity] != null) {
            return dp[index][capacity];
        }
         
        if(weights[index] <= capacity) {
            return dp[index][capacity] = Math.max(profits[index] + solveKnapsackRecursive(dp, profits, weights, capacity - weights[index], index-1), solveKnapsackRecursive(dp, profits, weights, capacity, index-1));
        }
        else {
            return dp[index][capacity] = solveKnapsackRecursive(dp, profits, weights, capacity, index-1);
        }
    }

*/