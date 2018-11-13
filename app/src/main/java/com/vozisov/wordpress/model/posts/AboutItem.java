package com.vozisov.wordpress.model.posts;

public class AboutItem {
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
                "AboutItem{" +
                        "href = '" + href + '\'' +
                        "}";
    }
}
