package com.vozisov.wordpress.model.comments;

import java.util.List;

public class Comments {
    private String author_name;
    private String date;
    private int parent;
    private Links links;
    private int author;
    private String link;
    private String type;
    private Content content;
    private String authorUrl;
    private int post;
    private AuthorAvatarUrls authorAvatarUrls;
    private List<Object> meta;
    private int id;
    private String dateGmt;
    private String status;

    public void setAuthorName(String authorName) {
        this.author_name = author_name;
    }

    public String getAuthorName() {
        return author_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getParent() {
        return parent;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getAuthor() {
        return author;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getPost() {
        return post;
    }

    public void setAuthorAvatarUrls(AuthorAvatarUrls authorAvatarUrls) {
        this.authorAvatarUrls = authorAvatarUrls;
    }

    public AuthorAvatarUrls getAuthorAvatarUrls() {
        return authorAvatarUrls;
    }

    public void setMeta(List<Object> meta) {
        this.meta = meta;
    }

    public List<Object> getMeta() {
        return meta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDateGmt(String dateGmt) {
        this.dateGmt = dateGmt;
    }

    public String getDateGmt() {
        return dateGmt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "Comments{" +
                        "author_name = '" + author_name + '\'' +
                        ",date = '" + date + '\'' +
                        ",parent = '" + parent + '\'' +
                        ",_links = '" + links + '\'' +
                        ",author = '" + author + '\'' +
                        ",link = '" + link + '\'' +
                        ",type = '" + type + '\'' +
                        ",content = '" + content + '\'' +
                        ",author_url = '" + authorUrl + '\'' +
                        ",post = '" + post + '\'' +
                        ",author_avatar_urls = '" + authorAvatarUrls + '\'' +
                        ",meta = '" + meta + '\'' +
                        ",id = '" + id + '\'' +
                        ",date_gmt = '" + dateGmt + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}