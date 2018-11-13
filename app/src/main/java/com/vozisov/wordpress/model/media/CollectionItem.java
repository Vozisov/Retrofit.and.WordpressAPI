package com.vozisov.wordpress.model.media;

public class CollectionItem {
    private String href;

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    @Override
    public String toString() {
        return
                "CollectionItem{" +
                        "href = '" + href + '\'' +
                        "}";
    }
}
