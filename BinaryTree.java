import java.util.*;

public class BinaryTree {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public void populate(Scanner scanner) {
        System.out.print("Enter the root node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node nodes) {
        System.out.println("Do you want to enter left of " + nodes.value + " ? (true/false)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of left of " + nodes.value + ": ");
            int value = scanner.nextInt();
            nodes.left = new Node(value);
            populate(scanner, nodes.left);
        }

        System.out.println("Do you want to enter right of " + nodes.value + " ? (true/false)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of right of " + nodes.value + ": ");
            int value = scanner.nextInt();
            nodes.right = new Node(value);
            populate(scanner, nodes.right);
        }
    }
    public int minPathSum(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.value;
        }

        int leftSum = minPathSum(node.left);
        int rightSum = minPathSum(node.right);

        return node.value + Math.min(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);

        int result = tree.minPathSum(tree.root);
        System.out.println("Minimum path sum is :" + result);
    }
}
