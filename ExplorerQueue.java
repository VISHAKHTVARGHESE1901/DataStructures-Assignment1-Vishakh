import java.util.Scanner;

class ExplorerQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue new explorers
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot add new explorer.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = explorer;
        size++;
    }

    // Dequeue explorers when they enter the temple
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer to dequeue.");
            return null;
        }
        String explorer = queue[front];
        front = (front + 1) % capacity;
        size--;
        return explorer;
    }

    // Display the next explorer in line
    public String peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer to peek.");
            return null;
        }
        return queue[front];
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ExplorerQueue explorerQueue = new ExplorerQueue(capacity);

        while (true) {
            System.out.println("\nExplorer Queue Menu:");
            System.out.println("*---------------------*");
            System.out.println("1. Enqueue new explorer");
            System.out.println("2. Dequeue explorer");
            System.out.println("3. Display the next explorer in line");
            System.out.println("4. Check if the queue is full");
            System.out.println("5. Check if the queue is empty");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter explorer name to enqueue: ");
                    String explorerToAdd = scanner.nextLine();
                    explorerQueue.enqueue(explorerToAdd);
                    break;
                case 2:
                    System.out.println("\n----------------------------");
                    String dequeuedExplorer = explorerQueue.dequeue();
                    if (dequeuedExplorer != null) {
                        System.out.println("Dequeued explorer: " + dequeuedExplorer);
                    }
                    break;
                case 3:
                    System.out.println("\n----------------------------");
                    String nextExplorer = explorerQueue.peek();
                    if (nextExplorer != null) {
                        System.out.println("Next explorer in line: " + nextExplorer);
                    }
                    break;
                case 4:
                    System.out.println("\n----------------------------");
                    System.out.println(explorerQueue.isFull() ? "The queue is full." : "The queue is not full.");
                    break;
                case 5:
                    System.out.println("\n----------------------------");
                    System.out.println(explorerQueue.isEmpty() ? "The queue is empty." : "The queue is not empty.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
