package com.example.thetransporter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText emailId,password;
    Button btnSignup;
    TextView tvsignin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);
        btnSignup = findViewById(R.id.button2);
        tvsignin = findViewById(R.id.textView2);
        btnSignup.setOnClickListener(this::onClick);
          tvsignin.setOnClickListener(view -> {
              Intent i = new Intent(MainActivity.this, LoginActivity2.class);
              startActivity(i);
          });

        }

    private void onClick(View view) {

        String email= emailId.getText().toString();
        String pwd = password.getText().toString();
        if (email.isEmpty()) {
            emailId.setError("Please enter email id");
            emailId.requestFocus();
        } else if (pwd.isEmpty()) {
            password.setError("Please enter password");
            password.requestFocus();
        } else if (email.isEmpty() && pwd.isEmpty()) {
            Toast.makeText(MainActivity.this, "Fields are empty!", Toast.LENGTH_SHORT).show();

        } else if (!email.isEmpty() || !pwd.isEmpty()) {
            mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Signup unsuccessful, Please try again!", Toast.LENGTH_SHORT).show();

                    } else {
                        startActivity(new Intent(MainActivity.this, HomeActivity2.class));
                    }
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "Error occurred!", Toast.LENGTH_SHORT).show();

        }

    }
}

