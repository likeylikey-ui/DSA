import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

class InventoryNode {
    MotorphInventory data;
    InventoryNode left, right;

    public InventoryNode(MotorphInventory item) {
        this.data = item;
        left = right = null;
    }
}

class InventoryBST {
    private InventoryNode root;

    public void insert(MotorphInventory item) {
        root = insertRec(root, item);
    }

    private InventoryNode insertRec(InventoryNode root, MotorphInventory item) {
        if (root == null) return new InventoryNode(item);
        if (item.brand.compareTo(root.data.brand) < 0) root.left = insertRec(root.left, item);
        else root.right = insertRec(root.right, item);
        return root;
    }

    public MotorphInventory search(String engineNumber) {
        return searchRec(root, engineNumber);
    }

    private MotorphInventory searchRec(InventoryNode root, String engineNumber) {
        if (root == null) return null;
        if (root.data.engineNumber.equals(engineNumber)) return root.data;
        if (engineNumber.compareTo(root.data.engineNumber) < 0) return searchRec(root.left, engineNumber);
        return searchRec(root.right, engineNumber);
    }

    public void inOrderTraversal(List<MotorphInventory> sortedList) {
        inOrderRec(root, sortedList);
    }

    private void inOrderRec(InventoryNode root, List<MotorphInventory> sortedList) {
        if (root != null) {
            inOrderRec(root.left, sortedList);
            sortedList.add(root.data);
            inOrderRec(root.right, sortedList);
        }
    }
}

public class Milestone {
    static class MotorphInventory {
        String dateEntered, stockLabel, brand, engineNumber, status;

        MotorphInventory(String d, String s, String b, String e, String st) {
            dateEntered = d;
            stockLabel = s;
            brand = b;
            engineNumber = e;
            status = st;
        }

        public String toString() {
            return String.join(", ", dateEntered, stockLabel, brand, engineNumber, status);
        }
    }

    public static void main(String[] args) throws IOException {
        InventoryBST inventoryTree = new InventoryBST();
        ArrayList<MotorphInventory> inventory = readCSV("Insert CSV file path");
        for (MotorphInventory item : inventory) inventoryTree.insert(item);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item\n2. Delete Item\n3. Modify Item\n4. Sort Stocks by Brand\n5. Search Inventory\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addItem(inventoryTree, scanner);
                case 2 -> deleteItem(inventoryTree, scanner);
                case 3 -> modifyItem(inventoryTree, scanner);
                case 4 -> sortByBrand(inventoryTree);
                case 5 -> searchInventory(inventoryTree, scanner);
                case 6 -> {
                    writeCSV("Insert CSV path", inventory);
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void modifyItem(InventoryBST inventory, Scanner scanner) {
        System.out.print("Enter Engine Number to modify: ");
        String engineNumber = scanner.nextLine();
        MotorphInventory item = inventory.search(engineNumber);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
        System.out.print("Enter new brand: ");
        item.brand = scanner.nextLine();
        System.out.print("Enter new status: ");
        item.status = scanner.nextLine();
        System.out.println("Item updated.");
    }

    private static void sortByBrand(InventoryBST inventory) {
        List<MotorphInventory> sortedList = new ArrayList<>();
        inventory.inOrderTraversal(sortedList);
        sortedList.forEach(System.out::println);
    }
} 
