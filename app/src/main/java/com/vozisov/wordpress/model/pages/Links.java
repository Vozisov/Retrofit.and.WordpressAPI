package com.vozisov.wordpress.model.pages;

import java.util.List;

public class Links {
    private List<CuriesItem> curies;
    private List<RepliesItem> replies;
    private List<VersionHistoryItem> versionHistory;
    private List<AuthorItem> author;
    private List<AboutItem> about;
    private List<SelfItem> self;
    private List<CollectionItem> collection;
    private List<WpAttachmentItem> wpAttachment;

    public void setCuries(List<CuriesItem> curies) {
        this.curies = curies;
    }

    public List<CuriesItem> getCuries() {
        return curies;
    }

    public void setReplies(List<RepliesItem> replies) {
        this.replies = replies;
    }

    public List<RepliesItem> getReplies() {
        return replies;
    }

    public void setVersionHistory(List<VersionHistoryItem> versionHistory) {
        this.versionHistory = versionHistory;
    }

    public List<VersionHistoryItem> getVersionHistory() {
        return versionHistory;
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

    public void setWpAttachment(List<WpAttachmentItem> wpAttachment) {
        this.wpAttachment = wpAttachment;
    }

    public List<WpAttachmentItem> getWpAttachment() {
        return wpAttachment;
    }

    @Override
    public String toString() {
        return
                "Links{" +
                        "curies = '" + curies + '\'' +
                        ",replies = '" + replies + '\'' +
                        ",version-history = '" + versionHistory + '\'' +
                        ",author = '" + author + '\'' +
                        ",about = '" + about + '\'' +
                        ",self = '" + self + '\'' +
                        ",collection = '" + collection + '\'' +
                        ",wp:attachment = '" + wpAttachment + '\'' +
                        "}";
    }
}