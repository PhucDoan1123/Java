
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class DicManagament {

    private int numberW = 0;//Số lượng từ trong từ điển

    Dictionary dc = new Dictionary();//Biến đối tượng Dictionary

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    ArrayList<Dictionary> dic = new ArrayList<>();//ArrayList lưu word

    /**
     * Reads user information from a file
     *
     * It reads data from the "Dic.txt" file using a Scanner. The first line of
     * the file contains the number of users in the file. For each user, it
     * reads the username and password from consecutive lines and creates a new
     * User object. The User object is then added to the user list. If an
     * exception occurs during the process, it prints an error message.
     */
    public void readFile() {
        File in = new File("Dic.txt");  // Create a File object to represent the "User.txt" file
        try {
            Scanner sc = new Scanner(in);  // Create a Scanner to read data from the file
            numberW = Integer.parseInt(sc.nextLine());  // Read the number of users from the first line
            for (int i = 0; i < numberW; i++) {
                String EnWord = sc.nextLine();  // Read the username from the next line
                String VnWord = sc.nextLine(); // Read the password from the next line
                dic.add(new Dictionary(VnWord, EnWord));// Create a new User  object and add it to the user list
            }
        } catch (Exception e) {
            System.out.println("Error!");  // Print an error message if an exception occurs
        }
    }

    /**
     * Writes the user list to a file.
     *
     * It creates a FileWriter to write data to the "Dic.txt" file. It writes
     * the number of users in the user list as the first line of the file. Then,
     * for each user in the user list, it writes the username and password on
     * separate lines. Finally, it closes the FileWriter. If an exception occurs
     * during the process, it prints an error message.
     */
    public void writeFile() {
        try {
            FileWriter out = new FileWriter("Dic.txt");  // Create a FileWriter to write data to "User.txt"
            out.write(dic.size() + "\r\n");  // Write the number of users as the first line
            for (Dictionary u : dic) {
                out.write(u.getEnWord() + "\r\n");  // Write the username on a separate line
                out.write(u.getVnWord() + "\r\n");  // Write the password on a separate line
            }
            out.close();  // Close the FileWriter
        } catch (Exception e) {
            System.out.println("Error!");  // Print an error message if an exception occurs
        }
    }

    /**
     * Add new word
     *
     * Method used to add a new word to the dictionary. It displays the current
     * list of words, prompts for user input, and creates a new Dictionary
     * object. It checks if the entered English word already exists in the
     * dictionary. If it does, it displays an error message. Otherwise, it
     * proceeds to enter the Vietnamese word. Finally, it adds the new word to
     * the dictionary, displays the updated list, and updates the word count.
     */
    public void addW() {
        displayW();//Print dictionary
        System.out.println("------------- Add -------------");
        Dictionary newD = new Dictionary();//khai báo đối tượng tạm
        boolean check = true;//kiểm tra từ trùng
        Set<String> setEnW = new HashSet<>();//khai báo set kiểm tra dữ liệu
        for (Dictionary d : dic) {//lập qua từng phần tử đê lấy dẽ liệu
            setEnW.add(d.getEnWord().toLowerCase());//đưa tất cả English word vào set
        }
        do {
            newD.enterEnW();//nhập English word
            if (setEnW.contains(newD.getEnWord().toLowerCase())) {//nếu từ đã xuất hiện 
                System.out.println("This word already exists!");
            } else {
                check = false;//nếu từ chưa có trong dictionary
            }
        } while (check == true);//lập cho đến khi nhập từ chưa có trong dictionary
        newD.enterVnW();//nhập nghĩa trong tiếng Việt
        dic.add(newD);//thêm vào từ điển
        displayW();//in ra dictionary
        System.out.println("Added new word successfully");
        numberW = dic.size() - numberW;//cập nhật danh dictionary
    }

    /**
     * Method used to delete a word from the dictionary. It displays the current
     * list of words, prompts for user input, and attempts to find a matching
     * English word. If a match is found, the word is removed from the
     * dictionary, and the word count is updated. If no match is found, it
     * displays an error message. Finally, it displays the updated list of
     * words.
     */
    public void deleteW() {
        displayW();//in dictionary
        System.out.println("------------ Delete ----------------");
        boolean exitWord = false;//kiểm tra từ tồn tại
        dc.enterEnW();
        for (Dictionary d : dic) {//duyệt qua từ phần tử để kiểm tra
            if (d.getEnWord().equalsIgnoreCase(dc.getEnWord())) {//nếu từ tồn tại
                dic.remove(d);//xóa từ muốn xóa
                numberW--;//cập nhập dictionary
                exitWord = true;//cập nhập kiểm tra
                break;
            }
        }
        if (exitWord == false) {//nếu từ không tồn tại
            System.out.println("This word does not exist!");
        }
        displayW();//in dictionary
    }

    /**
     * Method used to translate an English word to Vietnamese. It prompts for
     * user input, and attempts to find a matching English word in the
     * dictionary. If a match is found, it displays the corresponding Vietnamese
     * word. If no match is found, it displays an error message.
     */
    public void tranlW() {
        boolean exitWord = false;//kiểm tra từ tồn tại
        dc.enterEnW();//nhập từ tiếng Anh
        for (Dictionary d : dic) {//duyệt qua từng phần tử để kiểm tra
            if (d.getEnWord().equalsIgnoreCase(dc.getEnWord())) {//nếu từ tồn tại
                System.out.println("Vietnamese: " + d.getVnWord());//in nghĩa tiếng Việt
                exitWord = true;//cập nhập kiểm tra
                break;
            }
        }
        if (exitWord == false) {//nếu từ không tồn tại
            System.out.println("This word does not exist!");
        }
    }

    /**
     * Method used to display the list of words in the dictionary. It prints the
     * English and Vietnamese words in a formatted table.
     */
    public void displayW() {
        System.out.println("+-------------------------------+-------------------------------+");
        System.out.println("|           English             |           Vietnamese          |");
        System.out.println("+-------------------------------+-------------------------------+");
        for (Dictionary d : dic) {//Duyệt qua từng phần tử để lấy dữ liệu
            d.printW();//in Englis word và Vietnamses Word
        }
        System.out.println("+-------------------------------+-------------------------------+");
    }

    /**
     * Run the program
     *
     * Method used to run the main program. It displays the menu options, reads
     * user input, and performs the corresponding action. It loops until the
     * user chooses to exit the program. It also handles any invalid input and
     * saves the dictionary to a file before exiting.
     */
    public void runProgram() {
        int op = 0;//Lựa chọn thực hiện chương trình
        readFile();//đọc file
        //Vòng lập thực hiện chương trình
        do {
            System.out.println("");
            //Menu của chương trình
            System.out.println("   Simple English - Vietnamese Dictionary");
            System.out.println("1. Add new word.");
            System.out.println("2. Delete word.");
            System.out.println("3. Search word.");
            System.out.println("4. Exit.");
            System.out.print("   Please choose: ");
            try {
                op = Integer.parseInt(sc.nextLine());//nhập lựa chọn
                switch (op) {
                    case 1: {//Nếu người dùng muốn thêm từ
                        addW();
                        break;
                    }
                    case 2: {//Nếu người dùng muốn xóa từ
                        deleteW();
                        break;
                    }
                    case 3: {//Nếu người dùng muốn tralate từ
                        tranlW();
                        break;
                    }
                    case 4: {//Thoát chương trình và ghi file
                        writeFile();
                        break;
                    }
                    default: {//nếu lựa chọn không nằm trong menu
                        System.out.println("Please enter a number from 1 to 4!");
                    }
                }
            } catch (NumberFormatException e) {//Nếu lựa chọn nhập vào không phải số nguyên
                System.out.println("Please enter an integer number.");
            }
        } while (op != 4);//Nếu lựa chọn không phải là 4
        System.out.println("Thank you for using the program!");
    }

}
