class Solution {
    public int findPages(int[] arr, int k) {

        if (k > arr.length) return -1;

        int low = 0, high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDist(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canDist(int[] arr, int k, int mid) {
        int students = 1;
        int pages = 0;

        for (int p : arr) {
            if (pages + p > mid) {
                students++;
                pages = p;
            } else {
                pages += p;
            }
        }
        return students <= k;
    }
}
