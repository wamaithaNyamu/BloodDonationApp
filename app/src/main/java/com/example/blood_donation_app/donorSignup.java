package com.example.blood_donation_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class donorSignup extends AppCompatActivity {
    private EditText email, password1, password2;
    private Button signupButton;
    private TextView signIn;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_signup);
        firebaseAuth = firebaseAuth.getInstance();
        email = findViewById(R.id.donorEmailSignup);
        password1 = findViewById(R.id.donorPasswordSignup1);
        password2 = findViewById(R.id.donorPasswordSignup2);
        signupButton = findViewById(R.id.donorSignupButton);
        signIn = findViewById(R.id.donorSignintxt);
        progressDialog= new ProgressDialog(this);


//        signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });


//        text view for already have an account?
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(donorSignup.this, donorLogin.class);
                startActivity(intent);
//                finish();

            }
        });





    }
    private void Register(){
        String theEmail = email.getText().toString();
        String thePassword1 = password1.getText().toString();
        String thePassword2 = password2.getText().toString();


        if(TextUtils.isEmpty(theEmail)){
            email.setError("Your email is needed");
            return;
        }

        else if(TextUtils.isEmpty(thePassword1)){
            password1.setError("A password is needed");
            return;
        }
        else if(TextUtils.isEmpty(thePassword2)){
            password2.setError("confirm your password");
            return;
        }
        else if(!thePassword1.equals(thePassword2)){
            password2.setError("Passwords do not match");
            return;
        }
        else if(!isValidEmail(theEmail)){
            email.setError("Invalid email");
            return;
        }
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseAuth.createUserWithEmailAndPassword(theEmail, thePassword1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(donorSignup.this, "Your donor account has been created", Toast.LENGTH_LONG).show();
                    Intent intent  = new Intent(donorSignup.this, donor_signup_details.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    Toast.makeText(donorSignup.this, "Signup failed!", Toast.LENGTH_LONG).show();

                }
                progressDialog.dismiss();
            }



        });

    };

    private Boolean isValidEmail(CharSequence target){
      return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());



    };
}
