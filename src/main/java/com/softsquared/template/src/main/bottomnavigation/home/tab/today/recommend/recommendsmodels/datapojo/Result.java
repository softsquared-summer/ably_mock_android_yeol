package com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.datapojo;

public class Result
{
    private String productIdx;

    private String displayedPrice;

    private String marketName;

    private String marketIdx;

    private String purchaseCnt;

    private String isMyHeart;

    private String isHotDeal;

    private String isNew;

    private String productName;

    private String thumbnailUrl;

    private String discountRatio;

    public String getProductIdx ()
    {
        return productIdx;
    }

    public void setProductIdx (String productIdx)
    {
        this.productIdx = productIdx;
    }

    public String getDisplayedPrice ()
    {
        return displayedPrice;
    }

    public void setDisplayedPrice (String displayedPrice)
    {
        this.displayedPrice = displayedPrice;
    }

    public String getMarketName ()
    {
        return marketName;
    }

    public void setMarketName (String marketName)
    {
        this.marketName = marketName;
    }

    public String getMarketIdx ()
    {
        return marketIdx;
    }

    public void setMarketIdx (String marketIdx)
    {
        this.marketIdx = marketIdx;
    }

    public String getPurchaseCnt ()
    {
        return purchaseCnt;
    }

    public void setPurchaseCnt (String purchaseCnt)
    {
        this.purchaseCnt = purchaseCnt;
    }

    public String getIsMyHeart ()
    {
        return isMyHeart;
    }

    public void setIsMyHeart (String isMyHeart)
    {
        this.isMyHeart = isMyHeart;
    }

    public String getIsHotDeal ()
    {
        return isHotDeal;
    }

    public void setIsHotDeal (String isHotDeal)
    {
        this.isHotDeal = isHotDeal;
    }

    public String getIsNew ()
    {
        return isNew;
    }

    public void setIsNew (String isNew)
    {
        this.isNew = isNew;
    }

    public String getProductName ()
    {
        return productName;
    }

    public void setProductName (String productName)
    {
        this.productName = productName;
    }

    public String getThumbnailUrl ()
    {
        return thumbnailUrl;
    }

    public void setThumbnailUrl (String thumbnailUrl)
    {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDiscountRatio ()
    {
        return discountRatio;
    }

    public void setDiscountRatio (String discountRatio)
    {
        this.discountRatio = discountRatio;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [productIdx = "+productIdx+", displayedPrice = "+displayedPrice+", marketName = "+marketName+", marketIdx = "+marketIdx+", purchaseCnt = "+purchaseCnt+", isMyHeart = "+isMyHeart+", isHotDeal = "+isHotDeal+", isNew = "+isNew+", productName = "+productName+", thumbnailUrl = "+thumbnailUrl+", discountRatio = "+discountRatio+"]";
    }
}