package com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestiteminterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.best.bestitemmodels.BestItemDefaultResponse;

public interface BestItemActivityView {

    void validateSuccess(BestItemDefaultResponse result);
    void validateFailure(String message);
}
