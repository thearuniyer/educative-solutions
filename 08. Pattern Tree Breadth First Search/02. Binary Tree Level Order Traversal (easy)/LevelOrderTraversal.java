import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        // create a resultant list 
        List<List<Integer>> res = new ArrayList<>();
        // check base case and return res if root is null 
        if(root == null) return res;

        // create a queue to handle BFS
        Queue<TreeNode> q = new LinkedList<>();
        // add the root node to it 
        q.add(root);
        // start the BFS 
        while(!q.isEmpty()){
            // we record size at start because q.size() may change inside the for-loop as nodes are added / deleted 
            int size = q.size();
            // create a list for the current level 
            List<Integer> curLevel = new ArrayList<>();
            // start the loop 
            for(int i = 0; i < size; i++) {
                // pop out value from queue 
                TreeNode cur = q.poll();
                // add its value to the current level 
                curLevel.add(cur.val);
                // check if left and right node isnt empty then add to queue 
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // add the current level list to resultant 
            res.add(curLevel);
        }
        // return result at the end of the BFS 
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> res = LevelOrderTraversal.traverse(root);
        System.out.println("Result: "+ res);
    }
}
