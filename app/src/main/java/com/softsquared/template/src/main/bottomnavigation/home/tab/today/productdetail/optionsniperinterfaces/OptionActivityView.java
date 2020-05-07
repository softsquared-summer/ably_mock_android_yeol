package com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionsniperinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.productdetail.optionmodels.OptionDefaultResponse;

public interface OptionActivityView {

    void validateSuccessOptionInformation(OptionDefaultResponse result);
    void validateFailureOptionInformation(String message);
}
