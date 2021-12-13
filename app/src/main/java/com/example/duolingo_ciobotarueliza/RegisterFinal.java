package com.example.duolingo_ciobotarueliza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterFinal extends AppCompatActivity {

    private Button btnRegister2;
    private EditText etVarsta;
    private EditText etNume;
    private EditText etEmail;
    private EditText etParola;
    private TextView intrebareVarsta;
    private TextView intrebareNume;
    private TextView intrebareEmail;
    private TextView intrebareParola;


    int clickcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_final);



        btnRegister2= (Button) findViewById(R.id.btnInainte1);
        etVarsta = findViewById(R.id.etVarsta);
        etNume = findViewById(R.id.etNume);
        etEmail = findViewById(R.id.etEmail);
        etParola = findViewById(R.id.etParola);
        intrebareVarsta = findViewById(R.id.intrebareVarsta);
        intrebareNume = findViewById(R.id.intrebareNume);
        intrebareEmail = findViewById(R.id.intrebareEmail);
        intrebareParola = findViewById(R.id.intrebareParola);



        btnRegister2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                clickcount = clickcount + 1;

                if (clickcount == 1) {
                    if (isValidVarsta()) {

                        intrebareVarsta.setVisibility(View.INVISIBLE);
                        intrebareNume.setVisibility(View.VISIBLE);

                        etVarsta.setVisibility(View.INVISIBLE);
                        etNume.setVisibility(View.VISIBLE);
                    }else{
                        clickcount = clickcount - 1;  //ca inca nu e valid si sa nu treaca la urmatorul
                    }
                }

                if (clickcount == 2) {
                    if (isValidNume()) {

                        intrebareNume.setVisibility(View.INVISIBLE);
                        intrebareEmail.setVisibility(View.VISIBLE);

                        etNume.setVisibility(View.INVISIBLE);
                        etEmail.setVisibility(View.VISIBLE);
                    }else{
                        clickcount = clickcount - 1;  //ca inca nu e valid si sa nu treaca la urmatorul
                    }

                }

                if (clickcount == 3) {
                    if (isValidEmail()) {

                        intrebareEmail.setVisibility(View.INVISIBLE);
                        intrebareParola.setVisibility(View.VISIBLE);

                        etEmail.setVisibility(View.INVISIBLE);
                        etParola.setVisibility(View.VISIBLE);
                    }else{
                        clickcount = clickcount - 1;  //ca inca nu e valid si sa nu treaca la urmatorul
                    }

                }
                if (clickcount ==4){
                    Persoana p1 = new Persoana();
                    p1.setVarsta(etVarsta.getText().toString());
                    p1.setNume(etNume.getText().toString());
                    p1.setEmail(etEmail.getText().toString());
                    p1.setParola(etParola.getText().toString());

                   // Toast.makeText(RegisterFinal.this, p1.toString(), Toast.LENGTH_SHORT).show();  //doar de test

                    Bundle wrapperObject = new Bundle();
                    wrapperObject.putSerializable("persoana", p1);
                    Intent intent = new Intent();
                    intent.putExtra("raspunsBundle", wrapperObject);
                    setResult(RESULT_OK, intent);
                    finish();

                }

            }
        });


    }

    private boolean isValidVarsta() {
        if (etVarsta.getText().toString().isEmpty()) {
            Toast.makeText(RegisterFinal.this, "Completati varsta", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isValidNume() {
        if (etNume.getText().toString().isEmpty()) {
            Toast.makeText(RegisterFinal.this, "Completati numele", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidEmail() {
        if(!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(RegisterFinal.this, "Email is invalid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isValidParola() {
        if (etParola.getText().toString().isEmpty()) {
            Toast.makeText(RegisterFinal.this, "Completati parola", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void openMain() {
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }

}