package com.example.duolingo_ciobotarueliza;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersoanaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Person... person);

    @Delete
    void delete(Person person);

    @Query("SELECT * FROM person")
    public List<Person> getAll();

    @Query("SELECT * FROM person WHERE varsta> :varsta")
    List<Person> getPersoanaVarstaMaiMareDe(int varsta);

}