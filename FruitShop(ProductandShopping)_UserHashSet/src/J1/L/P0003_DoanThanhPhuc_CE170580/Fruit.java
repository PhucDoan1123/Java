package J1.L.P0003_DoanThanhPhuc_CE170580;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class Fruit {

    private String ID;
    private String fName;
    private int price;
    private int quantity;
    private String origin;

    /**
     * Constructor for the Fruit class with parameters to initialize the fruit
     * object.
     *
     * @param ID the ID of the fruit
     * @param fName the name of the fruit
     * @param price the price of the fruit
     * @param quantity the quantity of the fruit
     * @param origin the origin of the fruit
     */
    public Fruit(String ID, String fName, int price, int quantity, String origin) {
        this.ID = ID;
        this.fName = fName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Retrieves the ID of the fruit.
     *
     * @return the ID of the fruit
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the ID of the fruit.
     *
     * @param ID the ID of the fruit
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Retrieves the name of the fruit.
     *
     * @return the name of the fruit
     */
    public String getfName() {
        return fName;
    }

    /**
     * Sets the name of the fruit.
     *
     * @param fName the name of the fruit
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Retrieves the price of the fruit.
     *
     * @return the price of the fruit
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the fruit.
     *
     * @param price the price of the fruit
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the fruit.
     *
     * @return the quantity of the fruit
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the fruit.
     *
     * @param quantity the quantity of the fruit
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieves the origin of the fruit.
     *
     * @return the origin of the fruit
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the fruit.
     *
     * @param origin the origin of the fruit
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
