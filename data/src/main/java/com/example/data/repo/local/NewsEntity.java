package com.example.data.repo.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class NewsEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public int priority;

    public String title;

    public String image;

    public String newsDescription;

    public String newsDate;

}