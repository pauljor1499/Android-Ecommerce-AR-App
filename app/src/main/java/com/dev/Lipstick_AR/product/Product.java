package com.dev.Lipstick_AR.product;

public class Product {

    public String name;
    public String price;
    public int quantity;
    public double total;

    public Product(String prod_name, String prod_price, int prod_quantity, double prod_total) {

        this.name = prod_name;
        this.price = prod_price;
        this.quantity = prod_quantity;
        this.total = prod_total;
    }

}
