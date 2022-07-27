import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
        val = x;
    }
};

public class SumOfPathNumbers {
    public static int findSumOfpathNumbers(TreeNode root) {
        if(root == null ) return 0;
        // stack for DFS 
        Stack<TreeNode> s = new Stack<>();
        // stack for creating digits for different paths 
        Stack<Integer> paths = new Stack<>();

        s.push(root);
        paths.push(root.val);
        
        int sum = 0;
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            int pathDigit = paths.pop();
            // this condition satifsfied means we finally have a fully formed digit 
            if(cur.left == null && cur.right == null) {
                // we can push it into sum 
                sum += pathDigit;
            }
            // otherwise we adding nodes to stack and new digits to paths 
            if(cur.left != null) {
                s.push(cur.left);
                paths.push(pathDigit*10 + cur.left.val);
            }
            if(cur.right != null) {
                s.push(cur.right);
                paths.push(pathDigit*10 + cur.right.val);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Total Sum of Path Numbers: "+ SumOfPathNumbers.findSumOfpathNumbers(root));
    }
}
