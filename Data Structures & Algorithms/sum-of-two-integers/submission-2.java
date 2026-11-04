class Solution {
    public int getSum(int a, int b) {
        int res = 0;
        int carry = 0;

        for (int i = 0; i < 32; i++) {
            int a_bit = (a >> i) & 1;
            int b_bit = (b >> i) & 1;

            int current_bit = a_bit ^ b_bit ^ carry;

            carry = (a_bit + b_bit + carry) >= 2 ? 1 : 0;

            if (current_bit != 0) {
                res |= (1 << i);
            }
        }

        return res;
    }
}