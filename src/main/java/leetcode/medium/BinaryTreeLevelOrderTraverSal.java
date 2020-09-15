package leetcode.medium;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraverSal {

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<TreeNode> visited = new HashSet();
        visited.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    queue.add(currentNode.right);
                }
            }
            res.add(currentLevel);
        }
        return res;

    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderDFS(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        levelOrderDFS(1, root, res);
        return res;
    }


    public void levelOrderDFS(int level, TreeNode root, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (list.size() < level) {
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(root.val);
        levelOrderDFS(level + 1, root.left, list);
        levelOrderDFS(level + 1, root.right, list);
    }

    class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;
    }

}
