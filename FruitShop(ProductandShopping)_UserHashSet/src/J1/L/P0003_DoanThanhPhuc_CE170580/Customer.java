package J1.L.P0003_DoanThanhPhuc_CE170580;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class Customer {

    private String cName;// name of order customer
    private int numberOfItems;//number of item
    private ArrayList<OrderFruit> item;// item được order

    /**
     * The Customer function is a constructor (initializer) of the Customer
     * class. This constructor takes three arguments, cName, numberOfItems, and
     * item, and is used to create a new Customer object.
     *
     * @param cName name of Customer
     * @param numberOfItems is number of item which have ordered
     * @param item which item have ordered
     *
     */
    public Customer(String cName, int numberOfItems, ArrayList<OrderFruit> item) {
        this.cName = cName;
        this.numberOfItems = numberOfItems;
        this.item = item;
    }

    /**
     *
     * Returns the name of the customer.
     *
     * @return The name of the customer
     */
    public String getcName() {
        return cName;
    }

    /**
     *
     * Sets the name of the customer.
     *
     * @param cName The name of the customer
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     *
     * Returns the number of items of the customer.
     *
     * @return The number of items
     */
    public int getNumberOfItems() {
        return numberOfItems;
    }

    /**
     *
     * Sets the number of items of the customer.
     *
     * @param numberOfItems The number of items
     */
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    /**
     *
     * Returns the list of items of the customer.
     *
     * @return The list of items
     */
    public ArrayList<OrderFruit> getItem() {
        return item;
    }

    /**
     *
     * Sets the list of items of the customer.
     *
     * @param item The list of items
     */
    public void setItem(ArrayList<OrderFruit> item) {
        this.item = item;
    }

}
