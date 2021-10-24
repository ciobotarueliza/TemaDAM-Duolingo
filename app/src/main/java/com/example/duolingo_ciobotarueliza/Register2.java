package com.example.duolingo_ciobotarueliza;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register2 extends AppCompatActivity {

    private Button btnRegister3;
    private EditText etNume;

    TextView receiver_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        btnRegister3= (Button) findViewById(R.id.btnInainte2);
        etNume = findViewById(R.id.etNume);
        btnRegister3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isValid()){

                receiver_msg = (TextView)findViewById(R.id.received2);
                Intent intent = getIntent();
                String str = intent.getStringExtra("message_key");
                receiver_msg.setText(str);

                String str2 = etNume.getText().toString();
                openRegister3(receiver_msg.toString(), str2);

                }
            }
        });
    }


    private boolean isValid() {
        if (etNume.getText().toString().isEmpty()) {
            Toast.makeText(Register2.this, "Completati numele", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void openRegister3(String str, String str2) {
        Intent intent = new Intent( this, Register3.class);
        intent.putExtra("message_key", str);
        intent.putExtra("message_key2", str2);
        startActivity(intent);
    }
}