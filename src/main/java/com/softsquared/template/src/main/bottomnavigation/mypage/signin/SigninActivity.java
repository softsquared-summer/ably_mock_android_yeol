package com.softsquared.template.src.main.bottomnavigation.mypage.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    private boolean intentLogincheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Button buttonSignup = findViewById(R.id.button_signup);
        Button buttonReuqestSign = findViewById(R.id.button_ReuqestSign);
        editTextEmail = findViewById(R.id.editText_email);
        editTextPassword = findViewById(R.id.editText_password);
        textViewEmailError = findViewById(R.id.textView_emailerror);


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

                if(intentLogincheck){
                    ApplicationClass.setLoginSuccess(true);
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
                else{

                }
            }
        });

        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    Pattern p = Pattern.compile("^[a-zA-X0-9]@[a-zA-Z0-9].[a-zA-Z0-9]");
                    Matcher m = p.matcher(editTextEmail.getText());

                    if (!m.matches()){
                        textViewEmailError.setVisibility(View.GONE);
                    }else{
                        textViewEmailError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        RequestSignin();

    }


    private void RequestSignin() {

        final SigninService signinService = new SigninService( this);
        SigninRequest RequestUserData = new SigninRequest("NORMAL",userId,userPasswd);
        signinService.GetSignin(RequestUserData);

    }


    @Override
    public void validateSuccess(boolean loginCheck) {

        intentLogincheck = loginCheck;

    }

    @Override
    public void validateFailure(String message) {

    }
}