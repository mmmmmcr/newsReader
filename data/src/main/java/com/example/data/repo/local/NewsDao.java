package com.example.data.repo.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    Single<List<NewsEntity>> queryNews();

    @Query("SELECT * FROM news where id= :id")
    Single<NewsEntity> queryNewsItem(int id);

    @Query("DELETE FROM news")
    Completable deleteAllNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<NewsEntity> news);

}
