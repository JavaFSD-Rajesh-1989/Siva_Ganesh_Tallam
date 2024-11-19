package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManager {
    private List<Book> inventory;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    public void addBook(Book book) {
        // Check if the book already exists in the inventory based on id
        for (Book existingBook : inventory) {
            if (existingBook.getId() == book.getId()) {
                existingBook.setQuantity(existingBook.getQuantity() + book.getQuantity());
                return;
            }
        }
        inventory.add(book);
    }

    public void removeBook(int bookId) throws BookNotFoundException {
        Book bookToRemove = null;
        for (Book book : inventory) {
            if (book.getId() == bookId) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove == null) {
            throw new BookNotFoundException("Book with id " + bookId + " not found.");
        }
        inventory.remove(bookToRemove);
    }

    public List<Book> getBooksByAuthor(String author) {
        return inventory.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public double getTotalInventoryValue() {
        double totalValue = 0;
        for (Book book : inventory) {
            totalValue += book.getPrice() * book.getQuantity();
        }
        return totalValue;
    }

    public List<Book> sortBooksByTitle() {
        return inventory.stream()
                .sorted((book1, book2) -> book1.getTitle().compareToIgnoreCase(book2.getTitle()))
                .collect(Collectors.toList());
    }


}
