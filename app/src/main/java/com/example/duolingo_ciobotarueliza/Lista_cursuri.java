package com.example.duolingo_ciobotarueliza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista_cursuri extends AppCompatActivity {

    private ListView lista_cursuri;
    private MeniuAdapter meniuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cursuri);

        meniuAdapter = new MeniuAdapter(getCursuri());
        lista_cursuri = findViewById(R.id.lista_cursuri);
        lista_cursuri.setAdapter((ListAdapter) meniuAdapter);

        lista_cursuri.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                meniuAdapter.update_list(getCursuri());
            }
        });
    }


    private List<Curs> getCursuri(){
        List<Curs> lst = new ArrayList<>();
        lst.add(new Curs("Engleza", "avansat", 120));
        lst.add(new Curs("Germana", "intermediar", 100));
        lst.add(new Curs("Spaniola", "incepator", 110));
        return lst;
    }
}