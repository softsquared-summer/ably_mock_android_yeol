package com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupmodels;

public class SignupRequest {

    private String userType;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String dateOfBirth;
    private String AgreeOnService;
    private String AgreeOnPrivate;

    public SignupRequest(String userType, String email, String password, String name, String phone, String dateOfBirth, String agreeOnService, String agreeOnPrivate) {
        this.userType = userType;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        AgreeOnService = agreeOnService;
        AgreeOnPrivate = agreeOnPrivate;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAgreeOnService() {
        return AgreeOnService;
    }

    public void setAgreeOnService(String agreeOnService) {
        AgreeOnService = agreeOnService;
    }

    public String getAgreeOnPrivate() {
        return AgreeOnPrivate;
    }

    public void setAgreeOnPrivate(String agreeOnPrivate) {
        AgreeOnPrivate = agreeOnPrivate;
    }
}
