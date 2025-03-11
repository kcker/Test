/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：c = 3
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= c <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 数学 双指针 二分查找 👍 443 👎 0
 */

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        System.out.println((int) Math.ceil(Math.sqrt(2147483600)));
        System.out.println(solution.judgeSquareSum(2147483600));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            int i = 0;
            int j = (int) Math.sqrt(c);
            while(i<=j) {
                if (c - i * i == j * j) {
                    return true;
                }
                if (c - i * i < j * j) {
                    System.out.println(111);
                    j --;
                    continue;
                }
                if (c - i * i > j * j) {
                    i ++;
                }
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}