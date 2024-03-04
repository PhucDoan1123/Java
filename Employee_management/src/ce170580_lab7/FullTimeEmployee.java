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
public class FullTimeEmployee extends Employee implements Reward, Salary {

    public FullTimeEmployee(String ID, String name, int yob, String address, int paymentPerhour) {
        super(ID, name, yob, address, paymentPerhour);
    }
    @Override
    public int calculateSalry() {
       return 8 * super.getPaymentPerhour();
    }
    @Override
    public double getReward() {
        return (double)calculateSalry() * 0.1;
    }

    @Override
    public void showProfile() {
        System.out.printf("|  FullTime:|%4s|%9s|%7d|%10s|      8|%7d$|%7d|%7.1f|\n",super.getID(),super.getName(),super.getYob(),super.getAddress(),super.getPaymentPerhour(),this.calculateSalry(),this.getReward());
    }
    
}
