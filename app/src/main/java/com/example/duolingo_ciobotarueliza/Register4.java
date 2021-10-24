package com.example.duolingo_ciobotarueliza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register4 extends AppCompatActivity {

    private Button btnSalvare;
    private EditText etParola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4);

        btnSalvare= (Button) findViewById(R.id.btnProfil);
        etParola = findViewById(R.id.etParola);
        btnSalvare.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isValid()){

                    Intent intent = getIntent();
                    String str = intent.getStringExtra("message_key");
                    String str2 = intent.getStringExtra("message_key2");
                    String str3 = intent.getStringExtra("message_key3");

                    String str4 = etParola.getText().toString();

                    Persoana p1 = new Persoana();
                    p1.setVarsta(str);
                    p1.setNume(str2);
                    p1.setEmail(str3);
                    p1.setParola(str4);



                    //Toast.makeText(Register4.this, p1.toString(), Toast.LENGTH_SHORT).show();

//                    Intent intent3 = new Intent(Register4.this, Login.class);
//                    startActivity(intent3);

                    Bundle wrapperObject = new Bundle();
                    wrapperObject.putSerializable("persoana", p1);

                    Intent intent2 = new Intent(Register4.this, Login.class);
                    intent2.putExtra("raspunsBundle", wrapperObject);
                    setResult(RESULT_OK, intent2);
                    finish();
                    startActivity(intent2); //am adaugat sa ma duca in login



                    //nu merge nu inteleg de ce ma intoarce in Register3 cand apas pe buton


                }
            }
        });
    }

    private boolean isValid() {
        if (etParola.getText().toString().isEmpty()) {
            Toast.makeText(Register4.this, "Completati parola", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}