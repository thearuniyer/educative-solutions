import java.util.Stack;

/**
 * TreeNode
 */
class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
};

public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        if(root == null) 
            return sequence.length == 0;
        
        return findRecursivePath(root, sequence, 0);
    }

    public static boolean findRecursivePath(TreeNode node, int[] sequence, int index) {

        if(node == null) {
            return false;
        }
        if(index >= sequence.length || node.val != sequence[index]) {
            return false;
        }
        if(node.left == null && node.right == null && index == sequence.length-1) {
            return true;
        }

        return findRecursivePath(node.left, sequence, index+1) || findRecursivePath(node.right, sequence, index+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.right.left = new TreeNode(3);

        System.out.println("Tree path has sequence: " + PathWithGivenSequence.findPath(root, new int[]{1,0,1,0}));    //true
        System.out.println("Tree path has sequence: " + PathWithGivenSequence.findPath(root, new int[]{1,0,3,1}));    //false
        System.out.println("Tree path has sequence: " + PathWithGivenSequence.findPath(root, new int[]{1,0,2}));    //false
    }
}



/*
 * 
 * public static boolean findPath(TreeNode root, int[] sequence) {
        if(root == null) return false;
        int n = sequence.length;
        Stack<TreeNode> s = new Stack<>();

        s.push(root);
        int index  = 0;
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            if(cur.left == null && cur.right == null && cur.val == sequence[n-1]) {
                return true;
            }
            if(cur.val == sequence[index]) {
                index++;
                if(cur.left != null) {
                    s.push(cur.left);
                }
                if(cur.right != null) {
                    s.push(cur.right);
                }
            }
        }
        return false;
    }
 *
 */