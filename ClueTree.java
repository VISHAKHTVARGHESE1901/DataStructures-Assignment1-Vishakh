import java.util.Scanner;

class ClueTree {
    private static class Node {
        String clue;
        Node left, right;

        Node(String clue) {
            this.clue = clue;
            left = right = null;
        }
    }

    private Node root;

    public ClueTree() {
        root = null;
    }

    // Insert a new clue
    public void insertClue(String clue) {
        root = insertRec(root, clue);
    }

    private Node insertRec(Node root, String clue) {
        if (root == null) {
            root = new Node(clue);
            return root;
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRec(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRec(root.right, clue);
        }
        return root;
    }

    // Perform in-order traversal
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.clue + " ");
            inOrderRec(root.right);
        }
    }

    // Perform pre-order traversal
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Perform post-order traversal
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a specific clue in the tree
    public boolean findClue(String clue) {
        return findClueRec(root, clue);
    }

    private boolean findClueRec(Node root, String clue) {
        if (root == null) {
            return false;
        }
        if (root.clue.equals(clue)) {
            return true;
        }
        if (clue.compareTo(root.clue) < 0) {
            return findClueRec(root.left, clue);
        }
        return findClueRec(root.right, clue);
    }

    // Count the total number of clues in the tree
    public int countClues() {
        return countCluesRec(root);
    }

    private int countCluesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countCluesRec(root.left) + countCluesRec(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClueTree clueTree = new ClueTree();

        while (true) {
            System.out.println("\nClue Tree Menu:");
            System.out.println("*---------------------*");
            System.out.println("1. Insert a new clue");
            System.out.println("2. Perform in-order traversal");
            System.out.println("3. Perform pre-order traversal");
            System.out.println("4. Perform post-order traversal");
            System.out.println("5. Find a specific clue");
            System.out.println("6. Count the total number of clues");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter clue to insert: ");
                    String clueToAdd = scanner.nextLine();
                    clueTree.insertClue(clueToAdd);
                    break;
                case 2:
                    System.out.println("\n----------------------------");
                    System.out.print("In-order traversal: ");
                    clueTree.inOrder();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n----------------------------");
                    System.out.print("Pre-order traversal: ");
                    clueTree.preOrder();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\n----------------------------");
                    System.out.print("Post-order traversal: ");
                    clueTree.postOrder();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter clue to find: ");
                    String clueToFind = scanner.nextLine();
                    boolean found = clueTree.findClue(clueToFind);
                    System.out.println(found ? "Clue found in the tree." : "Clue not found in the tree.");
                    break;
                case 6:
                    System.out.println("\n----------------------------");
                    int totalClues = clueTree.countClues();
                    System.out.println("Total number of clues in the tree: " + totalClues);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
