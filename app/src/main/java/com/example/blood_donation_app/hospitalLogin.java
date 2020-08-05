package com.example.blood_donation_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class hospitalLogin extends AppCompatActivity {
    private EditText email, password;
    private Button signInButton;
    private TextView signupTxt;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);
        firebaseAuth = firebaseAuth.getInstance();
        email = findViewById(R.id.hospitalEmailLogin);
        password = findViewById(R.id.hospitalPasswordLogin);
        signupTxt = findViewById(R.id.hospitalSignupTxt);
        signInButton = findViewById(R.id.hospitalLoginButton);
        progressDialog= new ProgressDialog(this);

//        signup button
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });


//        text view for already have an account?
        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(hospitalLogin.this, hospitalSignup.class);
                startActivity(intent);
                finish();

            }
        });


    }
    //    login button
    private void Login(){
        String theEmail = email.getText().toString();
        String thePassword1 = password.getText().toString();



        if(TextUtils.isEmpty(theEmail)){
            email.setError("Your email is needed");
            return;
        }

        else if(TextUtils.isEmpty(thePassword1)){
            password.setError("Your password is needed");
            return;
        }

        else if(!isValidEmail(theEmail)){
            email.setError("Invalid email");
            return;
        }
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseAuth.signInWithEmailAndPassword(theEmail, thePassword1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(hospitalLogin.this, "You've been signed in!", Toast.LENGTH_LONG).show();
                    Intent intent  = new Intent(hospitalLogin.this, hospitalDashboard.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    Toast.makeText(hospitalLogin.this, "Sign In failed!", Toast.LENGTH_LONG).show();

                }

                progressDialog.dismiss();
            }
        });

    };

    private Boolean isValidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());



    };
}