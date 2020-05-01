package com.softsquared.template.src.main.bottomnavigation.mypage.signin.signininterfaces;

public interface SigninActivityView {

    void validateSuccess(boolean loginCheck);
    void validateFailure(String message);
}
