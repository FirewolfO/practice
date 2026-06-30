class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }

        // Find the first index from the right that can be increased.
        // The suffix after it is non-increasing and therefore already maximal.
        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if (pivot >= 0) {
            // Choose the rightmost value larger than the pivot. In a non-increasing
            // suffix, this gives the smallest possible increase.
            int successor = n - 1;
            while (nums[successor] <= nums[pivot]) {
                successor--;
            }
            swap(nums, pivot, successor);
        }

        // Reverse the suffix to make it the smallest arrangement for the new prefix.
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
