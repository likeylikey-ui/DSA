
package day5;
import java.util.Scanner;


public class Day5 {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] myStocks = new String[5];
        int index = 0;
        
        boolean exit = false;
        while(true) {
            System.out.print("      Inventory System\n1. Add Item\n2. Show Items\n3. Delete Item\n4. Edit Item\n0. Exit\nSelect option: ");
            String answer = scan.nextLine();
            
            switch (answer) {
                case "1":
                    if (index < myStocks.length) {
                        System.out.print("Enter item: ");
                        myStocks[index] = scan.nextLine();
                        index = index + 1;
                    } else {
                        System.out.println ("   Full!");
                    } 
                    break;
                case "2":
                    boolean noItem = false;
                    
                    for (int i = 0; i < myStocks.length; i++) {
                        if (myStocks[i] != null) {
                            noItem = true;
                            break;
                        }
                    }
                    
                    if (noItem) {
                        for (int i = 0; i <myStocks.length; i++) {
                            if (myStocks[i] != null) {
                                System.out.println(myStocks[i]);
                                break;
                            }
                        }
                        System.out.println();
                    } else {
                        System.out.println(" NO ITEM");
                    }
                    break;
                case "3":
                    System.out.print("Enter item to delete: ");
                    String toSearch = scan.nextLine();
                    
                    boolean isDeleted = false;
                    for (int i = 0; i <myStocks.length; i++) {
                        if (toSearch.equalsIgnoreCase(myStocks[i])) {
                            myStocks[i] = null;
                            isDeleted = true;
                            break;
                        }
                    }
                    
                    if (isDeleted) {
                        System.out.println("Item was deleted.");
                        index = index - 1;
                    } else {
                        System.out.println("Item does not exists.");
                    }
                case "4":
                    System.out.print("Enter item to edit: ");
                    String itemToEdit = scan.nextLine();
                    
                    int myItem = 0;
                    boolean isExists = false;
                    for (int i = 0; i < myStocks.length; i++) {
                        if (itemToEdit.equalsIgnoreCase(myStocks[i])) {
                            myItem = i;
                            isExists = true;
                            break;
                        }
                    }
                    
                    if (isExists) {
                        System.out.print("Enter new item name: ");
                        myStocks[myItem] = scan.nextLine();
                        System.out.println("    success.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break; 
                default:
                    System.out.print(" Invalid Input\n");
            }       
        }
    }
}