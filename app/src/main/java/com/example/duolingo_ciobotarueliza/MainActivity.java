package com.example.duolingo_ciobotarueliza;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister;
    private Button btnLogin;
    private final int MainActivityRequest = 100;

    private TextView username;
    private TextView password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogin= (Button) findViewById(R.id.login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });


        btnRegister= (Button) findViewById(R.id.register);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterFinal.class);
                //startActivity(intent);
                startActivityForResult(intent,MainActivityRequest);

              //  openRegister();
            }
        });

    }

    public void openLogin() {

        String str = username.getText().toString();
        String str2 = password.getText().toString();

        Intent intent = new Intent(MainActivity.this, Login.class);

        intent.putExtra("message_key", str);
        intent.putExtra("message_key2", str2);

        startActivity(intent);

    }

    public void openRegister() {
        Intent intent = new Intent(this, RegisterFinal.class);
        startActivityForResult(intent,MainActivityRequest);
        //startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MainActivityRequest) {
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle newBundle = data.getBundleExtra("raspunsBundle");
                    Persoana persoana = (Persoana) newBundle.getSerializable("persoana");
                    username.setText(persoana.getEmail());
                    password.setText(persoana.getParola());

                }
            }
        }

    }
}