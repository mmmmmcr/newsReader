package com.mirceabadoi.newsreader.mapper;

import com.example.data.model.Article;
import com.mirceabadoi.newsreader.models.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToArticleViewModelMapper implements Function<List<Article>, List<ArticleItemViewModel>> {
    @Override
    public List<ArticleItemViewModel> apply(@NotNull List<Article> articles) throws Exception {
        List<ArticleItemViewModel> articleItemViewModels = new ArrayList<>();
        for(Article a : articles){
            articleItemViewModels.add(new ArticleItemViewModel(a.date, a.title, a.description, a.imageUrl));
        }
        return articleItemViewModels;
    }
}
