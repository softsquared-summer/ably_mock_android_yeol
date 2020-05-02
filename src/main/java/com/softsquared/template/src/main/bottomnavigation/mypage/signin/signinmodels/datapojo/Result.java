package com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels.datapojo;

public class Result
{
    private String jwt;
    private String userIdx;
    private String userName;

    public String getJwt ()
    {
        return jwt;
    }
    public void setJwt (String jwt)
    {
        this.jwt = jwt;
    }
    public String getUserIdx ()
    {
        return userIdx;
    }
    public void setUserIdx (String userIdx)
    {
        this.userIdx = userIdx;
    }
    public String getUserName ()
    {
        return userName;
    }
    public void setUserName (String userName)
    {
        this.userName = userName;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [jwt = "+jwt+", userIdx = "+userIdx+", userName = "+userName+"]";
    }
}
