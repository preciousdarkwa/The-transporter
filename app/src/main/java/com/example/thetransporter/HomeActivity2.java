package com.example.thetransporter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity2 extends AppCompatActivity {
    Button btnLogout;

    public HomeActivity2() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        btnLogout =findViewById(R.id.logout);
        btnLogout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intToMain = new Intent(HomeActivity2.this, MainActivity.class);
            startActivity(intToMain);
        });
    }
}