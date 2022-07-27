import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> levelAverages = new ArrayList<>();
        if(root == null) return levelAverages;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
            levelAverages.add(sum/size);
        }
        return levelAverages;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> res = LevelAverage.findLevelAverages(root);
        System.out.println("Result: "+ res);
    }
}
