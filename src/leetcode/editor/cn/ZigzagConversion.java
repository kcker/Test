/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * <p>
 * Related Topics 字符串 👍 2467 👎 0
 */

package leetcode.editor.cn;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            int segmentLength = 2 * numRows - 2;
            int segmentCount = (s.length() + segmentLength - 1) / segmentLength;
            int i = 0;
            StringBuilder res = new StringBuilder();
            while (i < numRows) {
                for (int j = 0; j <= segmentCount; j++) {
                    int left = j * segmentLength - i;
                    int right = j * segmentLength + i;
                    if (left >=0 && left > (j - 1) * segmentLength + i && left < s.length()) {
                        res.append(s, left, left + 1);
                    }
                    if (right != left && right < s.length()) {
                        res.append(s, right, right + 1);
                    }
                }
                i++;
                //s[0] +    s[4] +      s[8]
                //s[1] +   s[3]+s[5] + s[7]+s[9]
                //s[2] +   s[2]+s[6] + s[6]+s[10]

                //s[0]+   s[6]+        s[12]
                //s[1]+  s[5]+s[7]  s[11] + s[13]
                //s[2]+  s[4]+s[8]  s[10] + s[14]
                //s[3]+       s[9]
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}