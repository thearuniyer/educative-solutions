import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode
 */
class TreeNode {

    int val;
    TreeNode left, right, next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }
};

public class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode prev = null;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(prev != null) {
                    prev.next = cur;
                }

                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
                prev = cur;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        TreeNode current = root;
        System.out.println("Traversal using next pointer: ");
        while(current != null) {
            System.out.println(current.val + " ");
            current = current.next;
        }
    }
}
