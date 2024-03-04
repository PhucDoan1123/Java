
package ce170580._lab04;

/**
 *
 * @author Doan Thanh Phuc
 *
 */
public class Book {

    private String ID;
    private String Name;
    private int year;
    private String author;
    private int Size;

    public Book() {
    }

    public Book(String ID, String Name, int year, String author, int Size) {
        this.ID = ID;
        this.Name = Name;
        this.year = year;
        this.author = author;
        this.Size = Size;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public void showIno() {
        System.out.printf("| %-6s| %-18s |%5d | %-17s | %5d | \n", this.ID, this.Name, this.year, this.author, this.Size);
    }
    
}
