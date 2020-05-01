package com.softsquared.template.src.main.bottomnavigation.mypage.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.softsquared.template.R;

import com.softsquared.template.src.main.bottomnavigation.mypage.signin.SigninActivity;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupinterfaces.SignupActivityView;
import com.softsquared.template.src.main.bottomnavigation.mypage.signup.emailsignupmodels.SignupRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity implements SignupActivityView {

    private Button buttonReuqestSignup;
    private EditText Editemail;
    private EditText Editpassword;
    private EditText Editname;
    private EditText Editphone;
    private CheckBox CheckService;
    private CheckBox CheckPrivate;

    private String email;
    private String password;
    private String name;
    private String phone;
    private String dateOfBirth;
    private String AgreeOnService;
    private String AgreeOnPrivate;

    private boolean intentSingupcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailsignup);

        buttonReuqestSignup = findViewById(R.id.button_requestsignup);
        Editemail = findViewById(R.id.editText_email);
        Editpassword = findViewById(R.id.editText_password);
        Editname = findViewById(R.id.editText_name);
        Editphone = findViewById(R.id.editText_phonenum);
        CheckService = findViewById(R.id.check_service);
        CheckPrivate = findViewById(R.id.check_private);

        buttonReuqestSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = Editemail.getText().toString();
                password = Editpassword.getText().toString();
                name = Editname.getText().toString();
                phone = Editphone.getText().toString();
                //dateOfBirth = Editpassword.getText().toString();
                if(CheckService.isChecked()){
                    AgreeOnService = "Y";
                }
               if(CheckPrivate.isChecked()){
                   AgreeOnPrivate = "Y";
               }

                RequestSignup();
/*
                if(intentSingupcheck){
                    Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                    startActivity(intent);
                }
                else{

                }*/
            }
        });

    }

    private void RequestSignup() {

        final SignupService signupService = new SignupService( this);
        SignupRequest RequestUserData = new SignupRequest("NORMAL",email,"12345678","jinyeol","01012341234","19990101","Y","Y");
        //SignupRequest RequestUserData = new SignupRequest("NORMAL",email,password,name,phone,AgreeOnService,AgreeOnPrivate);
        signupService.GetSignUp(RequestUserData);

    }

    @Override
    public void validateSuccess(boolean signUpCheck) {
        Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
        startActivity(intent);

    }

    @Override
    public void validateFailure(String message) {

    }
}
