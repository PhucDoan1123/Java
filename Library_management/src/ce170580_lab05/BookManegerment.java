package ce170580_lab05;

import io.IOCE170580;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class BookManegerment {

    private ArrayList<EBook> listEbook = new ArrayList<>();

    public BookManegerment() {
    }

    {
        listEbook.add(new EBook("0002", "Dac Nhan Tam", 1972, "Pham Nhut Vuong", 500, "SachHay.com"));
        listEbook.add(new EBook("0003", "Luoc Su loai Nguoi", 1990, "Tran Quoc Toan", 700, "LuocSu.net"));

    }

    public void prinTData() {
        int i = 1;
        System.out.println("| No. |  ID   | Book name          | Year |  Author's Name    |  Size |  URL                 |");
        System.out.println("+-----+-------+--------------------+------+-------------------+-------+----------------------|");

        for (Book b : listEbook) {
            System.out.printf("| %-3d ", i++);
            b.showInfo();
        System.out.println("+-----+-------+--------------------+------+-------------------+-------+----------------------|");

        }
    }

    public void entryData() {
        String ID = IOCE170580.getString("Enter new BookID: ", "Invalid!\n");
        for (EBook b : listEbook) {
            while (b.getID().equalsIgnoreCase(ID) != false) {
                System.out.println("This ID already exists.Please enter ID again!!");
                ID = IOCE170580.getString("Enter new BookID: ", "Invalid!\n");
            }
        }
        String Name = IOCE170580.getString("Enter new BookName: ", "Invalid!\n");
        int Year = IOCE170580.getInteger("Enter new BookYear: ", "Invalid!\n");
        String Author = IOCE170580.getString("Enter author's name: ", "Invalid!\n");
        int Size = IOCE170580.getInteger("Enter size's book: ", "Invalid!\n");
        String URL = IOCE170580.getString("Enter Book's URL: ", "Invalid!\n");
        EBook b1 = new EBook(ID, Name, Year, Author, Size, URL);
        listEbook.add(b1);
    }

    public void biggest() {
        int maxSize = 0;
        EBook highest = null;
        for (EBook b : listEbook) {
            if (b.getSize() > maxSize) {
                maxSize = b.getSize();
                highest = b;
            }
        }
        System.out.println("The book has the biggest size is/are: ");
        for (EBook b : listEbook) {
            if (b.getSize() == maxSize) {
                b.showInfo();

            }
        }
    }
    public boolean searchBookByID(String ID) {
        
        for(EBook t : listEbook) {
            if (t.getID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public EBook searchBookOjectByID(String ID) {
        for (EBook t : listEbook) {
            if (t.ID.indexOf(ID) >= 0) {
                t.showInfo();
                return t;
            }
        }
        return null ;

    }
    public void sort() {
        int maxSize = 0;
        for (int i = 0; i < listEbook.size(); i++) {
            for (int j = i + 1; j < listEbook.size(); j++) {
                if (listEbook.get(i).getSize() > listEbook.get(j).getSize()) {
                    EBook b = listEbook.get(i);
                    listEbook.set(i, listEbook.get(j));
                    listEbook.set(j, b);
                }
            }
        }
    }
}
