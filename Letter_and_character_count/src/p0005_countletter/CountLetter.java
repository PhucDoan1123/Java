/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0005_countletter;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class CountLetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Khai báo đối tượng CountLetter1
        CountLetter1 b = new CountLetter1();

        //Nhập chuỗi từ bàn phím và kiểm tra lỗi
        b.enterString();

        //Đếm số lần xuất hiện của từ và chữ cái có trong chuỗi
        //và in ra kết quả
        b.count();
    }

}
