class Solution {
    public ArrayList<Integer> getLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int maxLength = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {

            for (int prev = 0; prev < i; prev++) {

                if (nums[prev] < nums[i] &&
                    dp[prev] + 1 > dp[i]) {

                    dp[i] = dp[prev] + 1;
                    parent[i] = prev;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();

        while (parent[lastIndex] != lastIndex) {

            lis.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];

        }

        lis.add(nums[lastIndex]);

        Collections.reverse(lis);

        return lis;
    }
}



