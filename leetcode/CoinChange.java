class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        int[] coinCounts = new int[amount + 1];
        Arrays.fill(coinCounts, amount + 1);
        coinCounts[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    coinCounts[i] = Math.min(coinCounts[i], coinCounts[i - coins[j]] + 1);
                }
            }
        }
        
        return coinCounts[amount] > amount ? -1 : coinCounts[amount];
        
    }
    
}
