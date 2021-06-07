package com.example.data.mapper;

import com.example.data.dtos.ArticleDto;
import com.example.data.dtos.ArticleListDto;
import com.example.data.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsDtoMapper implements Function<ArticleListDto, List<Article>>{

    @Override
    public List<Article> apply(ArticleListDto articleDtos){
        List<Article> articles=new ArrayList<>();

        for(ArticleDto dto:articleDtos.articles){
            Article article = new Article(
                    dto.date != null ? dto.date : "12.03.2021 8:54",
                    dto.urlToImage != null ? dto.urlToImage : "https://homepages.cae.wisc.edu/~ece533/images/fruits.png",
                    dto.title != null ? dto.title : "placeholder",
                    dto.content != null ? dto.content : "placeholder",
                    dto.description != null ? dto.description : "placeholder"
            );

            articles.add(article);
        }

        return articles;
    }
}
