import java.util.*;
import java.util.LinkedList;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class Tree {
    TreeNode root;

    public Tree() {
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_size = size(root.left);
        int right_size = size(root.right);
        return left_size + right_size + 1;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_sum = sum(root.left);
        int right_sum = sum(root.right);
        return root.value + left_sum + right_sum;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left_max = max(root.left);
        int right_max = max(root.right);
        return Math.max(root.value, Math.max(left_max, right_max));
    }

    public int min(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left_min = min(root.left);
        int right_min = min(root.right);
        return Math.min(root.value, Math.min(left_min, right_min));
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height = height(root.left);
        int right_height = height(root.right);
        return Math.max(left_height, right_height) + 1;
    }

    public boolean includes(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.value == key) {
            return true;
        }
        boolean left_includes = includes(root.left, key);
        boolean right_includes = includes(root.right, key);
        return left_includes || right_includes;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left_balance = isBalanced(root.left);
        boolean right_balance = isBalanced(root.right);
        return left_balance && right_balance && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public boolean rootToNodePath(TreeNode root, int key, ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root.value == key) {
            path.add(root.value);
            return true;
        }
        boolean left_present = rootToNodePath(root.left, key, path);
        boolean right_present = rootToNodePath(root.right, key, path);
        if (left_present || right_present) {
            path.add(root.value);
        }
        return true;
    }

    public void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public ArrayList<TreeNode> preOrder(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root);
        ArrayList<TreeNode> left = preOrder(root.left);
        ArrayList<TreeNode> right = preOrder(root.right);
        ans.addAll(left);
        ans.addAll(right);
        return ans;
    }

    public ArrayList<Integer> preOrderValue(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.value);
        ArrayList<Integer> left = preOrderValue(root.left);
        ArrayList<Integer> right = preOrderValue(root.right);
        ans.addAll(left);
        ans.addAll(right);
        return ans;
    }

    public void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public ArrayList<TreeNode> inOrder(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<TreeNode> left = inOrder(root.left);
        ans.addAll(left);
        ans.add(root);
        ArrayList<TreeNode> right = inOrder(root.right);
        ans.addAll(right);
        return ans;
    }

    public ArrayList<Integer> inOrderValue(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> left = preOrderValue(root.left);
        ans.addAll(left);
        ans.add(root.value);
        ArrayList<Integer> right = preOrderValue(root.right);
        ans.addAll(right);
        return ans;
    }

    public void printPostOrder(TreeNode root) {
        if (root == null)
            return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value + " ");
    }

    public ArrayList<TreeNode> postOrder(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<TreeNode> left = inOrder(root.left);
        ans.addAll(left);
        ArrayList<TreeNode> right = inOrder(root.right);
        ans.addAll(right);
        ans.add(root);
        return ans;
    }

    public ArrayList<Integer> postOrderValue(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> left = preOrderValue(root.left);
        ans.addAll(left);
        ArrayList<Integer> right = preOrderValue(root.right);
        ans.addAll(right);
        ans.add(root.value);
        return ans;
    }

    public ArrayList<TreeNode> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<TreeNode> ans = new ArrayList<>();

        while (q.isEmpty()) {
            TreeNode curr = q.remove();
            ans.add(curr);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<TreeNode>> levelWiseLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<ArrayList<TreeNode>> ans = new ArrayList<>();

        while (q.isEmpty()) {
            int size = q.size();
            ArrayList<TreeNode> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = q.remove();
                level.add(curr);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans.add(new ArrayList<>(level));
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();

        n1.value = 10;
        n2.value = 20;
        n3.value = 30;
        n4.value = 40;
        n5.value = 50;
        n6.value = 60;

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        Tree t = new Tree(n1);
        // System.out.println("Size: " + t.size(n1));
        // System.out.println("Sum: " + t.sum(n1));
        // System.out.println("Max: " + t.max(n1));
        // System.out.println("Min: " + t.min(n1));
        // System.out.println("Height: " + t.height(n1));
        // System.out.println("Includes: " + t.includes(n1, 30));
        // System.out.println("Is Balanced: " + t.isBalanced(n1));
        // ArrayList<Integer> path = new ArrayList<>();
        // t.rootToNodePath(n1, 30, path);
        // System.out.println("Path: " + path);
        // t.printPreOrder(n1);
        // System.out.println();
        // t.printInOrder(n1);
        // System.out.println();
        // t.printPostOrder(n1);
        // System.out.println();

        // System.out.println("n1: " + n1.value + " left: " + n1.left.value + " right: "
        // + n1.right.value);

        System.out.println("Pre Order: " + t.preOrder(n1));
        System.out.println("Pre Order Value: " + t.preOrderValue(n1));
        System.out.println("In Order: " + t.inOrder(n1));
        System.out.println("In Order Value: " + t.inOrderValue(n1));
        System.out.println("Post Order: " + t.postOrder(n1));
        System.out.println("Post Order Value: " + t.postOrderValue(n1));

        ArrayList<TreeNode> ans = t.levelOrder(n1);
        System.out.println(ans);

        ArrayList<ArrayList<TreeNode>> ans2 = t.levelWiseLevelOrder(n1);
        System.out.println(ans2);

    }
}