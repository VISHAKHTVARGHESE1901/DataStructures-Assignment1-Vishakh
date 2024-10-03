import java.util.Arrays;
import java.util.Scanner;

class ArtifactVault {
    private String[] artifacts;
    private int size;

    public ArtifactVault(int capacity) {
        artifacts = new String[capacity];
        size = 0;
    }

    // Add an artifact to the first empty slot
    public void addArtifact(String artifact) {
        if (size < artifacts.length) {
            artifacts[size] = artifact;
            size++;
            Arrays.sort(artifacts, 0, size); // Keep the array sorted by artifact age
        } else {
            System.out.println("Vault is full. Cannot add more artifacts.");
        }
    }

    // Remove an artifact by its name
    public void removeArtifact(String artifact) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].equals(artifact)) {
                artifacts[i] = artifacts[size - 1];
                artifacts[size - 1] = null;
                size--;
                Arrays.sort(artifacts, 0, size); // Keep the array sorted by artifact age
                return;
            }
        }
        System.out.println("Artifact not found.");
    }

    // Find an artifact using linear search
    public int findArtifactLinear(String artifact) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].equals(artifact)) {
                return i;
            }
        }
        return -1; // Artifact not found
    }

    // Find an artifact using binary search (assume the array is kept sorted by artifact age)
    public int findArtifactBinary(String artifact) {
        return Arrays.binarySearch(artifacts, 0, size, artifact);
    }


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the size of your Artifact Vault: ");
    int size = scanner.nextInt();
    ArtifactVault vault = new ArtifactVault(size);

    while (true) {
        System.out.println("\n Artifact Vault Menu:");
        System.out.println("*---------------------*");
        System.out.println("1. Add an artifact");
        System.out.println("2. Remove an artifact");
        System.out.println("3. Find an artifact using Linear Search");
        System.out.println("4. Find an artifact using Binary Search");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter artifact name to add: ");
                    String artifactToAdd = scanner.nextLine();
                    vault.addArtifact(artifactToAdd);
                    break;
                case 2:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter artifact name to remove: ");
                    String artifactToRemove = scanner.nextLine();
                    vault.removeArtifact(artifactToRemove);
                    break;
                case 3:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter artifact name to find (Linear Search): ");
                    String artifactToFindLinear = scanner.nextLine();
                    int indexLinear = vault.findArtifactLinear(artifactToFindLinear);
                    System.out.println(indexLinear != -1 ? "Found at index " + indexLinear : "Not found");
                    break;
                case 4:
                    System.out.println("\n----------------------------");
                    System.out.print("Enter artifact name to find (Binary Search): ");
                    String artifactToFindBinary = scanner.nextLine();
                    int indexBinary = vault.findArtifactBinary(artifactToFindBinary);
                    System.out.println(indexBinary >= 0 ? "Found at index " + indexBinary : "Not found");
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
