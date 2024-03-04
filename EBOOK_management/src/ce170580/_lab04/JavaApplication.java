/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce170580._lab04;

import io.IOCE170580;

/**
 *
 * @author Acer
 */
public class JavaApplication {

    public static void main(String[] args) {
        int op;
        BookManegerment s = new BookManegerment();
        do {
            menu();
            op = IOCE170580.getInteger("Please select a function: ", "Invail!!");
            switch (op) {
                case 1: {
                    s.entryData();
                }
                break;
                case 2: {
                    s.prinTData();
                }
                break;
                case 3: {
                    s.biggest();
                }
                break;
                case 4: {
                    String a = IOCE170580.getString("Enter ID's Book which you want to search:  ", "Invalid!");
                    if(s.find(a)) {
                        System.out.println("Yes");
                    }else {
                        System.out.println("No");
                    }
                }break;
                case 5: {
                    s.sort();
                     }break;
                default: {
                    break;
                }
            }
        } while (op != 6);

    }
    public static void menu() {
        System.out.println("----- EBOOK MANAGEMENT -----");
        System.out.println("1. Adds new ebook.");
        System.out.println("2. Shows all ebooks.");
        System.out.println("3. The biggest size ebook.");
        System.out.println("4. Search a ebook by ID.");
        System.out.println("5. Sort by ID.");
        System.out.println("6. Quit.");
    }
}
