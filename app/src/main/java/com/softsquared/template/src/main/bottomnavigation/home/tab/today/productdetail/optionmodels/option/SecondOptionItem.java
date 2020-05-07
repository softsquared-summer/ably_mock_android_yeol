package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.option;

public class SecondOptionItem {

    String SecondOption;
    String price;

    public SecondOptionItem(String secondOption, String price) {
        this.SecondOption = secondOption;
        this.price = price;
    }

    public String getSecondOption() {
        return SecondOption;
    }

    public void setSecondOption(String secondOption) {
        SecondOption = secondOption;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
