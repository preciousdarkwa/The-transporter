package com.example.thetransporter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity2 extends AppCompatActivity {
    EditText emailId,password;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);
        btnSignIn = findViewById(R.id.button2);
        tvSignUp = findViewById(R.id.textView2);

        mAuthStateListener = firebaseAuth -> {
            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            if( mFirebaseUser != null) {
                Toast.makeText(LoginActivity2.this, "You are logged in", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(LoginActivity2.this, HomeActivity2.class);
                startActivity(i);
            }
            else {
                Toast.makeText(LoginActivity2.this, "Please Login", Toast.LENGTH_SHORT).show();

            }
        };
        btnSignIn.setOnClickListener(view -> {

            String email = emailId.getText() .toString();
            String pwd = password.getText().toString();
            if(email.isEmpty()){
                emailId.setError("Please enter Email id");
                emailId.requestFocus();
            }
            else if(pwd.isEmpty()){
                password.setError("Please enter your password");
                password.requestFocus();
            }
            else {
                Toast.makeText(LoginActivity2.this, "Error occurred!", Toast.LENGTH_SHORT).show();

            }
        });

        tvSignUp.setOnClickListener(view -> {
            Intent intSignUp = new Intent(LoginActivity2.this, MainActivity.class);
            startActivity(intSignUp);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}