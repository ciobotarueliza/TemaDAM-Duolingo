package com.example.duolingo_ciobotarueliza;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={Person.class},version=1,exportSchema=false)
public abstract class DatabasePersoana extends RoomDatabase {

    public abstract PersoanaDAO persoanaDAO();
}
