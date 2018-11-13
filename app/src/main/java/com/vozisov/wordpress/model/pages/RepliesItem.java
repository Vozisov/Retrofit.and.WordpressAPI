package com.vozisov.wordpress.model.pages;

public class RepliesItem {
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
                "RepliesItem{" +
                        "href = '" + href + '\'' +
                        ",embeddable = '" + embeddable + '\'' +
                        "}";
    }
}
