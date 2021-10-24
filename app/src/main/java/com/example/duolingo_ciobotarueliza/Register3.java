package com.example.duolingo_ciobotarueliza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register3 extends AppCompatActivity {

    private Button btnRegister4;
    private EditText etEmail;

//    TextView receiver_msg;
//    TextView receiver_msg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);


        btnRegister4= (Button) findViewById(R.id.btnInainte3);
        etEmail = findViewById(R.id.etEmail);
        btnRegister4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isValid()){

              //  receiver_msg = (TextView)findViewById(R.id.received2);
                Intent intent = getIntent();
                String str = intent.getStringExtra("message_key");
                String str2 = intent.getStringExtra("message_key2");
             //   receiver_msg.setText(str);

                String str3 = etEmail.getText().toString();


                openRegister4(str,str2,str3);
            }
            }
        });
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid() {
        if(!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(Register3.this, "Email is invalid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public void openRegister4(String str, String str2, String str3) {
        Intent intent = new Intent( this, Register4.class);
        intent.putExtra("message_key", str);
        intent.putExtra("message_key2", str2);
        intent.putExtra("message_key3", str3);

        startActivity(intent);
    }

}