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
public class PartTimePloyee extends Employee implements Salary{
    
    private int workingHours;

    public PartTimePloyee( String ID, String name, int yob, String address, int paymentPerhour,int workingHours) {
        super(ID, name, yob, address, paymentPerhour);
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
    @Override
    public void showProfile() {
        System.out.printf("|  PartTime:|%4s|%9s|%7d|%10s|%7d|%7d$|%7d|\n",super.getID(),super.getName(),super.getYob(),super.getAddress(),this.workingHours,super.getPaymentPerhour(),this.calculateSalry());

    }
    @Override
    public int calculateSalry() {
        return this.workingHours * super.getPaymentPerhour();
    }
    
}
