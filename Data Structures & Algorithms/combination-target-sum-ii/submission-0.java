class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, 0, target, current, result);

        return result;
    }

    private void backtrack(
        int[] candidates,
        int start,
        int remainingTarget,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Found a valid combination
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate choices at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted, everything after this is also too large
            if (candidates[i] > remainingTarget) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            // Move forward: this element cannot be reused
            backtrack(
                candidates,
                i + 1,
                remainingTarget - candidates[i],
                current,
                result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }
}