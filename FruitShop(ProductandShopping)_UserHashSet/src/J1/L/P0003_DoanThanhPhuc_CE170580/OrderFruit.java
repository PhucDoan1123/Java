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
class OrderFruit {

    /**
     *
     * Represents an order item of a fruit.
     */
    private String oName; // The name of the fruit in the order
    private int oQuality; // The quantity of the fruit in the order
    private int oPrice; // The price of the fruit in the order

    /**
     *
     * Default constructor for the OrderFruit class.
     */
    public OrderFruit() {
    }

    /**
     *
     * Constructor for the OrderFruit class.
     *
     * @param oName The name of the fruit in the order
     * @param oQuality The quantity of the fruit in the order
     * @param oPrice The price of the fruit in the order
     */
    public OrderFruit(String oName, int oQuality, int oPrice) {
        this.oName = oName;
        this.oQuality = oQuality;
        this.oPrice = oPrice;
    }

    /**
     *
     * Returns the name of the fruit in the order.
     *
     * @return The name of the fruit
     */
    public String getoName() {
        return oName;
    }

    /**
     *
     * Sets the name of the fruit in the order.
     *
     * @param oName The name of the fruit
     */
    public void setoName(String oName) {
        this.oName = oName;
    }

    /**
     *
     * Returns the quantity of the fruit in the order.
     *
     * @return The quantity of the fruit
     */
    public int getoQuality() {
        return oQuality;
    }

    /**
     *
     * Sets the quantity of the fruit in the order.
     *
     * @param oQuality The quantity of the fruit
     */
    public void setoQuality(int oQuality) {
        this.oQuality = oQuality;
    }

    /**
     *
     * Returns the price of the fruit in the order.
     *
     * @return The price of the fruit
     */
    public int getoPrice() {
        return oPrice;
    }

    /**
     *
     * Sets the price of the fruit in the order.
     *
     * @param oPrice The price of the fruit
     */
    public void setoPrice(int oPrice) {
        this.oPrice = oPrice;
    }

}
