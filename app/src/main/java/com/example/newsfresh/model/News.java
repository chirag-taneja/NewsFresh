package com.example.newsfresh.model;

public class News {
    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", image_url='" + image_url + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    private  String title;

    public News(String title, String author, String image_url, String url) {
        this.title = title;
        this.author = author;
        this.image_url = image_url;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private  String author;
    private  String image_url;
    private  String url;
}
