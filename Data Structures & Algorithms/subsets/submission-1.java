

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, current, nums, result);

        return result;
    }

    private void backtrack(
            int index,
            List<Integer> current,
            int[] nums,
            List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include
        current.add(nums[index]);
        backtrack(index + 1, current, nums, result);

        // Undo
        current.remove(current.size() - 1);

        // Exclude
        backtrack(index + 1, current, nums, result);
    }
}