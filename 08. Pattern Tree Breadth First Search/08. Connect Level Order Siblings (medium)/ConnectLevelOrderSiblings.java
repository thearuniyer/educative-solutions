import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x){
        val = x;
        left = right = next = null;
    }

    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while(nextLevelRoot != null) {
            TreeNode cur = nextLevelRoot;
            nextLevelRoot = null;
            while(cur != null) {
                System.out.print(cur.val + " ");
                if(nextLevelRoot == null) {
                    if(cur.left != null) {
                        nextLevelRoot = cur.left;
                    }
                    else if(cur.right != null) {
                        nextLevelRoot = cur.right;
                    }
                }
                cur = cur.next;
            }
            System.out.println();
        }
    }
};

public class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode prev = null;
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
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level Order Traversal using 'next pointer: ");
        root.printLevelOrder();
    }
}
