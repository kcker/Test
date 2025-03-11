/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
 * II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减
 * 小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * <p>
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * <p>
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - 百度百科。
 * <p>
 * <p>
 * Related Topics 哈希表 数学 字符串 👍 2870 👎 0
 */

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final Map<String, Integer> ROMAN_NUMBER = new HashMap<>();
        private static final Map<String, Integer> SPECIAL_ROMAN_NUMBER = new HashMap<>();

        static {
            ROMAN_NUMBER.put("I", 1);
            ROMAN_NUMBER.put("V", 5);
            ROMAN_NUMBER.put("X", 10);
            ROMAN_NUMBER.put("L", 50);
            ROMAN_NUMBER.put("C", 100);
            ROMAN_NUMBER.put("D", 500);
            ROMAN_NUMBER.put("M", 1000);

            SPECIAL_ROMAN_NUMBER.put("IV", 4);
            SPECIAL_ROMAN_NUMBER.put("IX", 9);
            SPECIAL_ROMAN_NUMBER.put("XL", 40);
            SPECIAL_ROMAN_NUMBER.put("XC", 90);
            SPECIAL_ROMAN_NUMBER.put("CD", 400);
            SPECIAL_ROMAN_NUMBER.put("CM", 900);
        }


        public int romanToInt(String s) {
            if (s.length() == 1) {
                return ROMAN_NUMBER.get(s);
            }
            if (s.length() == 2 && SPECIAL_ROMAN_NUMBER.containsKey(s)) {
                return SPECIAL_ROMAN_NUMBER.get(s);
            }
            int result = 0;
            for (int i = 0; i < s.length();) {
                if (i == (s.length() - 1)) {
                    result += ROMAN_NUMBER.get(s.substring(i, i + 1));
                }
                String segment = s.substring(i, i + 2);
                if (SPECIAL_ROMAN_NUMBER.containsKey(segment)) {
                    result += SPECIAL_ROMAN_NUMBER.get(segment);
                    i += 2;
                } else {
                    result += ROMAN_NUMBER.get(segment.substring(i, i + 1));
                    i++;
                }
            }
            return result;
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}