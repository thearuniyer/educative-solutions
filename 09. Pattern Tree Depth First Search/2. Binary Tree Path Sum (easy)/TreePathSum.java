import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
        val = x;
    }
};

public class TreePathSum {
    
    // Iterative
    public static boolean hasPath(TreeNode root, int sum) {
        if(root == null) return false;

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> pathSum = new Stack<>();

        path.push(root);
        pathSum.push(root.val);

        while(!path.isEmpty()) {
            TreeNode cur = path.pop();
            int tempVal = pathSum.pop();

            if(cur.left == null && cur.right == null && tempVal == sum) {
                return true;
            }
            if(cur.left != null) {
                path.push(cur.left);
                pathSum.push(tempVal + cur.left.val);
            }
            if(cur.right != null) {
                path.push(cur.right);
                pathSum.push(tempVal + cur.right.val);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(TreePathSum.hasPath(root, 23));
        System.out.println(TreePathSum.hasPath(root, 16));
    }
}




/*
 * public static boolean hasPath(TreeNode root, int sum) {
        if(root == null) return false;

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> s = new Stack<>();

        path.push(root);
        s.push(root.val);

        while(!path.isEmpty()) {
            TreeNode node = path.pop();
            int tempVal = s.pop();
            if(node.left == null && node.right == null && tempVal == sum) {
                return true;
            }
            else {
                if(node.left != null) {
                    path.push(node.left);
                    s.push(tempVal + node.left.val);
                }
                if(node.right != null) {
                    path.push(node.right);
                    s.push(node.right.val + tempVal);
                }
            }
        }
        return false;
    }
 */