/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce170580._lab04;

import io.IOCE170580;
import java.util.ArrayList;

/**
 *
 * @author Doan Thanh Phuc
 */
public class BookManegerment {

    private ArrayList<Book> listEbook = new ArrayList<>();

    public BookManegerment() {
    }

    {
        listEbook.add(new Book("0002", "Dac Nhan Tam", 1968, "To Do Hong Y", 500));
        listEbook.add(new Book("0003", "Nhat Ky Trong Tu", 1990, "Ho Chi Minh", 350));

    }

    public void prinTData() {
        int i = 1;
        System.out.println("| No. |  ID   | Book name          | Year |  Author's Name    |  Size |");
        System.out.println("+-----+-------+--------------------+------+-------------------+-------+");

        for (Book b : listEbook) {
            System.out.printf("| %-3d ", i++);
            b.showIno();
        System.out.println("+-----+-------+--------------------+------+-------------------+-------+");

        }
    }

    public void entryData() {
        String ID = IOCE170580.getString("Enter new BookID: ", "Invalid!");
        for (Book b : listEbook) {
            while (b.getID().equalsIgnoreCase(ID) != false) {
                System.out.println("This ID already exists.Please enter ID again!!");
                ID = IOCE170580.getString("Enter new BookID: ", "Invaile!");
            }
        }
        String Name = IOCE170580.getString("Enter new BookName: ", "Invaile!");
        int Year = IOCE170580.getInteger("Enter new BookYear: ", "Invaile!");
        String Author = IOCE170580.getString("Enter author's name: ", "Invaile!");
        int Size = IOCE170580.getInteger("Enter size's book: ", "Invaile!");
        Book b1 = new Book(ID, Name, Year, Author, Size);
        listEbook.add(b1);
    }

    public void biggest() {
        int maxSize = 0;
        Book highest = null;
        for (Book b : listEbook) {
            if (b.getSize() > maxSize) {
                maxSize = b.getSize();
                highest = b;
            }
        }
        System.out.println("The book has the biggest size is/are: ");
        for (Book b : listEbook) {
            if (b.getSize() == maxSize) {
                b.showIno();

            }
        }

    }

    public boolean find(String ID) {
        for (Book t : listEbook) {
            if (t.getID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        for (int i = 0; i < listEbook.size(); i++) {
            for (int j = i + 1; j < listEbook.size(); j++) {
                if (listEbook.get(i).getID().compareTo(listEbook.get(j).getID()) > 0) {
                    Book b = listEbook.get(i);
                    listEbook.set(i, listEbook.get(j));
                    listEbook.set(j, b);
                }
            }
        }
        int i = 1;
        System.out.println("| No. |  ID   | Book name          | Year |  Author's Name    |  Size |");
        System.out.println("+-----+-------+--------------------+------+-------------------+-------+");
        for (Book b : listEbook) {
            System.out.printf("| %-3d ", i++);
            b.showIno();
        System.out.println("+-----+-------+--------------------+------+-------------------+-------+");

        }
    }
}
