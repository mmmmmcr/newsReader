package com.mirceabadoi.newsreader.mapper;

import com.example.data.model.NewsArticle;
import com.mirceabadoi.newsreader.models.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToArticleViewModelMapper implements Function<List<NewsArticle>, List<ArticleItemViewModel>> {
    @Override
    public List<ArticleItemViewModel> apply(@NotNull List<NewsArticle> articles) throws Exception {
        List<ArticleItemViewModel> articleItemViewModels = new ArrayList<>();
        for (NewsArticle a : articles) {
            articleItemViewModels.add(new ArticleItemViewModel(a.date, a.title, a.description, a.imageUrl));
        }
        return articleItemViewModels;
    }
}
