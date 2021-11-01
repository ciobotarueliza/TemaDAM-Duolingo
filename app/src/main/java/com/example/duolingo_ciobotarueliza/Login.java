package com.example.duolingo_ciobotarueliza;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button buton;
    private final int MainActivityRequest = 100;
    private EditText username;
    private EditText password;

    //TextView receiver_msg;
    //TextView receiver_msg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buton = findViewById(R.id.signin);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        //receiver_msg = (TextView)findViewById(R.id.username);
        //receiver_msg2 = (TextView)findViewById(R.id.password);

        Intent intent = getIntent();

        String str = intent.getStringExtra("message_key");
        String str2 = intent.getStringExtra("message_key2");


//        receiver_msg.setText(str);
//        receiver_msg2.setText(str2);

        username.setText(str);
        password.setText(str2);


        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Lista_cursuri.class);
                startActivity(intent);

            }

        });
    }


}