package training.OOP.inheritance;

// Superclass with basic attributes
public class Book {
    
    // Encapsulation: private atributes, public getter and setter methods
    private String title;

    private String author;

    private Boolean isAvailable;

    public Book(String title, String author, Boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAvailability() {
        return this.isAvailable;
    }

    public void setAvailability(Boolean availability) {
        this.isAvailable = availability;
    }

    public void getBookInfo() {
        System.out.println("Author: " + this.author + "\nTitle: " + this.title + "\n");
    }

    public void borrowBook() {
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println(this.title + " by " + this.author + " has been borrowed\n");
        } else {
            System.out.println(this.title + " by " + this.author + " is already borrowed\n");
        }
    }

    public void returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            System.out.println(this.title + " by " + this.author + " has been returned\n");
        } else {
            System.out.println(this.title + " by " + this.author + " was not borrowed\n");
        }
    }

}