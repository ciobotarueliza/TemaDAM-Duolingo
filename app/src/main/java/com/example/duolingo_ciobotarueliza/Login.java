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

    private Button btnLista;
    private EditText username;
    private EditText password;

    //TextView receiver_msg;
    //TextView receiver_msg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        //receiver_msg = (TextView)findViewById(R.id.username);
        //receiver_msg2 = (TextView)findViewById(R.id.password);

        Intent intent1 = getIntent();
        String str = intent1.getStringExtra("message_key");
        String str2 = intent1.getStringExtra("message_key2");

//        receiver_msg.setText(str);
//        receiver_msg2.setText(str2);

        username.setText(str);
        password.setText(str2);

        btnLista = (Button) findViewById(R.id.signin);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLista();
            }
        });

    }

    public void openLista() {
        Intent intent = new Intent(Login.this,Lista_cursuri.class);
        startActivity(intent);
    }


}