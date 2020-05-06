package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.datapojo;

public class ProductDetailResult
{
        private String displayedPrice;

        private String isMyHeart;

        private String productName;

        private String[] mainImgUrlList;

        private String marketHashTags;

        private String productIdx;

        private String marketName;

        private String productCode;

        private String marketThumbnailUrl;

        private String contents;

        private String price;

        private String marketIdx;

        private String[] normalImgUrlList;

        private String discountRatio;

        public String getDisplayedPrice ()
        {
            return displayedPrice;
        }

        public void setDisplayedPrice (String displayedPrice)
        {
            this.displayedPrice = displayedPrice;
        }

        public String getIsMyHeart ()
        {
            return isMyHeart;
        }

        public void setIsMyHeart (String isMyHeart)
        {
            this.isMyHeart = isMyHeart;
        }

        public String getProductName ()
        {
            return productName;
        }

        public void setProductName (String productName)
        {
            this.productName = productName;
        }

        public String[] getMainImgUrlList ()
        {
            return mainImgUrlList;
        }

        public String getMainImgUrlList (int i)
        {
        return mainImgUrlList[i];
        }


        public void setMainImgUrlList (String[] mainImgUrlList)
        {
            this.mainImgUrlList = mainImgUrlList;
        }

        public String getMarketHashTags ()
        {
            return marketHashTags;
        }

        public void setMarketHashTags (String marketHashTags)
        {
            this.marketHashTags = marketHashTags;
        }

        public String getProductIdx ()
        {
            return productIdx;
        }

        public void setProductIdx (String productIdx)
        {
            this.productIdx = productIdx;
        }

        public String getMarketName ()
        {
            return marketName;
        }

        public void setMarketName (String marketName)
        {
            this.marketName = marketName;
        }

        public String getProductCode ()
        {
            return productCode;
        }

        public void setProductCode (String productCode)
        {
            this.productCode = productCode;
        }

        public String getMarketThumbnailUrl ()
        {
            return marketThumbnailUrl;
        }

        public void setMarketThumbnailUrl (String marketThumbnailUrl)
        {
            this.marketThumbnailUrl = marketThumbnailUrl;
        }

        public String getContents ()
        {
            return contents;
        }

        public void setContents (String contents)
        {
            this.contents = contents;
        }

        public String getPrice ()
        {
            return price;
        }

        public void setPrice (String price)
        {
            this.price = price;
        }

        public String getMarketIdx ()
        {
            return marketIdx;
        }

        public void setMarketIdx (String marketIdx)
        {
            this.marketIdx = marketIdx;
        }

        public String[] getNormalImgUrlList ()
        {
            return normalImgUrlList;
        }

        public void setNormalImgUrlList (String[] normalImgUrlList)
        {
            this.normalImgUrlList = normalImgUrlList;
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
            return "ClassPojo [displayedPrice = "+displayedPrice+", isMyHeart = "+isMyHeart+", productName = "+productName+", mainImgUrlList = "+mainImgUrlList+", marketHashTags = "+marketHashTags+", productIdx = "+productIdx+", marketName = "+marketName+", productCode = "+productCode+", marketThumbnailUrl = "+marketThumbnailUrl+", contents = "+contents+", price = "+price+", marketIdx = "+marketIdx+", normalImgUrlList = "+normalImgUrlList+", discountRatio = "+discountRatio+"]";
        }
}