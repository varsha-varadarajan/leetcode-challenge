/* https://leetcode.com/problems/number-complement/
*/

package Problems;
// TC: log(N) - every step we are dividing by 2
// SC: O(1)   - constant space
public class Day5 {
    public static int bitwiseComplement(int N) {
        if (N == 0 || N == 1) {
            return Math.abs(N - 1);
        }
        int sum = 0;
        int pos = 0;
        while (N != 0) {
            int rem = N % 2;
            N = N / 2;
            sum += (Math.abs(rem - 1) * Math.pow(2, pos));
            pos++;
        }
        return sum;
    }

    public static void main(String args[]) {
        System.out.println(bitwiseComplement(5));
        System.out.println(bitwiseComplement(0));
    }
}
