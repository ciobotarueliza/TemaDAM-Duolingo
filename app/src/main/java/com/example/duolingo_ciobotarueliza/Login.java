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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buton = findViewById(R.id.signin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
//        username.setText("eliza");
//        password.setText("eliza");



//        Intent intent = new Intent();
//        startActivityForResult(intent,MainActivityRequest);



        Intent intent = getIntent();

        String str = intent.getStringExtra("message_key");
        String str2 = intent.getStringExtra("message_key2");


        username.setText(str);
        password.setText(str2);


        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Login.this, Register.class);
//                //startActivity(intent);
//                startActivityForResult(intent,MainActivityRequest);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MainActivityRequest) {
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle newBundle = data.getBundleExtra("raspunsBundle");
                    Persoana persoana = (Persoana) newBundle.getSerializable("persoana");
                   // text.setText(persoana.toString());
                      username.setText(persoana.getEmail());
                      password.setText(persoana.getParola());
                }
            }
        }


    }
}