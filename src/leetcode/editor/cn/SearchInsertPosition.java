/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 为 无重复元素 的 升序 排列数组
 * -10⁴ <= target <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 二分查找 👍 2430 👎 0
 */

package leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    return middle;
                }
                if (nums[middle] < target) {
                    left = middle + 1;
                }
                if (nums[middle] > target) {
                    right = middle - 1;
                }

            }
            return left;
//            if (nums.length == 0) {
//                return 0;
//            }
//            if (nums.length == 1) {
//                return nums[0] < target ? 1 : 0;
//            }
//            if (nums.length == 2) {
//                return target <= nums[0]  ? 0 : target > nums[1]  ? 2 : 1;
//            }
//            return find(nums, 0, nums.length - 1, target);
        }

        private int find(int[] nums, int start, int end, int target) {
            if (target > nums[end]) {
                return end + 1;
            }
            if (target <= nums[start]) {
                return start;
            }
            int middle = start + (end - start) / 2;
            if (start >= middle) {
                return start + 1;
            }
            return nums[middle] < target  ? find(nums, middle, end, target) : find(nums, start, middle, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}