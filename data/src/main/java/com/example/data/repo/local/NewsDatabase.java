package com.example.data.repo.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NewsEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();

}
