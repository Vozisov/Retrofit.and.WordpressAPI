package com.vozisov.wordpress.model.pages;

import java.util.List;

public class Page {
    private String date;
    private String template;
    private int parent;
    private int menuOrder;
    private String modifiedGmt;
    private Links links;
    private int author;
    private String link;
    private String type;
    private Title title;
    private String commentStatus;
    private Content content;
    private int featuredMedia;
    private String pingStatus;
    private List<Object> meta;
    private Guid guid;
    private String modified;
    private int id;
    private Excerpt excerpt;
    private String dateGmt;
    private String slug;
    private String status;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getParent() {
        return parent;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setModifiedGmt(String modifiedGmt) {
        this.modifiedGmt = modifiedGmt;
    }

    public String getModifiedGmt() {
        return modifiedGmt;
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

    public void setTitle(Title title) {
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    public void setFeaturedMedia(int featuredMedia) {
        this.featuredMedia = featuredMedia;
    }

    public int getFeaturedMedia() {
        return featuredMedia;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setMeta(List<Object> meta) {
        this.meta = meta;
    }

    public List<Object> getMeta() {
        return meta;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModified() {
        return modified;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setExcerpt(Excerpt excerpt) {
        this.excerpt = excerpt;
    }

    public Excerpt getExcerpt() {
        return excerpt;
    }

    public void setDateGmt(String dateGmt) {
        this.dateGmt = dateGmt;
    }

    public String getDateGmt() {
        return dateGmt;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
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
                "Page{" +
                        "date = '" + date + '\'' +
                        ",template = '" + template + '\'' +
                        ",parent = '" + parent + '\'' +
                        ",menu_order = '" + menuOrder + '\'' +
                        ",modified_gmt = '" + modifiedGmt + '\'' +
                        ",_links = '" + links + '\'' +
                        ",author = '" + author + '\'' +
                        ",link = '" + link + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        ",comment_status = '" + commentStatus + '\'' +
                        ",content = '" + content + '\'' +
                        ",featured_media = '" + featuredMedia + '\'' +
                        ",ping_status = '" + pingStatus + '\'' +
                        ",meta = '" + meta + '\'' +
                        ",guid = '" + guid + '\'' +
                        ",modified = '" + modified + '\'' +
                        ",id = '" + id + '\'' +
                        ",excerpt = '" + excerpt + '\'' +
                        ",date_gmt = '" + dateGmt + '\'' +
                        ",slug = '" + slug + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}