package com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.RecommendDefaultResponse;
import com.softsquared.template.src.main.bottomnavigation.home.tab.today.recommend.recommendsmodels.datapojo.Result;

public interface RecommendActivityView {

    void validateSuccess(RecommendDefaultResponse result);
    void validateFailure(String message);
}
