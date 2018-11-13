package com.vozisov.wordpress.model.posts;

public class AuthorItem {
    private String href;
    private boolean embeddable;

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
                "AuthorItem{" +
                        "href = '" + href + '\'' +
                        ",embeddable = '" + embeddable + '\'' +
                        "}";
    }
}
