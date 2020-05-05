package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.productdetailmodels.ProductdetailDefaultResponse;

public interface ProductdetailActivityView {

    void validateSuccess(ProductdetailDefaultResponse result);
    void validateFailure(String message);
}
