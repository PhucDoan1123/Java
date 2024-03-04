/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce170580_lab7;

/**
 *
 * @author Doan Thanh Phuc
 */
public abstract class Employee extends Person{
    private int paymentPerhour;

    public Employee(String ID, String name, int yob, String address,int paymentPerhour) {
        super(ID, name, yob, address);
        this.paymentPerhour = paymentPerhour;
    }

    public int getPaymentPerhour() {
        return paymentPerhour;
    }

    public void setPaymentPerhour(int paymentPerhour) {
        this.paymentPerhour = paymentPerhour;
    }
    
}
