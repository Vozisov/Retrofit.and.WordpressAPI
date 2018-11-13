package com.vozisov.wordpress.model.comments;

public class SelfItem {
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
                "SelfItem{" +
                        "href = '" + href + '\'' +
                        "}";
    }
}
