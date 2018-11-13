package com.vozisov.wordpress.model.media;

import java.util.List;

public class Links {
    private List<RepliesItem> replies;
    private List<AuthorItem> author;
    private List<AboutItem> about;
    private List<SelfItem> self;
    private List<CollectionItem> collection;

    public void setReplies(List<RepliesItem> replies) {
        this.replies = replies;
    }

    public List<RepliesItem> getReplies() {
        return replies;
    }

    public void setAuthor(List<AuthorItem> author) {
        this.author = author;
    }

    public List<AuthorItem> getAuthor() {
        return author;
    }

    public void setAbout(List<AboutItem> about) {
        this.about = about;
    }

    public List<AboutItem> getAbout() {
        return about;
    }

    public void setSelf(List<SelfItem> self) {
        this.self = self;
    }

    public List<SelfItem> getSelf() {
        return self;
    }

    public void setCollection(List<CollectionItem> collection) {
        this.collection = collection;
    }

    public List<CollectionItem> getCollection() {
        return collection;
    }

    @Override
    public String toString() {
        return
                "Links{" +
                        "replies = '" + replies + '\'' +
                        ",author = '" + author + '\'' +
                        ",about = '" + about + '\'' +
                        ",self = '" + self + '\'' +
                        ",collection = '" + collection + '\'' +
                        "}";
    }
}