package com.example.data.dtos;

public class ArticleDto {

    public final SourceDto source;
    public final String date;
    public final String urlToImage;
    public final String url;
    public final String content;
    public final String description;
    public final String title;
    public final String author;

    public ArticleDto(SourceDto source, String urlToImage, String url, String content, String description, String title, String author, String date) {
        this.source = source;
        this.urlToImage = urlToImage;
        this.url = url;
        this.content = content;
        this.description = description;
        this.title = title;
        this.author = author;
        this.date = date;
    }
}
