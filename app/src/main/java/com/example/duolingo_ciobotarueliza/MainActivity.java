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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister;
    private Button btnLogin;
    private final int MainActivityRequest = 100;

    private TextView username;
    private TextView password;

    private PersoanaDAO persoanaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //parte baza de date

        persoanaDAO= Database.getInstance(this).getDatabase().persoanaDAO();
        List<Person> lista=getPersons();
        //studentDAO.insert(lista.get(0),lista.get(1));
        for(int i=0;i<lista.size();i++){

            persoanaDAO.insertAll(lista.get(i));
        }
        List<Person> lista18=persoanaDAO.getPersoanaVarstaMaiMareDe(18);
        Log.v("majori",lista18.toString());
        ///pana aici bd


        //firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("persoana");
        DatabaseReference myRef2 = database.getReference("test");

        myRef2.setValue("persoanaTest");
        myRef.child("nume").setValue("eliza");
        myRef.child("email").setValue("eliza@gmail.com");
        myRef.child("parola").setValue("parola123");
        myRef.child("varsta").setValue(21);

        // Read from the database TEST afiseaza
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("read", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("fail", "Failed to read value.", error.toException());
            }
        });


//        List<Persoana> list= new ArrayList <>();
//
////         Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
////                String value = dataSnapshot.getValue(String.class);
////                Log.d("read", "Value is: " + value);
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    Persoana pers = postSnapshot.getValue(Persoana.class);
//                    list.add(pers);
//                }
//                for (int i=0;i<list.size();i++)
//                {
//                    Log.d("Name",list.get(i).getNume());
//                    Log.d("Email",list.get(i).getEmail());
//
//                }
//            }
//            @Override
//
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("cancelled", "Failed to read value.", error.toException());
//            }
//        });
        //pana aici firebase


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


    public List<Person> getPersons(){
        Person persoana1 = new Person( "Eliza", "aaa", "eliza@gmail.com", 21);


        List<Person> lista=new ArrayList<>();
        lista.add(persoana1);

        return lista;

    }
}