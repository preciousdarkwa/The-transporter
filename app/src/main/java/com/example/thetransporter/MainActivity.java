package com.example.thetransporter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText emailId,password;
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
        tvsignin = findViewById(R.id.textView2);
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
            else if(!email.isEmpty() && pwd.isEmpty()){
                mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Sign Up unsuccessful! Please Try Again",Toast.LENGTH_SHORT).show();

                        }
                        else{
                            startActivity(new Intent(MainActivity.this, HomeActivity2.class));
                        }
                    }
                });
            }
            else {
                Toast.makeText(MainActivity.this, "Error occured!", Toast.LENGTH_SHORT).show();

            }
            });
            tvsignin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, LoginActivity2.class);
                    startActivity(i);
                }
            });
        };
    }
