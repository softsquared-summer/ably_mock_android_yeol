package com.softsquared.template.src.main.bottomnavigation.home.tab.best.categoryrecyclerview;

public class CategoryItem {
    private String CategoryName;

    public CategoryItem(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
