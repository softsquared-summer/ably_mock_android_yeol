package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.Cart;

public class CartItem {


    String ProductName;
    String ProductOption;
    String ProductPrice;

    public CartItem(String productName, String productOption, String productPrice) {
        ProductName = productName;
        ProductOption = productOption;
        ProductPrice = productPrice;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductOption() {
        return ProductOption;
    }

    public void setProductOption(String productOption) {
        ProductOption = productOption;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}
