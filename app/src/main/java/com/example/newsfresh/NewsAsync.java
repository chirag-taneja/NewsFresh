package com.example.newsfresh;

import com.example.newsfresh.model.News;

import java.util.ArrayList;

public interface NewsAsync {
    public void process_finished (ArrayList<News> newsArrayList);
}
