package com.example.data.model;

import io.reactivex.annotations.NonNull;

public class NewsArticle {
    @NonNull
    public final String date;
    @NonNull
    public final String imageUrl;
    @NonNull
    public final String title;
    @NonNull
    public final String content;
    @NonNull
    public final String description;

    public NewsArticle(@NonNull String date, @NonNull String imageUrl, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.date = date;
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }
}
