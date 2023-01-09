//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
//leetcode problem 1305
package GoldmanSachs;
import java.util.*;

public class AllElementsInTwoBinarySearchTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return new MyList(root1, root2);
    }

    private static class MyList extends ArrayList<Integer> {
        private TreeNode node1;
        private TreeNode node2;

        public MyList(TreeNode node1, TreeNode node2) {
            this.node1 = node1;
            this.node2 = node2;
        }

        @Override
        public int size() {

            if (super.size() == 0) {
                method();
            }

            return super.size();
        }

        private void method() {
            ArrayList<Integer> result1 = new ArrayList<>();
            ArrayList<Integer> result2 = new ArrayList<>();
            result(node1, result1);
            result(node2, result2);
            merge(result1, result2);
            node1 = null;
            node2 = null;
        }

        private void result(TreeNode node, ArrayList<Integer> list) {

            if (node == null) {
                return;
            }

            result(node.left, list);
            list.add(node.val);
            result(node.right, list);
        }

        private void merge(ArrayList<Integer> array1, ArrayList<Integer> array2) {
            int left;
            int right;
            
            for (left = 0, right = 0; left < array1.size() && right < array2.size(); ) {
                
                if (array1.get(left) < array2.get(right)) {
                    super.add(array1.get(left));
                    left++;
                
                } else {
                    super.add(array2.get(right));
                    right++;
                }
            }

            while (left < array1.size()) {
                super.add(array1.get(left++));
            }
            
            while (right < array2.size()) {
                super.add(array2.get(right++));
            }
        }
    }
}
