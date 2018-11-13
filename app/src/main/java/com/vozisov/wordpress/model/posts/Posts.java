package com.vozisov.wordpress.model.posts;

import java.util.List;

public class Posts {
    private String date;
    private String template;
    private String modifiedGmt;
    private Links links;
    private int author;
    private String link;
    private String format;
    private String type;
    private Title title;
    private String commentStatus;
    private Content content;
    private int featured_media;
    private List<Object> tags;
    private String pingStatus;
    private List<Object> meta;
    private boolean sticky;
    private Guid guid;
    private String modified;
    private int id;
    private List<Integer> categories;
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

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
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

    public void setFeaturedMedia(int featured_media) {
        this.featured_media = featured_media;
    }

    public int getFeaturedMedia() {
        return featured_media;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public List<Object> getTags() {
        return tags;
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

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public boolean isSticky() {
        return sticky;
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

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<Integer> getCategories() {
        return categories;
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
                "Posts{" +
                        "date = '" + date + '\'' +
                        ",template = '" + template + '\'' +
                        ",modified_gmt = '" + modifiedGmt + '\'' +
                        ",_links = '" + links + '\'' +
                        ",author = '" + author + '\'' +
                        ",link = '" + link + '\'' +
                        ",format = '" + format + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        ",comment_status = '" + commentStatus + '\'' +
                        ",content = '" + content + '\'' +
                        ",featured_media = '" + featured_media + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",ping_status = '" + pingStatus + '\'' +
                        ",meta = '" + meta + '\'' +
                        ",sticky = '" + sticky + '\'' +
                        ",guid = '" + guid + '\'' +
                        ",modified = '" + modified + '\'' +
                        ",id = '" + id + '\'' +
                        ",categories = '" + categories + '\'' +
                        ",excerpt = '" + excerpt + '\'' +
                        ",date_gmt = '" + dateGmt + '\'' +
                        ",slug = '" + slug + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}