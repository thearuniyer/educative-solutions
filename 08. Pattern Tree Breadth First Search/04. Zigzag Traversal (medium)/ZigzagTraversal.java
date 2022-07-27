import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * InnerZigzagTraversal
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class ZigzagTraversal {
    
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> zigzagOrder = new ArrayList<>();
        if(root == null) return zigzagOrder;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOdd = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(isOdd) {
                    curLevel.add(cur.val);
                }
                else {
                    curLevel.add(0, cur.val);
                }
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            zigzagOrder.add(curLevel);
            isOdd = !isOdd;
        }
        return zigzagOrder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        List<List<Integer>> res = ZigzagTraversal.traverse(root);
        System.out.print("Zigzag:" + res);
    }
}