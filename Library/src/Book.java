public class Book extends AbstractItem{
    private String author;

    public Book(String id, String title, String author){
        super(id, title);
        this.author = author;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
