
package day4;
import java.util.Scanner;

public class Day4 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int maxCapacity = 300;
        String stocksInventory[] = new String[maxCapacity];
        int itemCount = 0;
        
        boolean exit = false;
        while(true) {
            System.out.print("      MotorPH Inventory System\n1. Add Item\n2. Delete Item\n3. Show Inventory\n4. Exit\nSelect option: ");
            int choice = scan.nextInt();
            
            switch (choice) {
                case 1:
                    if (itemCount < maxCapacity) {
                        System.out.print("Enter Date when stock is added: ");
                        String date = scan.next();
                        System.out.print("Enter Stock Label             : ");
                        String stockLabel = scan.next();
                        System.out.print("Enter Stock Brand             : ");
                        String brand = scan.next();
                        System.out.print("Enter Engine Number           : "); 
                        String engineNumber = scan.next();
                        System.out.print("Enter Stock's purchase status : ");
                        String status = scan.next();
                        System.out.println("Stock added successfully.");
                        itemCount++;
                    } else {
                        System.out.println("Inventory in full capacity! Remove items.");
                    }
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Show list of Current Stocks:");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            if (choice == 0) {
                exit =  true;
                break;
            }
        }
    }
}
