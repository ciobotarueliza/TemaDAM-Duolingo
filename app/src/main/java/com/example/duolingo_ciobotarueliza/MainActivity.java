package com.example.duolingo_ciobotarueliza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MaterialButton btn = (MaterialButton) findViewById(R.id.btn);

        Log.v("lifecycle", "onCreate");

        btnLogin= (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

    }

    public void openRegister() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent)
;    }
}