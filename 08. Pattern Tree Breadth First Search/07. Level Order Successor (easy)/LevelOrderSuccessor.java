import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};


public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }

                if(cur.val == key) {
                    // find the successor
                    if(!q.isEmpty()) {
                        return q.peek();
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if(result != null) {
            System.out.println("Result =" + result.val);
        }
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if(result != null) {
            System.out.println("Result =" + result.val);
        }
    }
}
