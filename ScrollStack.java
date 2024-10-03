import java.util.Scanner;
import java.util.Stack;

class ScrollStack {
    private Stack<String> stack;

    public ScrollStack() {
        stack = new Stack<>();
    }

    // Push a new scroll onto the stack
    public void pushScroll(String scroll) {
        stack.push(scroll);
    }

    // Pop the top scroll off the stack
    public String popScroll() {
        if (stack.isEmpty()) {
            System.out.println("The stack is empty. No scroll to pop.");
            return null;
        }
        return stack.pop();
    }

    // Peek at the top scroll without removing it
    public String peekScroll() {
        if (stack.isEmpty()) {
            System.out.println("The stack is empty. No scroll to peek.");
            return null;
        }
        return stack.peek();
    }

    // Check if a specific scroll title exists in the stack
    public boolean containsScroll(String scroll) {
        return stack.contains(scroll);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScrollStack scrollStack = new ScrollStack();

        while (true) {
            System.out.println("\nScroll Stack Menu:");
            System.out.println("*---------------------*");
            System.out.println("1. Push a new scroll onto the stack");
            System.out.println("2. Pop the top scroll off the stack");
            System.out.println("3. Peek at the top scroll without removing it");
            System.out.println("4. Check if a specific scroll title exists in the stack");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter scroll title to push: ");
                    String scrollToAdd = scanner.nextLine();
                    scrollStack.pushScroll(scrollToAdd);
                    break;
                case 2:
                    System.out.println("\n----------------------------");
                    String poppedScroll = scrollStack.popScroll();
                    if (poppedScroll != null) {
                        System.out.println("Popped scroll: " + poppedScroll);
                    }
                    break;
                case 3:
                    System.out.println("\n----------------------------");
                    String topScroll = scrollStack.peekScroll();
                    if (topScroll != null) {
                        System.out.println("Top scroll: " + topScroll);
                    }
                    break;
                case 4:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter scroll title to check: ");
                    String scrollToCheck = scanner.nextLine();
                    boolean exists = scrollStack.containsScroll(scrollToCheck);
                    System.out.println(exists ? "The scroll exists in the stack." : "The scroll does not exist in the stack.");
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
