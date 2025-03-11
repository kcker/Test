/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 如果非空，则仅由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 字典树 字符串 👍 3267 👎 0
 */

package leetcode.editor.cn;

import javax.swing.text.StyledEditorKit;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        solution.longestCommonPrefix(new String[]{"flower","flower","flower","flower"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                prefix = longestCommonPrefix(prefix, strs[i]);
            }
            return prefix;
        }

        private String longestCommonPrefix(String left, String right) {
            for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    return left.substring(0, i);
                }
            }
            return left.substring(0, Math.min(left.length(), right.length()));
        }
//        public String longestCommonPrefix(String[] strs) {
//            if (strs.length == 1) {
//                return strs[0];
//            }
//            if (strs[0].isEmpty()) {
//                return "";
//            }
//            for (int i = 0; i < strs[0].length(); i++) {
//                char c = strs[0].charAt(i);
//                for (int j = 1; j < strs.length; j++) {
//                    if (strs[j].length() <= i || strs[j].charAt(i) != c) {
//                        return strs[0].substring(0, i);
//                    }
//                }
//            }
//            return strs[0];
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}