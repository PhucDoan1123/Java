
package ce170580_lab05;

/**
 *
 * @author Đoàn Thanh Phúc
 */
public class EBook extends Book{
    private String URL;

    public EBook() {
    }

    public EBook(String ID, String name, int year, String author, int size,String URL) {
        super(ID, name, year, author, size);
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf(" %-19s |\n",URL);
    }
}
