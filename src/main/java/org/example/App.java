package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        InventoryManager inventoryManager = new InventoryManager();
        Book book1 = new Book(1, "Devara", "Koratala Siva", 230, 1);
        inventoryManager.addBook(book1);

        System.out.println(book1);
        System.out.println("Priniting Total Value");
        System.out.println(inventoryManager.getTotalInventoryValue());
        System.out.println("Koratala Siva ");

        for(Book book : inventoryManager.getBooksByAuthor("Koratala Siva")) {
            System.out.println(book.getTitle());
        }

        System.out.println("\nBooks sorted by title:");
        for (Book book : inventoryManager.sortBooksByTitle()) {
            System.out.println(book.getTitle());
        }
    }
}
