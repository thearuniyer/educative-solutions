import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
        val = x;
    }
};

public class FindAllTreePaths {

    public static List<List<Integer>> findpaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        recursivePaths(root, sum, allPaths, curPath);
        return allPaths;
    }

    public static void recursivePaths(TreeNode node, int sum, List<List<Integer>> allPaths, List<Integer> curPath) {
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> res = FindAllTreePaths.findpaths(root, sum);

        System.out.println("Tree Paths with sum:" + sum + ": " + res);
    }
}
