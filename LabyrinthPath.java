import java.util.Scanner;

class LabyrinthPath {
    private Node head;

    // Node class for singly linked list
    private static class Node {
        String location;
        Node next;

        Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    // Add a new location to the path
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("Path is empty. No location to remove.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Check if the path contains a loop (trap)
    public boolean containsLoop() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("Path is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.location + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LabyrinthPath path = new LabyrinthPath();

        while (true) {
            System.out.println("\nLabyrinth Path Menu:");
            System.out.println("*---------------------*");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove the last visited location");
            System.out.println("3. Check if the path contains a loop (trap)");
            System.out.println("4. Print the entire path");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter location to add: ");
                    String locationToAdd = scanner.nextLine();
                    path.addLocation(locationToAdd);
                    break;
                case 2:
                    System.out.println("\n----------------------------");
                    path.removeLastLocation();
                    break;
                case 3:
                    System.out.println("\n----------------------------");
                    boolean hasLoop = path.containsLoop();
                    System.out.println(hasLoop ? "The path contains a loop (trap)." : "The path does not contain a loop (trap).");
                    break;
                case 4:
                    System.out.println("\n----------------------------");
                    path.printPath();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
