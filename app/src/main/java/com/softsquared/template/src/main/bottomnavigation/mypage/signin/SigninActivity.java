package com.softsquared.template.src.main.bottomnavigation.mypage.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.softsquared.template.R;

import com.softsquared.template.src.ApplicationClass;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.HomeActivity;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signinmodels.SigninRequest;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.SignupActivity;
import com.softsquared.template.src.main.bottomnavigation.mypage.signin.signininterfaces.SigninActivityView;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SigninActivity extends BaseActivity implements SigninActivityView{

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewEmailError;

    private String userType;
    private String userId;
    private String userPasswd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Button buttonSignup = findViewById(R.id.button_signup);
        Button buttonReuqestSign = findViewById(R.id.button_ReuqestSign);
        editTextEmail = findViewById(R.id.editText_email);
        editTextPassword = findViewById(R.id.editText_password);


        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

        buttonReuqestSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 userId = editTextEmail.getText().toString();
                 userPasswd = editTextPassword.getText().toString();

                RequestSignin();

            }
        });
    }


    private void RequestSignin() {

        final SigninService signinService = new SigninService( this);
        SigninRequest RequestUserData = new SigninRequest("NORMAL",userId,userPasswd);
        signinService.GetSignin(RequestUserData);

    }


    @Override
    public void validateSuccess(String userName) {

        ApplicationClass.setLoginSuccess(true);
        ApplicationClass.setLoginUser(userName);
        Toast.makeText(getApplicationContext(), userName+"님 안녕하세요!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void validateFailure(String message) {

    }
}