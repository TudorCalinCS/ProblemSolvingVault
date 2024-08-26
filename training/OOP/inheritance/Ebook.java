package training.OOP.inheritance;

// Inheritance: subclass inherits from superclass and extends it with additional attributes
public class Ebook extends Book {

    private Double fileSize;
    
    private String fileFormat;

    public Ebook(String title, String author, Boolean isAvailable, Double fileSize, String fileFormat) {
        super(title, author, isAvailable);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    // Polymorphism in action, overriden method from superclass
    @Override
    public void getBookInfo() {
        super.getBookInfo();
        System.out.println(this.getTitle() + "." + this.fileFormat + "  " + String.format("%.02f", fileSize) + "kb\n");
    }

}
