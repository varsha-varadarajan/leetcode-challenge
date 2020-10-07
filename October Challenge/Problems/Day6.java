package Problems;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day6 {
    // TC: O(h)
    // SC: O(1)
    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode main = root;
        TreeNode parent = root;
        TreeNode node = new TreeNode(val);
        
        while (root != null) {
            if (val < root.val) {
                parent = root;
                root = root.left;
            } else if (val > root.val) {
                parent = root;
                root = root.right;
            }
        }
        
        if (val < parent.val) {
            parent.left = node;
        } else if (val > parent.val) {
            parent.right = node;
        }
        
        return main;
    }
    
    // TC: O(h)
    // SC: O(h)
    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insertIntoBSTRecursive(root.left, val);
        } else {
            root.right = insertIntoBSTRecursive(root.right, val);
        }
        
        return root;
    }
}
