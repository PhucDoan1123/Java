
package ce170580_lab05;

/**
 *
 * @author Đoàn Thanh Phúc
 */
public class Book {
    protected String ID;
    protected String name;
    protected int year;
    protected String author;
    protected int size;

    public Book() {
    }

    public Book(String ID, String name, int year, String author, int size) {
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.author = author;
        this.size = size;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
     public void showInfo() {
        System.out.printf("| %-6s| %-18s |%5d | %-17s | %5d | ", this.ID, this.name, this.year, this.author, this.size);
    }
}
