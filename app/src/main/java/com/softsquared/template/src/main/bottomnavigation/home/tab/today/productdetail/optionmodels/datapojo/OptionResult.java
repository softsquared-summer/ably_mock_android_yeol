package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.datapojo;

public class OptionResult
{
    private String secondOption;

    private String firstOption;

    private String detailedPrice;

    private String detailedProductIdx;

    private String stock;

    public String getSecondOption ()
    {
        return secondOption;
    }

    public void setSecondOption (String secondOption)
    {
        this.secondOption = secondOption;
    }

    public String getFirstOption ()
    {
        return firstOption;
    }

    public void setFirstOption (String firstOption)
    {
        this.firstOption = firstOption;
    }

    public String getDetailedPrice ()
    {
        return detailedPrice;
    }

    public void setDetailedPrice (String detailedPrice)
    {
        this.detailedPrice = detailedPrice;
    }

    public String getDetailedProductIdx ()
    {
        return detailedProductIdx;
    }

    public void setDetailedProductIdx (String detailedProductIdx)
    {
        this.detailedProductIdx = detailedProductIdx;
    }

    public String getStock ()
    {
        return stock;
    }

    public void setStock (String stock)
    {
        this.stock = stock;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [secondOption = "+secondOption+", firstOption = "+firstOption+", detailedPrice = "+detailedPrice+", detailedProductIdx = "+detailedProductIdx+", stock = "+stock+"]";
    }
}