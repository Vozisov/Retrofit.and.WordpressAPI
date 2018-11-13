package com.vozisov.wordpress.model.media;

import java.util.List;

public class Media {
    private String date;
    private String template;
    private Links links;
    private String link;
    private Description description;
    private Caption caption;
    private String type;
    private Title title;
    private MediaDetails media_details;
    private String sourceUrl;
    private int post;
    private String altText;
    private String mediaType;
    private String modified;
    private int id;
    private String dateGmt;
    private String slug;
    private String modifiedGmt;
    private int author;
    private String commentStatus;
    private String pingStatus;
    private String mimeType;
    private List<Object> meta;
    private Guid guid;
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

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Description getDescription() {
        return description;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public Caption getCaption() {
        return caption;
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

    public void setMediaDetails(MediaDetails media_details) {
        this.media_details = media_details;
    }

    public MediaDetails getMediaDetails() {
        return media_details;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getPost() {
        return post;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getAltText() {
        return altText;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaType() {
        return mediaType;
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

    public void setModifiedGmt(String modifiedGmt) {
        this.modifiedGmt = modifiedGmt;
    }

    public String getModifiedGmt() {
        return modifiedGmt;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getAuthor() {
        return author;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "Media{" +
                        "date = '" + date + '\'' +
                        ",template = '" + template + '\'' +
                        ",_links = '" + links + '\'' +
                        ",link = '" + link + '\'' +
                        ",description = '" + description + '\'' +
                        ",caption = '" + caption + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        ",media_details = '" + media_details + '\'' +
                        ",source_url = '" + sourceUrl + '\'' +
                        ",post = '" + post + '\'' +
                        ",alt_text = '" + altText + '\'' +
                        ",media_type = '" + mediaType + '\'' +
                        ",modified = '" + modified + '\'' +
                        ",id = '" + id + '\'' +
                        ",date_gmt = '" + dateGmt + '\'' +
                        ",slug = '" + slug + '\'' +
                        ",modified_gmt = '" + modifiedGmt + '\'' +
                        ",author = '" + author + '\'' +
                        ",comment_status = '" + commentStatus + '\'' +
                        ",ping_status = '" + pingStatus + '\'' +
                        ",mime_type = '" + mimeType + '\'' +
                        ",meta = '" + meta + '\'' +
                        ",guid = '" + guid + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}