package com.vozisov.wordpress.model.comments;

public class UpItem {
    private String postType;
    private String href;
    private boolean embeddable;

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostType() {
        return postType;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setEmbeddable(boolean embeddable) {
        this.embeddable = embeddable;
    }

    public boolean isEmbeddable() {
        return embeddable;
    }

    @Override
    public String toString() {
        return
                "UpItem{" +
                        "post_type = '" + postType + '\'' +
                        ",href = '" + href + '\'' +
                        ",embeddable = '" + embeddable + '\'' +
                        "}";
    }
}
