package com.example.duolingo_ciobotarueliza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button btnRegister2;
    private EditText etVarsta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister2= (Button) findViewById(R.id.btnInainte1);
        etVarsta = findViewById(R.id.etVarsta);

        btnRegister2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isValid()){

                    String str = etVarsta.getText().toString();

                    openRegister2(str);
            }

            }
        });

    }

    private boolean isValid() {
        if (etVarsta.getText().toString().isEmpty()) {
            Toast.makeText(Register.this, "Completati varsta", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

        public void openRegister2(String str) {
        Intent intent = new Intent( this, Register2.class);
        intent.putExtra("message_key", str);
        startActivity(intent);
    }
}