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
   // private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MaterialButton btn = (MaterialButton) findViewById(R.id.btn);

       // Log.v("lifecycle", "onCreate");

        btnLogin= (Button) findViewById(R.id.login);
        //text = findViewById(R.id.textView);
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
                Intent intent = new Intent(MainActivity.this, Register.class);
                //startActivity(intent);
                startActivityForResult(intent,MainActivityRequest);

              //  openRegister();
            }
        });

    }

    Persoana persoana;
    public void openLogin() {
        if(persoana != null){

            String str = persoana.getNume();
            String str2 = persoana.getParola();

            Intent intent = new Intent(this, Login.class);

            intent.putExtra("message_key", str);
            intent.putExtra("message_key2", str2);


            startActivity(intent);


        startActivity(intent);
        }
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openRegister() {
        Intent intent = new Intent(this, Register.class);
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
                    persoana = (Persoana) newBundle.getSerializable("persoana");
                    Intent intent3 = new Intent( this, Login.class);
                    startActivity(intent3);
                    //text.setText(persoana.toString());

                }
            }
        }


    }
}