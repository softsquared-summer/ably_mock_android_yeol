package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.orderinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.order.ordermodels.OrderDefaultResponse;

public interface OrderActivityView {

    void validateSuccess(OrderDefaultResponse result);
    void validateFailure(String message);
}
