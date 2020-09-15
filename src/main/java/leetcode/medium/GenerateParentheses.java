package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * generate-parentheses
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>(2 * n);


        gen(0, 0, n, list,"");
        return list;

    }

    void gen(int left, int right, int n, List<String> list,String res) {
        if (left == n && right == n) {
            list.add(res);
            return;
        }
        if (left < n) {
            gen(left + 1, right, n, list,res+"(");
        }
        if (right < n && right < left) {
            gen(left, right + 1, n, list,res+")");
        }
    }


}
