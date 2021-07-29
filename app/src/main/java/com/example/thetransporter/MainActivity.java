package com.example.thetransporter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public EditText emailId,password;
    Button btnsignup;
    TextView tvsignin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);
        btnsignup = findViewById(R.id.button2);
        btnsignup.setOnClickListener(view -> {
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
            else if(email.isEmpty() && pwd.isEmpty()){
                Toast.makeText(MainActivity.this, "Fields are empty!",Toast.LENGTH_SHORT).show();
            }
            });
        };
    }
