package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionsniperinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.OptionDefaultResponse;

public interface OptionActivityView {

    void validateSuccess(OptionDefaultResponse result);
    void validateFailure(String message);
}
