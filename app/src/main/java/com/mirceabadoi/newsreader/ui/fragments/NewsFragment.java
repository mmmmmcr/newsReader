package com.mirceabadoi.newsreader.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mirceabadoi.newsreader.ClicksHandler;
import com.mirceabadoi.newsreader.databinding.NewsListFragmentBinding;
import com.mirceabadoi.newsreader.models.NewsListViewModel;
import com.mirceabadoi.newsreader.models.ViewModelFactory;

public class NewsFragment extends Fragment {

    private NewsListViewModel mViewModel;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication())).get(NewsListViewModel.class);
        getLifecycle().addObserver(mViewModel);
        mViewModel.setHandler(() -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newsapi.org/"));
            startActivity(browserIntent);
        });
    }

}