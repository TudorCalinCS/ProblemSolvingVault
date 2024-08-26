package training.OOP.inheritance;

public class Main {
    public static void main(String args[]) {
        
        Library library = new Library();
        Book book1 = new Book("A Promised Land", "Barack Obama", true);
        Book book2 = new Book("Permanent Record", "Edward Snowden", true);
        Ebook ebook1 = new Ebook("The History of Bees", "Maja Lunde", true, 64.597, "pdf");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(ebook1);
        library.listBooks();

        book1.borrowBook();
        ebook1.borrowBook();

        library.listAvailableBooks();

        book1.returnBook();
        library.listAvailableBooks();
    }
}