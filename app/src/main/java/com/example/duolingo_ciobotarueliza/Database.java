package com.example.duolingo_ciobotarueliza;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

import java.util.List;

public class Database {

    private static Database database;
    private DatabasePersoana databasePersoana;

    private Database(Context context){
        databasePersoana = Room.databaseBuilder(context,
                DatabasePersoana.class, "person-database").allowMainThreadQueries().build();

        //trebuie cu altceva in loc de .allowMainThreadQueries().build()

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                databasePersoana = Room.databaseBuilder(context,
//                        DatabasePersoana.class, "person-database").build();
//
//                }
//        });
//        thread.start();

    }

    public static Database getInstance(Context context){
        if(database==null){
            database=new Database(context);

        }

        return database;
    }

    public DatabasePersoana getDatabase(){
        return databasePersoana;
    }
}
