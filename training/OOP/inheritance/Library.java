package training.OOP.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        System.out.println("List of all books: \n");
        for (Book book : books) {
            book.getBookInfo();
        }
    }

    public void findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.getBookInfo();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void listAvailableBooks() {
        System.out.println("List of available books: \n");
        for (Book book : books) {
            if (book.getAvailability()) {
                book.getBookInfo();
            }
        }
    }
}
