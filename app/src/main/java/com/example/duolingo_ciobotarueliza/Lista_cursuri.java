package com.example.duolingo_ciobotarueliza;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lista_cursuri extends AppCompatActivity {

    private ListView lista_cursuri;
    private MeniuAdapter meniuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cursuri);

        lista_cursuri = findViewById(R.id.listaCursuri);

        meniuAdapter = new MeniuAdapter(getCursuri());

        lista_cursuri.setAdapter(meniuAdapter);

        //https://jsonkeeper.com/b/AKRX

        JSONReader reader = new JSONReader();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reader.read("https://jsonkeeper.com/b/AKRX\n", new IResponse() {
                    @Override
                    public void onSucces(List<Curs> cursuri) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                Toast.makeText(Lista_cursuri.this, cursuri.toString(), Toast.LENGTH_SHORT).show();
                                meniuAdapter.update_list(cursuri);
                                Toast.makeText(Lista_cursuri.this, cursuri.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onError(String mesaj) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Lista_cursuri.this, mesaj, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
        thread.start();


//        lista_cursuri.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//              //   meniuAdapter.getItem(position);
//                Toast.makeText(Lista_cursuri.this,  meniuAdapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
//
//                return false;
//            }
//        });
    }


    private List<Curs> getCursuri(){
        List<Curs> lst = new ArrayList<>();
        lst.add(new Curs("Engleza", "avansat", 120));
        lst.add(new Curs("Germana", "intermediar", 100));
        lst.add(new Curs("Spaniola", "incepator", 110));
        lst.add(new Curs("Japoneza", "intermediar", 120));
        lst.add(new Curs("Italiana", "intermediar", 150));
        lst.add(new Curs("Franceza", "incepator", 110));
        lst.add(new Curs("Japoneza", "intermediar", 120));
        lst.add(new Curs("Italiana", "intermediar", 150));
        lst.add(new Curs("Franceza", "incepator", 110));
        return lst;
    }

//    private List<Curs> getCursuri2(){
//        List<Curs> lst = new ArrayList<>();
//        lst.add(new Curs("Japoneza", "intermediar", 120));
//        lst.add(new Curs("Italiana", "intermediar", 150));
//        lst.add(new Curs("Franceza", "incepator", 110));
//        return lst;
//    }
}