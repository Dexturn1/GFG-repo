class Solution {
    public double minMaxDist(int[] stations, int K) {
        double low = 0;
        double high = 0;

        for (int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;

            if (numberOfGasStationsRequired(mid, stations) > K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private int numberOfGasStationsRequired(double dist, int[] stations) {
        int count = 0;

        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            int needed = (int)(gap / dist);
            if (gap % dist == 0) {
                needed--;
            }
            count += needed;
        }
        return count;
    }
}
