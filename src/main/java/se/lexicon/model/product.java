package se.lexicon.model;

public interface product {

    String examine();
    String use();
    int getId();
    String getProductName();
    void setProductName(String productName);
    Double getPrice();
    Void setPrice(double price);
}
