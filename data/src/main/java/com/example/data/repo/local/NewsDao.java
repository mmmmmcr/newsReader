package com.example.data.repo.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    Single<List<NewsEntity>> queryNews();

    @Query("SELECT * FROM news where id= :id")
    Single<NewsEntity> queryNewsItem(int id);

    @Query("DELETE FROM news where id=:id")
    Completable deleteNewsItem(int id);

    @Query("DELETE FROM news")
    Completable deleteAllToDos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertToDos(List<NewsEntity> news);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertToDo(NewsEntity news);

    @Query("UPDATE news SET title = :title, newsDescription = :description, newsDate = :date, image = :image, priority = :priority where id=:id")
    Completable updateProfile(String title, String description, String date, String image, int priority, int id);

}
