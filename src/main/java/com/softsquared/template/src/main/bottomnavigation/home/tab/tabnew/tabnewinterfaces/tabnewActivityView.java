package com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewinterfaces;

import com.softsquared.template.src.main.bottomnavigation.home.tab.tabnew.tabnewmodels.tabnewDefaultResponse;

public interface tabnewActivityView {

    void validateSuccess(tabnewDefaultResponse result);
    void validateFailure(String message);
}
